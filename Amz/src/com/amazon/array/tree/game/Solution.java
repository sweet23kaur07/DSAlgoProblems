package com.amazon.array.tree.game;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = scan.nextInt();
		while(testcases > 0){
			int n = scan.nextInt();
			int m = scan.nextInt();
			scan.nextLine();
			int[] array = new int[n];
			int i = n-1;
			Node tree = null;
			if(array[i] == 0){
				tree = new Node(array[i]);
			}
			Node root = tree;
			i = i-1;
			while(true){
				if(i < 0){
					break;
				}
				if(array[i] == 0 && i == 0){
					break;
				}
				if(array[i] == 0){
					Node left = tree.insertNodeLeft(tree, array[i] );
				}else{
					if(i-m <0 ){
						break;
					}
					if(array[i-m] == 0){
						Node left = tree.insertNodeRight(tree, array[i-m] );
					}
				}
				i--;
			}
			if(i==0){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}

			testcases--;
		}
	}

}

class Node{
	int data;

	Node leftChild;
	Node rightChild;

	public Node(int data) {
		this.data = data;
	}

	Node insertNodeLeft(Node root, int data){
		if(root ==  null){
			root = new Node(data);
			return root;
		}else{
			Node focusNode = root;
			while(focusNode.leftChild != null){
				focusNode = focusNode.leftChild;
			}
			focusNode.leftChild = insertNodeLeft(focusNode.leftChild, data);
			return root;
		}
	}

	Node insertNodeRight(Node root, int data){
		if(root ==  null){
			root = new Node(data);
			return root;
		}else{
			Node focusNode = root;
			while(focusNode.rightChild != null){
				focusNode = focusNode.rightChild;
			}
			focusNode.rightChild = insertNodeLeft(focusNode.rightChild, data);
			return root;
		}
	}


	Node DFSTraversal(Node root, Stack stack){
		if(root.leftChild == null && root.rightChild == null){
			System.out.println(root.data);
			return root;

		}else{
			Node focusNode = root;
			//			System.out.println(focusNode.data);
			if(focusNode.leftChild != null){
				stack.push(focusNode.leftChild);
			}
			if(focusNode.rightChild != null){
				stack.push(focusNode.rightChild);
			}
			Node n = stack.isEmpty() ? null : (Node)stack.pop();
			Node t = DFSTraversal(n, stack);
			//			System.out.println(t.data);
			return root;
		}
	}
}
