package com.hacker.rank.intro.loop;

import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int[] array = new int[n];
            int s0 = a + (int)(Math.pow(2,0) * b);
            array[0] = s0;
            for(int j = 1; j <n ;j++){
                s0 = s0 + (int)(Math.pow(2,j) * b);
                array[j] = s0;
            }
            for(int val : array){
            	System.out.print(val + " ");
            }
            System.out.print("\n");
        }
        in.close();
    }
}
