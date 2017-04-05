package com.codility.live.test.booking.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        Map<Character, Integer> map = new HashMap();
		String str = s.nextLine();
        char[] chars = str.toCharArray();
		int no = 3331112;
		int index = -1;
		int max = -1;

		String[] arr = String.valueOf(no).split("");
		for(int i = 1; i < arr.length; i++){
			if(Integer.parseInt(arr[i]) >= max){
				max = Integer.parseInt(arr[i]);
				index = i;
			}
		}
		System.out.println("index : " + index);
		int startIndex =0;
		while(startIndex < index){
			if(Integer.parseInt(arr[startIndex]) >= max){
				startIndex++;
			}else{
				break;
			}
		}
		String temp = arr[startIndex];
		arr[startIndex] = arr[index];
		arr[index]= temp;

//		for(String s : arr){
//			System.out.print(s);
//		}

	}
}
