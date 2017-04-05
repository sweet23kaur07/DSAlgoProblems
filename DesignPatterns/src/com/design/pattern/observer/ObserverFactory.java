package com.design.pattern.observer;

public class ObserverFactory {
	
	private static final String IBM = "IBM";
	private static final String GOOGLE = "GOOGLE";
	private static final String APPLE = "APPLE";
	
	private Observer ibm ;
	private Observer google ;
	private Observer apple ;

	public Observer getInstance(String type, Subject stockGrabber){
		Observer o = null;
		if(type.equalsIgnoreCase(IBM)){
			if(ibm == null){
				ibm = new IBM(stockGrabber);
			}
			 o= ibm;
		}else if(GOOGLE.equalsIgnoreCase(type)){
			if(google == null){
				google = new GOOGLE(stockGrabber);
			}
			 o= google;
		}else if(APPLE.equalsIgnoreCase(type)){
			if(apple == null){
				apple = new APPLE(stockGrabber);
			}
			 o= apple;
		}
		return o;
	}
}
