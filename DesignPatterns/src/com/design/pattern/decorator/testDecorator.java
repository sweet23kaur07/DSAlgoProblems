package com.design.pattern.decorator;

public class testDecorator {

	public static void main(String[] args) {
		BookFlight bookFlight = new AddMeal(new BookFlightCore());
		String s = bookFlight.bookFlight();
		System.out.println(s);
	}

}
