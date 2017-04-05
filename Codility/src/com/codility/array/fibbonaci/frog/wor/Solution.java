package com.codility.array.fibbonaci.frog.wor;


class Solution {
	int[] fibSer;
	int count = 0;
	int gap = -100;
	int currFib = 0;
	int fibIndex = -1;
	public static void main(String[] args) {
		Solution sol = new Solution();
//		int[] A = {0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,1,1,1,0,0,0,1,0,1,0,1,0,1,1,1,0,0,0,1,0,0,0,0}; //2
		int[] A = {1,1,1,1,1,1,1,1,1,1,1};
		int c = sol.solution(A);
		System.out.println("Count : " + c);
	}

	public int solution(int[] A) {
		int len = A.length;
		fibSer = new int[len+2];
		for(int i = 0; i<= len+1; i++){
			fibSer[i] = fib(i);
			if(fibSer[i] > len){
				currFib = fibSer[i-1];
				fibIndex = i-1;
				break;
			}

		}

		for(int i = 0; i<= len+1; i++){
			System.out.print(fibSer[i] + " ");
		}
		System.out.println();
		if(A[len-1] == 1 && isFibbo(len)){
			count= count+2;
			return count;
		}
		canJump(A, len+1);
		//		System.out.println(count);

		return count;
	}

	private boolean canJump(int[] A, int N) {
		if(isFibbo(N)){
			count++;
			return true;
		}else{
			while(true){
				if(currFib > A.length){
					break;
				}
				if(A[currFib-1] ==1){
					break;
				}else{
					fibIndex = fibIndex -1;
					currFib = fibSer[fibIndex];
				}
			}

			int bLength = (N) - currFib;
			int[] B = new int[bLength];
			System.out.println("BLength : " + B.length);
			System.out.println("A.Lenght : " + A.length);
			for(int i =0; i <B.length;i++){
				B[i] = A[bLength-1];
				bLength++;
			}
			return canJump(B, B.length + 1);

		}
	}

	private int calcilateIndexofOne(int[] A) {
		for(int i = A.length-2; i>=0;i--){
			if(A[i] == 1){
				return i;
			}
		}
		return -1;
	}

	private boolean isFibbo(int n) {
		/*for(int i = 0; i<fibSer.length; i++){
			if(n == fibSer[i]){
				return true;
			}
		}*/	
		for(int i = fibSer.length-1; i>=0; i--){
			if(n == fibSer[i]){
				return true;
			}
		}
		return false;
	}

	private int fib(int len){
		if(len == 0){
			return 0;
		}
		if(len ==1 || len == 2){
			return 1;
		}

		return fib(len-1) + fib(len-2);
	}
}
