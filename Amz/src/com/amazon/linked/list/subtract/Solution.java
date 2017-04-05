package com.amazon.linked.list.subtract;

public class Solution {
	public static void main(String[] args) {
		Node l1 = new Node(1);
		l1.next = new Node(0);
		l1.next.next = new Node(0);
		Node test = l1;
		while(test != null){
			System.out.print(test.data);
			test = test.next;
		}
		System.out.println();
		Node l2 = new Node(1);
		
		GfG gfg = new GfG();
		Node res = gfg.sublinkedList(l1, l2);
		while(res != null){
			System.out.println(res.data);
			res = res.next;
		}
		
	}
}

/* Structure of Linked list node*/
class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class GfG
{
	/*You are required to complete this method*/
	Node sublinkedList(Node l1, Node l2)
	{
		int l1No = listNo(l1);
		int l2No = listNo(l2);
		int resNo = 0;
		int size;
		if(l1No > l2No){
			resNo = l1No-l2No;
		}
		return createList(resNo);
	}

	Node createList(int no){
		int rem = no % 10;
		no = no/10;
		Node list = new Node(rem);
		while(no != 0){
			rem = no % 10;
			Node newList = new Node(rem);
			newList.next = list;
			list = newList;
			no =no/10;
		}
		return list;
	}

	int listNo(Node l){
		int lNo = 0;
		Node current = l;
		while(current!=null){
			lNo = lNo * 10 + current.data;
			System.out.print(lNo);
			current = current.next;
		}
		System.out.println();
		System.out.println(lNo);
		return lNo;
	}
}