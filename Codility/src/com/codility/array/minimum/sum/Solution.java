package com.codility.array.minimum.sum;

class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {3,2};
		int dif = sol.solution(A);
		System.out.println("Final Diff is : " + dif);
	}

	public int solution(int[] A) {
		int sumMinus = 0;
		int sum = 0;
		int diff = Integer.MAX_VALUE;
		
		for(int i=0;i<A.length;i++){
			sum = sum+A[i];
		}
		for(int i=0;i<A.length-1;i++){
			sumMinus = sumMinus + A[i];
			sum = sum - A[i];
			int differ = Math.abs(sum - sumMinus);
			System.out.println("Diff : " + differ);
			if(differ < diff){
				diff = differ;
			}
		}
		return diff;
	}
}
