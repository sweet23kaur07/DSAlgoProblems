package com.codility.time.comp.frog.jump;

class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int jump = sol.solution(5, 10, 1);
		System.out.println(jump);
	}
	
    public int solution(int X, int Y, int D) {
       if(X == Y){
    	   return 0;
       }else{
    	   int dis = Y-X;
    	   double d = dis * 1.0/D;
    	   double d1 = dis/D;
    	   double jump = d > d1 ? d1 + 1: d1 ;
    	   
    	   return (int)jump;
       }
    }
}
