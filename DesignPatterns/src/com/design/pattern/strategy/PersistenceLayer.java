package com.design.pattern.strategy;

public interface PersistenceLayer {
	
	public <T> void update(T object);

}
