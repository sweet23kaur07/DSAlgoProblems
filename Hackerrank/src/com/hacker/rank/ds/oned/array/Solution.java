package com.hacker.rank.ds.oned.array;

import java.util.Scanner;

public class Solution {
	
	private static boolean isGameOver = false;
	private static boolean isWinner = false;
	private static String result = "NO";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        while(testcases > 0){
        	isGameOver = false;
        	result = "NO";
            int n = scan.nextInt();
            int m = scan.nextInt();
            scan.nextLine();
            int[] array = new int[n];
            int[] tracedArray = new int[n];
            for(int i =0;i<n;i++){
                array[i] = scan.nextInt();
            }
            String result = jump(0,n,m,array, tracedArray);
            System.out.println(result);
            testcases--;
        }
    }
    
    private static String jump(int currentPosition, int n, int m, int[] array, int[] tracedArray){
//    	System.out.println("calling jump with cur pos : " + currentPosition);
    	tracedArray[currentPosition] = 1;
    	if(isGameOver){
//    		System.out.println("over");
    		if(isWinner(currentPosition, n)){
        		result = "YES";
        		return result;
        	}else{
        		result = "NO";
        		return result;
        	}
    	}
    	currentPosition = currentPosition + m;
    	if(isWinner(currentPosition, n)){
    		result = "YES";
    		return result;
    	}
    	
    	if(array[currentPosition] == 0){
    		tracedArray[currentPosition] = 1;
//    		System.out.println("calling jump with data : curentposition:n:m " + currentPosition + " : " + n + " : " + m);
    		return jump(currentPosition, n,m, array, tracedArray);
    	}else{
//    		System.out.println("currentpos : " + currentPosition);
    		if(currentPosition-m < 0 ){
//    			System.out.println("over");
    			isGameOver = true;
    			isWinner(currentPosition, n);
    		}else{
    			walk(currentPosition-m, n, m, array, tracedArray);
    		}
    	}
		return result;
    }
    
    private static void walk(int currentPosition, int n, int m, int[] array, int[] tracedArray){
    	tracedArray[currentPosition] = 1;
    	if(array[currentPosition+1] == 0){
    		if(tracedArray[currentPosition + 1] == 1){
//    			System.out.println("over");
    			isGameOver = true;
    			isWinner(currentPosition, n);
    		}else{
//    			System.out.println("walking +1 " + currentPosition);
        		currentPosition = currentPosition + 1;
//        		System.out.println("walked +1 " + currentPosition);
        		jump(currentPosition, n, m, array, tracedArray);
    		}
    		
    	}else{
    		if(currentPosition - 1 >=0 && array[currentPosition - 1] == 0){
    			if(tracedArray[currentPosition - 1] == 1){
//        			System.out.println("over");
        			isGameOver = true;
        			isWinner(currentPosition, n);
        		}else{
        			currentPosition = currentPosition -1;
        			jump(currentPosition, n, m, array, tracedArray);
        		}
    			
    		}else{
//    			System.out.println("over");
    			isGameOver = true;
    			isWinner(currentPosition, n);
    			
    		}
    	}
    }
    
    	
    private static boolean isWinner(int currentPosition, int n){
    	if(currentPosition >= n){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    private static boolean gameOver(int currentPosition, int n){
    	if(currentPosition >= n){
    		isGameOver = true;
    	}else{
    		isGameOver = false;
    	}
    	return isGameOver;
    }
    
    
   /* private static String checkMoves(int[] array, int n, int m){
        String result = "NO";
        int currentPosition = 0;
        int newpos = jump(currentPosition,n,m, array);
        if(newpos >= n){
            result = "YES";
            return result;
        }else if(newpos == currentPosition){
            result = "NO";
            return result;
        }
        else{
            currentPosition = newpos;
            while(currentPosition < n-1){
                if(array[currentPosition+1] == 0){
                     currentPosition++;
                }else{
                      newpos = jump(currentPosition, n,m, array);
                    if(newpos >= n){
                            result = "YES";
                            break;
                        }else if(newpos == currentPosition){
                            result = "NO";
                            break;
                        }else{
                        currentPosition = newpos;
                        continue;
                    }
                }
            }
        }
        if(currentPosition == n-1){
            result = "YES";
        }
        return result;
    }
   */ 
   /* private static int jump(int currentPosition, int n, int m, int[] array){
        int newPosition = 0;
        if(currentPosition + m > n){
            newPosition = currentPosition + m;
        } else if(currentPosition+m < n && array[currentPosition+m] == 0){
            newPosition = currentPosition + m;
        } else{
            newPosition = currentPosition;

        }
        return newPosition;
    }*/
}