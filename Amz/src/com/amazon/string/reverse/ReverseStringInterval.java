package com.amazon.string.reverse;

public class ReverseStringInterval {
	
	public static void main(String[] args) {
		String s = "SWeet";
		int interval = 2;
		System.out.println(reverseFrom(interval, s));
		
	}
	
	public static String reverseFrom(int interval, String string){
		StringBuilder builder = new StringBuilder();
		
		if(interval < string.length()){
			builder.append(string.substring(interval-1, string.length())).reverse();
			return builder.toString();
		}else{
			builder.append(string).reverse();
			return builder.toString();
		}
	}

}
