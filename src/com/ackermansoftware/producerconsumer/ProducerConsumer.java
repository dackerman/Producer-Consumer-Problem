package com.ackermansoftware.producerconsumer;

public class ProducerConsumer extends Thread{
	
	protected final ThreadedQueue<Integer> q;
	protected final String name;
	private final int waitTime;

	public ProducerConsumer(ThreadedQueue<Integer> q, String name, int waitTime) {
		this.q = q;
		this.name = name;
		this.waitTime = waitTime;
	}

	protected void sleepForSeconds() {
		try {
			sleep(waitTime);
		} catch (InterruptedException e) {
		}
	}

}
