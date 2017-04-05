package com.codility.binary.gap;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int no = 2147483647;
		int len = sol.solution(no);
		System.out.println(Integer.toBinaryString(no) + ": " + len);
	}


	public int solution(int N) {
		int pre = -1;
		int len = 0;
		int currK = -1;
		while (N > 0) {
			//			System.out.println("No : " + Integer.toBinaryString(N));
			//			System.out.println("-No : " + Integer.toBinaryString(-N));
			//			System.out.println("N&o : " + Integer.toBinaryString(N & -N));
			int k = N & -N;
			currK = k;
			int count = 0;
			while(currK != 0){
				currK = currK/2;
				count++;
			}
			System.out.println("K is  "  + k);
			//			int curr = (int) Math.log(k);
			int curr = count;
			System.out.println("current : " + curr);
			System.out.println("Previous : " + pre);

			N = N & (N - 1);

			/*if (pre != -1 && (Math.abs(curr - pre) ) > len) {
				len = Math.abs(curr - pre) -1 ;
			}*/
			if (pre != -1 && (Math.abs(curr - pre) ) > len) {
				len = Math.abs(curr - pre) -1 ;
			}
			pre = curr;
		}

		return len;
	}


}
