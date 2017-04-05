package com.design.pattern.observer;

import java.util.Scanner;

public class TestObserver {

	public static void main(String[] args) {
		Subject stockGrabber =  new StockGrabber();
		
		/*Observer ob1 = new IBM(stockGrabber);
		Observer ob2 = new APPLE(stockGrabber);
		Observer ob3 = new GOOGLE(stockGrabber);*/
		
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i< 5; i++){
			String str = scan.nextLine();
			String[] token = str.split(" ");
			double price  = Double.parseDouble(token[1]);
			String type = token[0];
			stockGrabber.updatePrice(type, price);
		}
		
	}

}
