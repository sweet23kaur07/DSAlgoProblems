package com.codility.live.hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;*/

//import for Scanner and other utility classes
import java.util.*;


class TestClass1 {
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

        int[][] A = new int[N][N];
        int[][] B = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            //create N8N matrix A
            
             for (int j = 0; j < N; j++){
                 A[i][j] = s.nextInt();
             }
        }
         for (int i = 0; i < N; i++) {
            //create N8N matrix B
           
             for (int j = 0; j < N; j++){
                 B[i][j] = s.nextInt();
             }
        }
        int[][] C = multiply(A,B, N);

        for(int i=0; i<N; i++)
    	{
    		for(int j=0; j<N; j++)
    		{
    			System.out.print(C[i][j] + " ");
    		}
    		System.out.println();
    	}
        
        System.out.println("Hello World!");
    }
    
    private static int[][] multiply(int[][] A, int[][] B, int N){
    	int[][] C = new int[N][N];
    	int sum = 0;
    	for(int i=0; i<N; i++)
    	{
    		for(int j=0; j<N; j++)
    		{
    			sum=0;
    			for(int k=0; k<N; k++)
    			{
    				sum = sum + A[i][k] * B[k][j];
    			}
    			C[i][j] = sum;
    		}
    	}
    	return C;
    }
}
