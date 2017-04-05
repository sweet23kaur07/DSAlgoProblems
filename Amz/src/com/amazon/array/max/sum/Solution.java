package com.amazon.array.max.sum;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String[] strArr = str.split(" ");
		int[] arr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
		
		int max1 = arr[0];
		int max2 = arr[1];
			
		for(int i=2; i < arr.length; i++){
			if(i % 2 == 0 ){
				if(arr[i] > max1 && (max1 +arr[i] < arr[i])){
					max1 = arr[i];
				}else{
					int maxT = max1 + arr[i];
					max1 = maxT > max1 ? maxT : max1;
				}
			}else if(i% 2 != 0 ){
				if(arr[i] > max2 && (max2 +arr[i] < arr[i])){
					max2 = arr[i];
				}else{
					int maxT = max2 + arr[i];
					max2 = maxT > max2 ? maxT : max2;
				}
			}
		}
		
		int max = max1 > max2 ? max1 : max2;
		System.out.println(max);
	}
}
