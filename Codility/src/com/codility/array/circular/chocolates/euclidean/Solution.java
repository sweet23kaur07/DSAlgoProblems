package com.codility.array.circular.chocolates.euclidean;


class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int count = sol.solution(5,1);
		System.out.println(count);
	}
	
	
	public int solution(int N, int M) {
		
		/*List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<N;i++){
			list.add(i);
		}
		
		//start from 0
		list.add(0, -1); 
		int pos=0;
		int count=1;
		while(true){
			int x = (pos + M) % N;
			if(list.get(x) < 0 ){
				break;
			}else{
				list.add(x, -1); 
				count++;
			}
			pos = x;
		}
		
		return count;*/
		
		int a;
		int b;
		if(N > M){
			a = N;
			b = M;
		}else{
			a= M;
			b=N;
		}
		
		while(b!=0){
			int t = b;
			b = a % b;
			a = t;
		}
		System.out.println("GCD : " + a);
		return N/a;
	}
}