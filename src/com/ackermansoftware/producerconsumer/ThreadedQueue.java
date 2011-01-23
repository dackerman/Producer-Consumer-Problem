package com.ackermansoftware.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadedQueue<T> implements ProducerConsumerQueue<T>{
	private final Queue<T> q;
	private final int size;
	
	private final Object consumerLock = new Object();
	private final Object producerLock = new Object();
	
	public ThreadedQueue(int size){
		this.size = size;
		q = new LinkedList<T>();
	}

	@Override
	public void put(T value) {
		while(!lockAndPut(value)){
			System.out.println("List is full - wait for consumer!");
			objectWait(producerLock);
		}
		synchronized(consumerLock){
			consumerLock.notify();
		}
	}

	private boolean lockAndPut(T value) {
		synchronized (q){
			if(q.size() < size){
				q.add(value);
				return true;
			}else{
				return false;
			}
		}
	}

	@Override
	public T get() {
		T value = lockAndPoll();
		while(value == null){
			System.out.println("List is empty - wait for producer!");
			objectWait(consumerLock);
			value = lockAndPoll();
		}
		synchronized(producerLock){
			producerLock.notify();
		}
		return value;
	}

	private T lockAndPoll() {
		synchronized(q){
			T value = q.poll();
			return value;
		}
	}

	private void objectWait(Object lock) {
		try {
			synchronized(lock){
				lock.wait();
			}
		} catch (InterruptedException e) {
		}
	}
}
