package com.hacker.rank.ds.priority.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Student{
	private int token;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getToken() {
		return token;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PriorityQueue<Student> queue = new PriorityQueue<Student>(
				Comparator.comparing(Student :: getCgpa).reversed().
				thenComparing(Student :: getFname).
				thenComparing(Student :: getToken));
		
		int totalEvents = Integer.parseInt(in.nextLine());
		while(totalEvents>0){
			String event = in.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(event);
			if(tokenizer.nextToken().equalsIgnoreCase("ENTER")){
				String fname = tokenizer.nextToken();
				double cgpa = Double.parseDouble(tokenizer.nextToken());
				int token = Integer.parseInt(tokenizer.nextToken());
				Student student = new Student(token, fname, cgpa);
				queue.add(student);
			}else{
				queue.poll();
			}
			totalEvents--;
		}
		
		if(queue.isEmpty()){
			System.out.println("EMPTY");
		}else{
			while(!queue.isEmpty()){
				System.out.println(queue.poll().getFname());
			}
		}
	}
}

