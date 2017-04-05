package com.codility.live.test.t;

class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int val = sol.solution(5,7);
		System.out.println(val);
		System.out.println(0&1&2&3&4&5&6&7&8&9&10);
	}

	public int solution(int M, int N) {
		/*int val = 0;
		val = M;
		for(int i = M+1; i <= N ; i++){
			val = val & (i);
		}*/
		
		long xor =M^N;
		long shift =xor>>1;
		while(shift!=0){
			xor= xor|shift;
			shift>>=1;
		}
		return (int) (M&N&~xor);
		
		/*
		Long binary =0L;
		while(M < N){
			String s = Integer.toBinaryString(M);
			Long bin1 = Long.parseLong(s, 10);
			System.out.println(bin1);
			String s1 = Integer.toBinaryString(M+1);
			Long bin2 = Long.parseLong(s1, 10);
			System.out.println(bin2);

			binary = AND(bin1,bin2);
			M++;

		}*/
//		return val;
	}

	private Long AND(Long bin, Long bin1) {
		// TODO Auto-generated method stub
		return null;
	}
}