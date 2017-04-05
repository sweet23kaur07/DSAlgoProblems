package com.amazon.linked.list.sorted.merge;

public class Solution {

	public static void main(String[] args) {
		Node list1 = new Node(1, new Node(2, new Node(4, new Node(8, new Node(9, null)))));
		Node list2 = new Node(3, new Node(5, new Node(6, new Node(7, null))));
		
		Solution sol = new Solution();
		Node list = sol.mergeList(list1, list2);
		Node curr = list;
		while(curr != null){
			System.out.print(curr.data + " ");
			curr = curr.next;
		}

	}
	
	public Node mergeList(Node head1, Node head2){
		
		Node curr1 = head1;
		Node curr2 = head2;
		Node previus = null;
		
		while(curr1 != null && curr2 != null){
			if(curr1.data <= curr2.data){
				System.out.println("c1 <= c2 " + curr1.data + " : " + curr2.data);
				if(previus != null){
					previus.next = curr1;
				}
				previus = curr1;
				curr1 = curr1.next;
			}else{
				System.out.println("c1 > c2 " + curr1.data + " : " + curr2.data);
				if(previus != null){
					previus.next = curr2;
				}
				previus = curr2;
				curr2 = curr2.next;
			}
		}
		
		if(curr2 == null){
			previus.next = curr1;
		}else if(curr1 == null){
			previus.next = curr2;
		}
		
		return head1;
	}
}


class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}