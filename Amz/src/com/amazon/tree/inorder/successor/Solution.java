package com.amazon.tree.inorder.successor;

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
		sol.findSuccessor(root, null, "D");
	}

	public void findSuccessor(Tree root, Tree previus, String key){
		if(root == null){
			return;
		}
		Tree curr= null;

		if(root.name == key){
			if(root.right != null){
				curr = root.right;
				while(curr != null){
					if(curr.left != null){
						curr = curr.left;
					}else{
						break;
					}
				}
				System.out.println("Found : " + curr.name);
				return;
			}
			//chech previus
			if(previus != null){
				//if previus left child
				/*if(previus.left == root){
					System.out.println("Found at left : " + previus.name);
					return;
				}else if(previus.right == root){*/
					Tree parent = previus;
					while(parent != null && parent.left != root){
						parent = parent.parent;
						root = previus;
						previus = parent;
					}
					System.out.println("Found at right : " + parent);
					return;
				}
			System.out.println("Riit node : " + root);
//			}
		}

		findSuccessor(root.left, root, key);
		findSuccessor(root.right, root, key);
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
