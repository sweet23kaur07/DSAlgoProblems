package com.amazon.dp.coin.change;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	static Map<Coin, Long> map = new HashMap<Coin, Long>();
	
	public static void main(String[] args) {
//		int[] S ={41, 34, 46, 9, 37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8 ,45 ,19, 30, 29, 18, 35, 11};
		int[] S ={1,2,3};
		int N=5;
		Solution sol = new Solution();
		long no = sol.coinChange(S, N);
		System.out.println(no);
//		map.forEach((k,v) -> System.out.println(k + ": " + v));
	}

	public long coinChange(int[] S, int N){
		System.out.println("-----------------");
		System.out.print("N : " + N + " || ");
		for(int i = 0; i < S.length ; i++){
			System.out.print(S[i] + " ");
		}
		System.out.println();

		if(N < 0 || S.length < 1){
			return 0;
		}
		if(N==0){
			System.out.println();
			Coin C = new Coin(S, N);
			map.put(C, 1L);
			return 1;
		}

		if(S.length >= 1){
			int len = S.length;
			int[] S1 = Arrays.copyOfRange(S, 0, len-1);
			long c1 ;
			long c2 = 0;
			
			//memoziation
			Coin C1 = new Coin(S1, N);
			Coin C2 = new Coin(S, N-S[len-1]);
			
			if(map.get(C1) != null){
				c1 = map.get(C1);
				System.out.println("memorized 1" + c1);
			}else{
				c1 = coinChange(S1, N);
				map.put(C1, c1);
			}
			if(N-S[len-1] >= 0 ){
				if(map.get(C2) != null){
					System.out.println("memorized 2" + c2);
					c2 = map.get(C2);
				}else{
					c2 = coinChange(S, N-S[len-1]);
					map.put(C2, c2);
				}
			}
			/*if(c1>0 || c2>0){
				c1 = c1<0 ? 0 : c1;
				c2 = c2<0 ? 0 : c2;
			}*/
			return c1+c2;
		}
		return 0;
	}
}

class Coin{
	int[] S;
	int N;
	
	public Coin(int[] S, int N) {
		this.S = S;
		this.N = N;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + N;
		result = prime * result + Arrays.hashCode(S);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coin other = (Coin) obj;
		if (N != other.N)
			return false;
		if (!Arrays.equals(S, other.S))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coin [S=" + Arrays.toString(S) + ", N=" + N + "]";
	}
	
	
}
