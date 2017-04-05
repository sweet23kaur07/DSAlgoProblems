package com.codility.array.missing.element2;

import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {2};
		int elem =sol.solution(A);
		System.out.println(elem);
	}
	
	public int solution(int[] A) {
		int len = A.length;
		int natSum = ((len + 1) * (len + 2))/2;
		int sum = 0;
		for(int i = 0; i < len; i++){
			sum = sum + A[i];
		}
		
		int noMissing = Math.abs(natSum - sum);
		return noMissing;
		
    }

}
