package com.codility.live.hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;*/

//import for Scanner and other utility classes
import java.util.Scanner;


class TestClass {
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
        int max = 0;

        for (int i = 0; i < N; i++) {
        	 String str = s.next();
             char[] chars = str.toCharArray();
             boolean[] visited = new boolean[26];
             //start traversing
             int k = 0;
             while(k < (str.length()-1)){
            	 for(int j = chars.length-1; j >k ;j--){
                	 //if already visited?
                	 char toCheck = chars[k];
                	 int index = toCheck - 'a';
                	 if(!visited[index] && toCheck == chars[j]){
                		 int dis = j-k;
                		 max = dis > max ? dis : max;
                	 }else{
                		 continue;
                	 }
                 }
            	 k++;
             }
             System.out.println(max-1);
             max = 0;
        }
    }
}
