package com.hacker.rank.ds.stack.braces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		Map<Character, Character> braceMap = new HashMap<Character, Character>();
		braceMap.put(')','(');
		braceMap.put('}','{');
		braceMap.put(']','[');
		
		while (sc.hasNext()) {
			Stack<Character> stack = new Stack<Character>();
			boolean isBalanced = false;
			boolean extraBrace = false;
			int pushCount =0;
			int popCount = 0;
			String input=sc.next();
			char[] charArray = input.toCharArray();
			for(char brace : charArray){
				//closing brace
				if(braceMap.get(brace) != null){
					if(!stack.isEmpty()){
						if(braceMap.get(brace).equals(stack.peek())){
							stack.pop();
							popCount++;
						} else{
							isBalanced = false;
							break;
						}
					}else{
						isBalanced = false;
						extraBrace = true;
						break;
					}
				} //opening brace
				else{
					stack.push(brace);
					pushCount++;
				}
				
			}//end of for loop
			if(pushCount == popCount && !extraBrace){
				isBalanced = true;
			}
			System.out.println(isBalanced);
		}

	}
}
