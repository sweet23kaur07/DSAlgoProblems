package com.hacker.rank.ds.deque;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        Set<Integer> uniqueElements = new HashSet();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            uniqueElements.add(num);
            deque.addLast(num);
            if(deque.size() == m){
            	int first = (int) deque.getFirst();
            	if(uniqueElements.size() > max)
            		max = uniqueElements.size();
            	
            	deque.removeFirst();
            	
            	if(!deque.contains(first)){
            		uniqueElements.remove(first);
            	}
            }
        }
        System.out.println(max);
    }
}

