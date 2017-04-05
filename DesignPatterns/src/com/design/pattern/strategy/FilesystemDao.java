package com.design.pattern.strategy;

public class FilesystemDao extends Dao {

	@Override
	public <T> void insert(T object) {
		System.out.println("Inserting filesystem entry");
	}

}
