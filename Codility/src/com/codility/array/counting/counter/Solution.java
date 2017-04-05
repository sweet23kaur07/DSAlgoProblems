package com.codility.array.counting.counter;

class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {3,4,4,6,1,4,4,5,7,8,9,2,3,4,5,6,7,7,7,7,7,7,7,7,7,7,7,7,7,3,4,5,2,43,56,7,4,54,6,56,433,34,5,6,3,3,45,6,5,3,43,45,5,45,3,4,5,4,34,4,4,3,5,4};
		int[] val = sol.solution(1000, A);
		for(int i : val){
			System.out.print(i + " ");
		}
	}
	
 public int[] solution(int N, int[] A) {
	 	int[] counters = new int[N];
	 	
	 	for(int i=0;i<N;i++){
	 		counters[i] = 0;
	 	}
	 	int max = 0;
	 	for(int i=0;i<A.length;i++){
	 		if(A[i] > N){
	 			updateAll(counters, max);
	 		}else{
	 			increament(counters, A[i]);
	 			if(counters[A[i]-1] > max){
		 			max = counters[A[i]-1];
		 		}
	 		}
	 	}
	 	return counters;
 }
 
  private void increament(int[] counters, int x){
	  int counter = counters[x-1];
	  counter = counter +1;
	  counters[x-1] = counter;
  }
  
  private void updateAll(int[] counters, int max){
	  for(int i=0;i<counters.length;i++){
	 		counters[i] = max;
	 	}
	 	
  }
}