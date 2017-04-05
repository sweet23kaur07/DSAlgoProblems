package com.amazon.generics.multidimentional.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws ClassNotFoundException {
		GenericArray<Integer> genericArray = new GenericArray(int.class, 2, 2, 3);
		Integer[][] array = (Integer[][])genericArray.createArray();
		array[0][0] = 1;
		array[0][1] = 2;
		array[1][0] = 3;
		array[1][1] = 4;
		for(int i = 0; i < array.length ; i++){
			for(int j = 0; j < array[0].length; j++){
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		flattenArray(array);
		
	}
	
	public static <T> void flattenArray(T obj) throws ClassNotFoundException{
		if(obj.getClass().isArray()){
//			Class type = obj.getClass().getTypeName().getClass().getComponentType();
			Class type = obj.getClass().getComponentType();
			int len = obj.getClass().getName().length();
			System.out.println("We received Array : " + (len-1));
			T o = classTYpe(obj);
			for(int i = 0; i < (len-1); i++){
				 T t= (T) Array.get(obj, i);
				 if(t.getClass().isArray()){
					 int l = t.getClass().getName().length();
					 for(int j = 0; j< (l-1) ; j ++){
//							System.out.print(t[j] + " ");
						}
				 }
				 
				/*Object[] array = (Object[]) Array.get(obj, i);
				for(int j = 0; j< array.length ; j ++){
					System.out.print(array[j] + " ");
				}*/
			}
		}
		/*if(obj.getClass().getName().startsWith("[")){
			
		}*/
	}
	
	private static <T> T classTYpe(Object obj) throws ClassNotFoundException{
		return (T) Class.forName(obj.getClass().getComponentType().getName().toString());
	}
}

class GenericArray<T>{
	
	private final Class<? extends T> cls;
	int dimentions;
	List<Integer> list = new ArrayList<Integer>();
	Object arrayObj;
	
	public GenericArray(Class<? extends T> cls, int dimentions, int... length) {
		this.cls = cls;
		this.dimentions = dimentions;
		for(int len : length){
			list.add(len);
		}
	}
	
	public T[][]  createArray(){
		T[] obj = (T[])Array.newInstance(cls, list.get(0));
		Object o = new Object();
		for(int i = 1; i< dimentions ; i++){
			obj = (T[])Array.newInstance(obj.getClass(), list.get(0));
		}
		o = Array.newInstance(cls, list.get(0), list.get(1));
		int len = Array.getLength(o);
		
		this.arrayObj = o;
		return (T[][]) o;
	}
	
}
