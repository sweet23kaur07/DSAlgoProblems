package com.hacker.rank.big.numbers.integer.a;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger a = scan.nextBigInteger();
        BigInteger b = scan.nextBigInteger();
        BigInteger sum = a.add(b);
        BigInteger mul = a.multiply(b);
        System.out.println(sum);
        System.out.println(mul);
    }
}
