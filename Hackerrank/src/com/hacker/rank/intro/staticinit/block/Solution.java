package com.hacker.rank.intro.staticinit.block;

import java.util.Scanner;

public class Solution {

	private static boolean flag = true;
	private static int B;
	private static int H;

	static {
	    try{

	    	input();
	    }catch(Exception e){
	        System.out.println(e);
	    }
	    
	}

	private static void input() throws Exception{
	    Scanner scan = new Scanner(System.in);
	    B = scan.nextInt();
	    H = scan.nextInt();
	    if(B <= 0 || H <= 0){
	    	System.out.println("cond fail");
	        flag = false;
	        throw new Exception("Breadth and height must be positive");
	    }
	}
	public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

