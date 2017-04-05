package com.design.pattern.strategy;

public abstract class Dao {
	
	PersistenceLayer persLayer;
	
	public abstract <T> void insert(T object);
	
	public  <T> void update(T object){
		if(persLayer != null){
			 persLayer.update(object);
		}else{
			System.out.println("update not supported");
		}
	}
	
	public void setpersLayer(PersistenceLayer persLayer){
		this.persLayer = persLayer;
	}

}
