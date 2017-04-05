package com.amazon.tree.inorder.predecessor;


public class Solution {

	public static void main(String[] args) {
		Tree root = new Tree("A");
		root.left = new Tree("B");
		root.right = new Tree("C");

		root.left.left = new Tree("D");
		root.left.right = new Tree("E");
		root.left.parent = root;

		root.right.left = new Tree("F");
		root.right.right = new Tree("G");
		root.right.parent = root;

		root.left.right.left = new Tree("H");
		root.right.left.right = new Tree("J");
		
		root.left.left.parent = root.left;
		root.left.right.parent = root.left;
		root.left.right.left.parent = root.left.right;
		
		root.right.left.parent = root.right;
		root.right.right.parent = root.right;
		root.right.left.right.parent = root.right.left;

		Solution sol = new Solution();
		sol.findPredecessor(root, "B");
	}

	private void findPredecessor(Tree root, String key) {
		if(root == null){
			return;
		}
		
		if(root.name == key){
			if(root.left != null){
				Tree curr = root.left;
				while(curr.right != null){
					curr = curr.right;
				}
				System.out.println(curr);
				return;
			}
			Tree parent = root.parent;
			Tree temp;
			while(parent != null && parent.right != root){
				temp = parent;
				parent = parent.parent;
				root = temp;
			}
			System.out.println(parent);
			return;
		}
		findPredecessor(root.left, key);
		findPredecessor(root.right, key);
	}

}

class Tree{
	String name;
	Tree left;
	Tree right;
	Tree parent;

	public Tree(String name) {
		this.name = name;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}

