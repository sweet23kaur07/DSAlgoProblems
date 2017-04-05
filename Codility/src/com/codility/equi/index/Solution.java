package com.codility.equi.index;

class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {-7, 1, 5, 2, -4, 3, 0};
		int s =sol.solution(A);
		System.out.println(s);
	}
	
	public int solution(int[] A) {
		int sumLeft = 0;
		int sumRight = 0;
//		int eq = 1;
		for(int i= 0; i < A.length; i++){
			sumRight =  sumRight  + A[i];
		}
		for(int i= 0; i < A.length; i++){
			sumRight =  sumRight  - A[i];
			if(sumLeft == sumRight){
				return A[i];
			}
			sumLeft = sumLeft + A[i];
			
		}
		return -1;
	}
}
