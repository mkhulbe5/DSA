package com.dsa;

import com.dsa.CycleInLinkedList.ListNode;

public class ReverseList {

	
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)return head;
		
		ListNode curr = head;
		ListNode forward = null;
		ListNode prevNode = null;
		
		while(curr != null) {
			forward = curr.next;
			curr.next = prevNode;
			prevNode = curr;
			curr = forward;
		}
		return prevNode;
	}
}
