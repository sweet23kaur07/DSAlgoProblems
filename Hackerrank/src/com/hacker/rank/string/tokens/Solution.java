package com.hacker.rank.string.tokens;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if(s.isEmpty()){
        	System.out.println(0);
        }else{
        	 String[] array = s.trim().split("[ !,?._'@]+");
             System.out.println(array.length);
             for(String token : array){
             	System.out.println(token);
             }
        }
       
        scan.close();
    }
}

