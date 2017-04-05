package com.design.pattern.strategy;

public class DatabaseClass implements PersistenceLayer {

	@Override
	public <T> void update(T object) {
		System.out.println("Updating database objects");
	}

}
