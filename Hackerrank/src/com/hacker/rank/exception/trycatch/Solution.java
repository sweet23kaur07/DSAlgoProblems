package com.hacker.rank.exception.trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

    private Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        try{
            int numerator = sol.get_int(false);
            int denominator = sol.get_int(true);
            System.out.println(numerator/denominator);
        }catch(ArithmeticException e){
            System.out.println(e);
        }catch(InputMismatchException e){
            System.out.println(e);
        }
    }
    
    private int get_int(boolean isDenominator) throws InputMismatchException, ArithmeticException{
        int input;
        try{
             input = scan.nextInt();
        }catch(Exception e){
            throw new InputMismatchException();
        }
        
        if(isDenominator){
            if(input == 0)
                throw new ArithmeticException("/ by zero");
        }
        return input;
        
    }
}