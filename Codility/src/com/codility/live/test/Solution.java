package com.codility.live.test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
//		int[] A = {5,4,0,3,1,6,2};
		int[] A = {0,1,2,3,5,4,6};
		int c = sol.solution(A);
		System.out.println("Count : " + c);
	}
	
	public int solution(int[] A) {
		Map<Integer, Integer> map = new ConcurrentHashMap();
		if(A.length == 0){
			return 0;
		}
		Set<Integer> set = new HashSet<Integer>();
		int maxElement = 0;
		//check for all elems
		for(int i =0; i< A.length;i++){
			int j = i;
			while(true){
				int val = A[j];
				if(set.contains(val)){
					break;
				}
				set.add(val);
				j = val;
				//ooi
				if(j>=A.length){
					break;
				}
			}
			//check size of set
			int setCount = set.size();
			maxElement = setCount > maxElement ? setCount : maxElement;
			//clear set for next iteration
			set.clear();
		}
		return maxElement;
    }

}
