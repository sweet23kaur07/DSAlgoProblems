package com.amazon.sort.topological.sort.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
	Stack<Graph> stack = new Stack<Graph>();
	Set<Graph> visitedSet = new HashSet<Graph>();
	int verteces = 0;
	
	public static void main(String[] args) {
		Graph A = new Graph("A");
		Graph B = new Graph("B");
		Graph C = new Graph("C");
		Graph D = new Graph("D");
		Graph E = new Graph("E");
		Graph F = new Graph("F");
		Graph G = new Graph("G");
		
		A.children.add(B);
		A.children.add(E);
		A.children.add(G);
		
		C.children.add(G);
		
		D.children.add(B);
		D.children.add(F);
		D.children.add(G);
		
		E.children.add(D);
		E.children.add(G);
		
		Solution sol = new Solution();
		for(int i = 0; i < 7; i++){
			sol.sort(A);
		}
		
		sol.print();
	}
	
	public void sort(Graph root){
		if(visitedSet.contains(root)){
			stack.push(root);
			return;
		}
		visitedSet.add(root);
		for(Graph child : root.children){
			if(!visitedSet.contains(child)){
				sort(child);
//				stack.push(child);
			}
		}
		stack.push(root);
	}
	
	public void print(){
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}

}


class Graph{
	String name;
	List<Graph> children;
	
	public Graph(String name) {
		this.name = name;
		this.children = new ArrayList<Graph>();
	}
	
	@Override
	public String toString() {
		return this.name + " : ";
	}
}