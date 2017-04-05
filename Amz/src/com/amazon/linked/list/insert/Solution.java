package com.amazon.linked.list.insert;

import java.util.Scanner;

public class Solution {

	
	public static  Node insert(Node head,int data) {
       /* if(head == null){
            head = new Node(data);
            return head;
        }*/
        //meth 1
       /* Node temp =  insert(head.next, data);
        head.next = temp;
        return head;*/
        //meth 2
     /*  Node temp = head;
        while(temp.next!= null){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
        head = temp;
        return head;*/
        //meth 3
        if (head == null) {
            return new Node(data);
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = new Node(data);
            return head;
        }

    }

	public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}

class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
}