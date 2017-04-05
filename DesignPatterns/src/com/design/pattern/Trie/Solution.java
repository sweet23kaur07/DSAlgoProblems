package com.design.pattern.Trie;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TrieP trie = new TrieP();
		for(int a0 = 0; a0 < n; a0++){
			String op = in.next();
			String contact = in.next();
			if(op.equals("add")){
				trie.add(contact);
			}else if(op.equals("find")){
				int count = trie.find(contact);
				System.out.println(count);
			}
		}
	}
}

class TrieP{
	char c;
	TrieP[] children = new TrieP[26];
	boolean isWord;

	public void add(String s){
		if(s.isEmpty()){
			this.isWord = true;
			return;
		}

		char letter = s.charAt(0);
		int index = letter - 'a';
		if(this.children[index] == null){
			this.children[index] = new TrieP();
			this.children[index].c = letter;
		}

		this.children[index].add(s.substring(1));
	}

	public int find(String s){
		if(s.isEmpty()){
			int count = count(this,0);
			return count;
		}

		char letter = s.charAt(0);
		int index = letter - 'a';
		if(this.children[index] == null){
			return 0;
		}
		return this.children[index].find(s.substring(1)); 
	}

	private int count(TrieP trie, int count){
		if(trie.isWord){
			count++;
		}
		int index = count;
		for(int i=0; i<26;i++){
			if(trie.children[i] != null){
				index = count(trie.children[i],index);
			}
		}
		return index;
	}
}
