package com.codility.live.test.booking.com;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;*/

//import for Scanner and other utility classes
import java.util.*;
import java.util.Map.Entry;


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
        Map<Character, Integer[]> map = new HashMap();
        int max = 0;

        for (int i = 0; i < N; i++) {
            String str = s.next();
            char[] chars = str.toCharArray();
            //populate map
            for(int j = 0; j < chars.length; j++){
                char c = chars[j];
                if(map.get(c) != null){
                	Integer[] list = map.get(c);
                    list[1] = j;
                    map.put(c,list);
                }else{
                	Integer[] list = new Integer[2];
                    list[0] = j;
                    map.put(c,list);
                }
            }
            for(Entry<Character, Integer[]> entry : map.entrySet()){
            	Integer[] list = entry.getValue();
                if(list[1] != null){
                    int startIndex = list[0];
                    int lastIndex = list[1];
                    max = (lastIndex-startIndex) > max ? (lastIndex-startIndex) : max;
                    if(max == str.length()-2){
                    	break;
                    }
                }else{
                    continue;
                }
            }
            System.out.println(max-1);
            //clear map and max for next test case
            map.clear();
            max = 0;
        }
    }
}
