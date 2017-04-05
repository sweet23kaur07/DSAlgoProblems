package com.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject{
	
	List<Observer> observers = null;
	private double ibmprice;
	private double appleprice;
	private double googleprice;
	
	public StockGrabber() {
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void registerSubscriber(Observer newObserver) {
		observers.add(newObserver);
	}

	@Override
	public void unregisterSubscriber(Observer deleteObserver) {
		observers.remove(deleteObserver);
	}

	@Override
	public void updatePrice(String type, double price) {
		ObserverFactory factory = new ObserverFactory();
		Observer o = factory.getInstance(type, this);
		o.updatePrice(price);
		
		/*if(type.equalsIgnoreCase("IBM")){
			this.ibmprice = price;
		}else if(type.equalsIgnoreCase("APPLE")){
			this.appleprice = price;
		}else if(type.equalsIgnoreCase("GOOGLE")){
			this.googleprice = price;
		}
		for(Observer o : observers){
			if(o instanceof IBM){
				o.updatePrice(ibmprice);
			}else if(o instanceof APPLE){
				o.updatePrice(appleprice);
			}else if(o instanceof GOOGLE){
				o.updatePrice(googleprice);
			}
			
		}*/
	}

}
