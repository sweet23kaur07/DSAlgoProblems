package com.amazon.linked.list.remove.alternate;


public class MaxPalindromeLikedListSpaceComplexity1 {
	
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
		int count = maxPalindrome(list);
		System.out.println(count);
	}
	
	public static int maxPalindrome(Node head){
		int count = maxPalindromeRec(head, head.next, 0);
		return count;
	}

	private static int maxPalindromeRec(Node head, Node next, int count) {
		if(next.next != null){
			return maxPalindromeRec(head, next.next, count);
		}
		else{
			if(head.value == next.value){
				count = count+2;
			}else{
				Node rec = head;
				while(rec.next != next){
					rec = rec.next;
				}
				rec.next = null;
				 count = maxPalindromeRec(head, rec, count);
//				int count2 =  maxPalindromeRec(head.next, next, count);
//				count = count1 > count2 ? count1 : count2;
			}
		}
		return count;
	}

}

