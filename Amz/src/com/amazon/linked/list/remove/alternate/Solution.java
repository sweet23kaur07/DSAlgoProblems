package com.amazon.linked.list.remove.alternate;


public class Solution {
	public static void main(String[] args) {
		Node list = new Node();
		list.next = new Node(1);
		list.next.next = new Node(2);
		list.next.next.next = new Node(3);
		list.next.next.next.next = new Node(4);
		list.next.next.next.next.next = new Node(5);
		list.next.next.next.next.next.next = new Node(6);
		list.next.next.next.next.next.next.next = new Node(7);

		Node test = list;
		while(test != null){
			System.out.print(test.value +  " ");
			test = test.next;
		}
		System.out.println();
		GfG gfg = new GfG();
		Node res = gfg.rearrange(list);
		while(res != null){
			System.out.print(res.value + " ");
			res = res.next;
		}
	}
}

/*
reverse alternate nodes and append at the end
The input list will have at least one element  
Node is defined as */
class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;

	}
	Node() {
	}
}

class GfG
{
	Node  rearrange(Node odd)
	{
		return rearrange(odd, 1);
	}
	Node  rearrange(Node odd, int rec)
	{

		if(odd.next == null){
			return odd;
		}else{
//			odd = rearrange(odd.next, rec++);
			Node temp = rearrange(odd.next, rec++);
			Node current = odd;
			current.next = null;
			odd = temp;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = current;
			odd= temp;
		}
		return odd;
	}
}