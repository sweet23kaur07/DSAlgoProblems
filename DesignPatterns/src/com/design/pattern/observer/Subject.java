package com.design.pattern.observer;

public interface Subject {
	
	void unregisterSubscriber(Observer newObserver);
	void updatePrice(String type, double price);
	void registerSubscriber(Observer newObserver);
	

}
