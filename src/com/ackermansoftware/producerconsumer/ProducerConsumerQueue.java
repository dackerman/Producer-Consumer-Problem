package com.ackermansoftware.producerconsumer;

public interface ProducerConsumerQueue<T> {
	public void put(T value);
	public T get();
}
