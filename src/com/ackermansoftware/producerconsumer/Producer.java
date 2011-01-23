package com.ackermansoftware.producerconsumer;

public class Producer extends ThreadedQueueActor{

	public Producer(ThreadedQueue<Integer> q, String name, int waitTime) {
		super(q, name, waitTime);
	}

	@Override
	public void run() {
		while (true) {
			sleepForSeconds();
			Integer rand = getRandom();
			System.out.println(name + " generated Random number " + rand);
			q.put(rand);
			System.out.println("Producer sleeping...");
		}
	}

	private Integer getRandom() {
		return Integer.valueOf((int) (Math.random() * 100));
	}
}
