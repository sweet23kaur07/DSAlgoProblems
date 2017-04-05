package com.amazon.valid.equation;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		String str1 = "A=B, B=D,C=D,F=G,E=H,H=C";
		String str2 = "A!=C,D!=H,F!=A";
		
		String[] str1Arr = str1.split(",");
		String[] str2Arr = str1.split(",");
		
		Set<String> set = new HashSet<String>();
		for(int i=0; i< str1Arr.length; i++){
			String[] strArr = str1Arr[i].split("=");
			if(set.contains(strArr[0]) || set.contains(strArr[1])){
				set.add(strArr[0]);
				set.add(strArr[1]);
			}else{
				
			}
		}
		
		
	}

}
