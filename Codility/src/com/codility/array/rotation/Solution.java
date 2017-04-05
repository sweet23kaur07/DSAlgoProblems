package com.codility.array.rotation;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class Solution {
	
	public static void main(String[] args) {
		double d = 5 * 1.0 / 2;
		double d1 = 5 / 2;
		System.out.println(d);
		System.out.println(d1);
		Solution sol = new Solution();
//		int[] A = {9,3,9,3,9,7,9};
		int[] A = {1,2,3};
		for(int i : A){
			System.out.print(i + " ");
		}
		
		int[] val = sol.solution(A,7);
		System.out.println();
		for(int i : val){
			System.out.print(i + " ");
		}
	}
	
	
    public int[] solution(int[] A, int K) {
    	int len = A.length;
    	if(len <= 1){
    		return A;
    	}
    	while(K >= len){
    		K = K-len;
    	}
    	
    	Queue<Integer> q = new ArrayBlockingQueue<Integer>(len);
    	
		for(int i =0 ; i< len; i++){
			q.add(A[i]);
		}
    	
		for(int i = K; ; ){
			if(i == len){
				i = 0;
			}
			if(q.isEmpty()){
				break;
			}
			A[i] = q.poll();
			i++;
		}
    	return A;
    }
}