package com.codility.array.fibbonaci.frog;

class Solution {
	int[] fibSer;
	int count = 0;
	int gap = -100;
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,1,1,1,0,0,0,1,0,1,0,1,0,1,1,1,0,0,0,1,0,0,0,0}; //2
		int c = sol.solution(A);
		System.out.println("Count : " + c);
	}

	public int solution(int[] A) {
		int len = A.length;
		fibSer = new int[len+2];
		for(int i = 0; i<= len+1; i++){
			fibSer[i] = fib(i);
			if(fibSer[i] > len)
				break;
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
//			System.out.println("Fib : " + N);
			return true;
		}
		int index = calcilateIndexofOne(A);
		if(index == -1){
			return false;
		}else{
			int[] B = new int[index+1];
			for(int i =0; i <B.length;i++){
				B[i] = A[i];
			}
			boolean res =  canJump(B, index+1);
			if(res){
				int diff = N-(index+1);
				if(isFibbo(diff)){
					count++;
					
					if(isFibbo(gap+diff)){
						count--;
						gap = gap+diff;
					}
					gap = diff > gap? diff : gap;
				}
			}
			return res;
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
