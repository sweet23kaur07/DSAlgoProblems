package com.amazon.recurssion.phone.alpha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
	public static int index = 0;

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.SetMap();
		int[] numbers = {1,2,9};
		int n = numbers.length;
		String res = "";
		String[] resArray = new String[(int) Math.pow(3, n)];
		resArray = sol.recurse(0, res, numbers, resArray);
		for(String s : resArray){
			System.out.print(s + ",");
		}
	}
	
	public String[] recurse(int noIndex, String res, int[] numbers, String[] resArray){
		if(noIndex == numbers.length){
			index++;
			return null;
		}
		
		List<String> alphas = map.get(numbers[noIndex]);
		for(String alpha : alphas){
			resArray[index] = res + alpha;
//			index++;
			recurse(noIndex + 1, resArray[index], numbers, resArray);
		}
		
		return resArray;
	}
	
	public void SetMap(){
		List<String> s1 = new ArrayList<String>();
		List<String> s2 = new ArrayList<String>();
		List<String> s3 = new ArrayList<String>();
		List<String> s4 = new ArrayList<String>();
		List<String> s5 = new ArrayList<String>();
		List<String> s6 = new ArrayList<String>();
		List<String> s7 = new ArrayList<String>();
		List<String> s8 = new ArrayList<String>();
		List<String> s9 = new ArrayList<String>();
		
		String[] sa1 = {"a", "b","c"};
		s1 = Arrays.asList(sa1);
		String[] sa2 = {"d", "e","f"};
		s2 = Arrays.asList(sa2);
		String[] sa3 = {"g", "h","i"};
		s3 = Arrays.asList(sa3);
		String[] sa4 = {"j", "k","l"};
		s4 = Arrays.asList(sa4);
		String[] sa5 = {"m", "n","o"};
		s5 = Arrays.asList(sa5);
		String[] sa6 = {"p", "q","r"};
		s6 = Arrays.asList(sa6);
		String[] sa7 = {"s", "t","u"};
		s7 = Arrays.asList(sa7);
		String[] sa8 = {"v", "w","x"};
		s8 = Arrays.asList(sa8);
		String[] sa9 = {"y", "z"};
		s9 = Arrays.asList(sa9);
	
		map.put(1, s1);
		map.put(2, s2);
		map.put(3, s3);
		map.put(4, s4);
		map.put(5, s5);
		map.put(6, s6);
		map.put(7, s7);
		map.put(8, s8);
		map.put(9, s9);
	}

}
