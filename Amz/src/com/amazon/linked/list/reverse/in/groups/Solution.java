package com.amazon.linked.list.reverse.in.groups;


public class Solution {

	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
		Solution sol = new Solution();
		Node reverList = sol.reverseList(head, 2);
	}

	public Node reverseList(Node head, int K){
		Node h = head;
		Node previus = null;
		Node current = head;
		int count = 0;
		
		while(current !=  null && count < K){
			Node temp = current.next;
			current.next = previus;
			previus = current;
			current = temp;
			count++;
		}
		head = previus;
		if(current != null){
			h.next = reverseList(current, K);
		}
		
		return previus;
		
	}
}

class Node{
	int data;
	Node next;
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}
