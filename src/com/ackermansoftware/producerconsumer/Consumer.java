package com.ackermansoftware.producerconsumer;

public class Consumer extends ProducerConsumer{
	
	public Consumer(ThreadedQueue<Integer> q, String name, int waitTime) {
		super(q, name, waitTime);
	}

	@Override
	public void run() {
		while(true){
			sleepForSeconds();
			Integer value = q.get();
			System.out.println("Consumer ("+name+") got value " + value);
		}
	}

}
