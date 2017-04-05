package com.codility.live.hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;*/

//import for Scanner and other utility classes
import java.util.*;
import java.util.Map.Entry;


class TestClass4 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        int[] A = new int[N];
        Map<Integer, Long> map = new HashMap();

        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
            int key = A[i] % K;
            if(map.get(key) != null){
            	long val = map.get(key);
            	map.put(key, val+1);
            }else{
            	map.put(key, 1L);
            }
        }
        Long sum = new Long(0);
        for(Entry<Integer, Long> entry : map.entrySet()){
        	long mod = entry.getValue();
        	sum = sum + (mod * (mod-1));
        }
        
        System.out.println(sum);
    }
}

