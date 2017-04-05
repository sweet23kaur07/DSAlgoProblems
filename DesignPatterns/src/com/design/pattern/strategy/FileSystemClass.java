package com.design.pattern.strategy;

public class FileSystemClass implements PersistenceLayer {

	@Override
	public <T> void update(T object) {
		throw new RuntimeException("Filesystem update not supported");
	}

}
