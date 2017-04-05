package com.hacker.rank.ds.bitset;

import java.util.BitSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int op = scan.nextInt();
        BitSet[] bitArray = {new BitSet(len), new BitSet(len)};
        BitSet bit1 = new BitSet(len);
        BitSet bit2 = new BitSet(len);
        while(op > 0){
//            String line = scan.nextLine();
//            System.out.println("line" + line);
//            StringTokenizer token = new StringTokenizer(line);
//            String operation = token.nextToken();
//            int no1 = Integer.parseInt(token.nextToken());
//            int no2 = Integer.parseInt(token.nextToken());
        	String operation = scan.next();
            int no1 = scan.nextInt();
            int no2 = scan.nextInt();
            int index1 = index1 = no1 == 1 ? 0 : 1;
            int index2 = 1;
            switch(operation){
                case "AND" :
                            index2 = no2 == 1 ? 0 : 1;
                bitArray[index1].and(bitArray[index2]);
                break;
                
                case "OR" : index2 = no2 == 1 ? 0 : 1;
                bitArray[index1].or(bitArray[index2]);
                break;
                
                case "XOR" : 
                index2 = no2 == 1 ? 0 : 1;
                bitArray[index1].xor(bitArray[index2]);
                break;
                
                case "FLIP" : 
                        bitArray[index1].flip(no2);
                        break;
                
                case "SET" :
                        bitArray[index1].set(no2);
                        break;
            }
            System.out.println(bitArray[0].cardinality() + " " + bitArray[1].cardinality());
            op--;
        }
    }
}