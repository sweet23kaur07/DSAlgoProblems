package com.hacker.rank.intro.eof;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, String> map = new HashMap();
        int count = 0;
        while(scan.hasNext()){
            count++;
            String input = scan.nextLine();
            map.put(count, input);
        }
        for(Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
