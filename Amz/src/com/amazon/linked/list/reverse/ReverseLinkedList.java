package com.amazon.linked.list.reverse;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node list = new Node(5, new Node(6, new Node(7, null)));
		System.out.println(list);
		Node reverList = list.reverse(list);
		System.out.println(reverList);
	}
	
}

class Node{
	@Override
	public String toString() {
		return "LinkedListNode [data=" + data + ", next=" + next + "]";
	}

	public Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	int data;
	Node next;
	
	/*public LinkedListNode reverse(LinkedListNode list){
		return reverseL(list, list.next);
	}*/
	
	public Node reverseL(Node head, Node next){
		if(next.next == null){
			return new Node(next.data, head);
		}
		
		return reverseL(next, next.next);
	}
	
	public Node reverse(Node head) {
	    if (head == null) {
	      return head;
	    }
	    Node previous = null;
	    Node current = head;
	    while (current != null) {
	      Node t = current.next;
	      current.next = previous;
	      previous = current;
	      current = t;
	    }
	    return previous;
	  }
}
