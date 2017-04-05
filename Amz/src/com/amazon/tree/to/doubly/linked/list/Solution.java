package com.amazon.tree.to.doubly.linked.list;

public class Solution {
	
	private Tree head = null;
	private Tree tail = null;
	private Tree current = null;
	
	
	public static void main(String[] args) {
		Tree root = new Tree(10);
		root.left = new Tree(8);
		root.right = new Tree(12);
		
		root.left.left = new Tree(7);
		root.left.right = new Tree(9);
		root.right.left = new Tree(11);
		root.right.right = new Tree(13);
		Solution sol = new Solution();
		sol.treeToList(root);
		sol.printList(sol.head);
		sol.printReverseList(sol.tail);
	}
	
	public void treeToList(Tree root){
		if(root == null){
			return;
		}
		
		treeToList(root.left);
		
		//add nodes to list
		if(tail!=null){
			tail = root;
		}
		if(head == null){
			head = root;
			current = root;
			tail = root;
		}else{
			Tree temp = current;
			current.right = root;
			current = root;
			current.left = temp;
		}
		
		treeToList(root.right);
	}
	
	public void printList(Tree head) 
    {
        System.out.println("Extracted Double Linked List is : ");
        while (head != null) 
        {
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.println();
    }
	
	public void printReverseList(Tree tail) 
    {
        System.out.println("Extracted Reverse Double Linked List is : ");
        while (tail != null) 
        {
            System.out.print(tail.data + " ");
            tail = tail.left;
        }
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
