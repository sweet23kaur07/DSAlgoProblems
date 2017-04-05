package com.design.pattern.strategy;

public class DatabaseDao extends Dao {

	@Override
	public <T> void insert(T object) {
		System.out.println("Inserting database entry");
	}

}
