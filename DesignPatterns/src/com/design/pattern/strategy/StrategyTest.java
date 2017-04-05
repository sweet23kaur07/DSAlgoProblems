package com.design.pattern.strategy;

public class StrategyTest {

	public static void main(String[] args) {
		Dao dao = new DatabaseDao();
		dao.update("sweet");
		
//		PersistenceLayer persLayer = new DatabaseClass();
		PersistenceLayer persLayer = new FileSystemClass();
		dao.setpersLayer(persLayer);
		dao.update("sweet");
	}

}
