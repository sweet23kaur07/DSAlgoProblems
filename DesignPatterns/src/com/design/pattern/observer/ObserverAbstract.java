package com.design.pattern.observer;

public abstract class ObserverAbstract implements Observer {

	@Override
	public abstract void updatePrice(double price) ;

	@Override
	public Observer getInstance(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
