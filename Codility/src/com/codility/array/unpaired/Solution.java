package com.codility.array.unpaired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {9,3,9,3,9,7,9};
		int val = sol.solution(A);
		System.out.println(val);
	}
	
    public int solution(int[] A) {
    
        Map<Integer, List<Integer>> map = new HashMap();
        
        for(int i=0; i< A.length; i++){
            if(map.get(A[i]) == null){
                List<Integer> list = new ArrayList();
                list.add(i);
                map.put(A[i], list);
            }else{
                List<Integer> list = map.get(A[i]);
                list.add(i);
                map.put(A[i], list);
            }
        }
        for(Entry<Integer, List<Integer>> entry : map.entrySet()){
        	int size = entry.getValue().size()%2;
        	if(size != 0){
        		return entry.getKey();
        	}
        }
		return 0;
    }
}