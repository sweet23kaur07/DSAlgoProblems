package com.design.pattern.observer;

public class IBM extends ObserverAbstract implements Observer {

	private double price ;
	private Subject stockGrabber;

	public IBM(Subject stockGrabber) {
		this.stockGrabber = stockGrabber;
		stockGrabber.registerSubscriber(this);
	}

	@Override
	public void updatePrice(double price) {
		this.price = price;
		display();
	}

	private void display(){
		System.out.println("Price updated for IBM " + price);
	}

}
