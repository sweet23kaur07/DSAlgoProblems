package com.codility.live.hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;*/

//import for Scanner and other utility classes
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class TestClass3 {
	
	private static Map<String, Integer> map = new HashMap();
	
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
        int M = s.nextInt();
        int K = s.nextInt();
        int[][] A = new int[N][M];

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M ;j++){
            	A[i][j] = s.nextInt();
            }
        }
        while(K > 0){
        	int R = s.nextInt();
        	int C = s.nextInt();
        	int S = s.nextInt();
        	int D = s.nextInt();
        	 queries1(R-1,C-1,S,D, A);
        	K--;
        }
        printMatrix(A, N, M);
    }
    
    private static void printMatrix(int[][] A, int N, int M){
    	int print = 0;
    	for(int i=0; i<N; i++)
    	{
    		for(int j=0; j<M; j++)
    		{
    			String key = (i) + ":" + (j);
    			if(map.get(key) != null){
        			 print = map.get(key);
        		}else{
        			print = A[i][j];
        		}
    			System.out.print(print + " ");
    		}
    		System.out.println();
    	}
    }
    private static int[][] queries(int R, int C, int S, int D , int[][] A){
    	for(int i = R; i < R+S ; i++){
    		for(int j = C ; j< C+S; j++){
    			A[i][j] = A[i][j] + D;
    		}
    	}
    	return A;
    }
    private static void queries1(int R, int C, int S, int D, int[][] A){
    	String key = null;
    	int colSize = S;
    	int rowSize = S;
    	int col = C;
    	while(rowSize > 0){
    		while(colSize > 0){
        		key = R + ":" + col;
        		if(map.get(key) != null){
        			int val = map.get(key);
        			map.put(key, val+D);
        		}else{
        			map.put(key, A[R][col] + D);
        		}
        		col++;
        		colSize--;
        	}
    		R++;
    		col = C;
    		rowSize--;
    		colSize = S;
    	}
    	
    }
   
}

