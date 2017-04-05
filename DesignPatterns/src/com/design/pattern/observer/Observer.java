package com.design.pattern.observer;

public interface Observer {
	
	void updatePrice(double price);
	Observer getInstance(String type);

}
