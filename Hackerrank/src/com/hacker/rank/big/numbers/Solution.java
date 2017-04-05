package com.hacker.rank.big.numbers;

import java.math.BigDecimal;
import java.util.*;
class Solution{
	public static void main(String []args){
		//Input
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		String []s=new String[n];
		for(int i=0;i<n;i++){
			s[i]=sc.next();
		}
		sc.close();

		String[] x = Arrays.copyOf(s, n);
		Arrays.sort(s, Collections.reverseOrder(Comparator.comparing(BigDecimal :: new)));
//		s = x;
		//Output
		for(int i=0;i<n;i++)
		{
			System.out.println(s[i]);
		}
	}
}
