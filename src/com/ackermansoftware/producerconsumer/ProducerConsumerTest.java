package com.ackermansoftware.producerconsumer;

public class ProducerConsumerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadedQueue<Integer> q = new ThreadedQueue<Integer>(5);
		Producer p = new Producer(q, "BOB", 500);
		Producer p2 = new Producer(q, "DAVE", 500);
		Producer p3 = new Producer(q, "JAMES", 500);
		Producer p4 = new Producer(q, "SWETA", 500);
		Producer p5 = new Producer(q, "SWETA2", 500);
		
		Consumer c = new Consumer(q, "fred", 100);
		p.start();
		p2.start();
		c.start();
		p3.start();
		p4.start();
		p5.start();
	}

}
