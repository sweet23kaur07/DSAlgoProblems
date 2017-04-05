package com.amazon.tree.twod.array;

public class Solution {
	private static final int padding = 7;

	public static void main(String[] args) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		
		root.left.left = new Tree(4);
		root.left.right = new Tree(5);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		printNode(root, 5);
	}

	public static void printNode(Tree t, int space){
		if(t == null){
			return;
		}
		
		int spaceR = space + padding;
		printNode(t.right, spaceR);
		String pad = String.format("%" + space + "s", t.data);
		System.out.println(pad);
		int spaceL = space + padding;
		printNode(t.left, spaceL);
	}
}

class Tree{
	int data;
	Tree left;
	Tree right;
	
	public Tree(int data) {
		this.data = data;
	}
	
}