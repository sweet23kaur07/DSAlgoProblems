package com.codility.array.missing.element;

import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {1,2,3,4,5};
		int elem =sol.solution(A);
		System.out.println(elem);
	}
	
	public int solution(int[] A) {
		int len = A.length;
		if(len == 0){
			return 1;
		}
		/*if(len == 1){
			return 0;
		}*/else{
			Arrays.sort(A);
			
			int start = 0;
			int end = len -1;
			while(start != end && start <= end){
				int mid = (end + start)/2;
				if(A[mid] == mid+1){
					//inc
					start = mid + 1;
				}else{
					end = mid;
				}
			}
			System.out.println(start + ": " + end);
			return start+1;
		}
    }

}
