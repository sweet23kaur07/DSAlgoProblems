package com.design.pattern.decorator;

public class AddMeal extends BookFlightWrapper {

	public AddMeal(BookFlight bookFlight) {
		this.bookFlight = bookFlight;
	}
	
	@Override
	public String bookFlight() {
		return bookFlight.bookFlight() +  ", with meal";
	}

}
