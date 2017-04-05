package com.amazon.tree.from.inorder.preorder;

import java.util.Arrays;

public class Solution {
	private static int index = 0;

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] inOrder = {"D", "B", "E", "A", "H", "F", "C", "G"};
		String[] preOrder = {"A","B", "D", "E", "C", "F", "H", "G"};
		
		Tree root = sol.createTree(preOrder, inOrder);
		sol.print(root);
	}
	
	public Tree createTree(String[] preOrder, String[] inOrder){
		if(inOrder.length == 0 ){
			return null;
		}
		if(inOrder.length == 1){
			String name = inOrder[0];
			Tree node = new Tree(name);
			index++;
			return node;
		}
		
		String name = preOrder[index];
		index++;
		Tree root = new Tree(name);
		
		int i=0;
		for(i=0; i < inOrder.length ; i++){
			if(name.equals( inOrder[i]))
				break;
		}
		
		//i is the index
		root.left = createTree(preOrder, Arrays.copyOfRange(inOrder, 0, i));
		root.right = createTree(preOrder, Arrays.copyOfRange(inOrder, i+1, inOrder.length));
		
		return root;
	}
	
	public void print(Tree root){
		if(root == null){
			return;
		}
		
		print(root.left);
		System.out.print(root.name + " ");
		print(root.right);
	}
}

class Tree{
	String name;
	Tree left;
	Tree right;
	
	public Tree(String name) {
		this.name = name;
		this.left = null;
		this.right = null;
	}
}