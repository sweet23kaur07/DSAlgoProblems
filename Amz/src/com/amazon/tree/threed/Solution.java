package com.amazon.tree.threed;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	static int  maxHeight = -1;
	
	public static void main(String[] args) {
		Node root = new Node(1, 3);
		root.children[0] = new Node(2, 0);
		root.children[1] = new Node(3, 2);
		root.children[2] = new Node(4, 1);
		
		root.children[1].children[0] = new Node(5, 0);
		root.children[1].children[1] = new Node(6, 1);

		root.children[2].children[0] = new Node(7, 0);
		
		root.children[1].children[1].children[0] = new Node(8, 0);
		
		printNode(root, 0);
		
	}
	
	
	public static void printNode(Node root, int height){
		if(root == null){
			return;
		}
		if(height > maxHeight){
			System.out.println(root.id);
			maxHeight = height;
		}
		height = height+1;
		for(int i = root.children.length-1; i >= 0; i-- ){
			Node child = root.children[i];
			printNode(child, height);
		}
	}

}

class Node{
	int id;
	Node[] children;
	
	public Node(int data, int size) {
		this.id = data;
		children = new Node[size];
	}
	
}
