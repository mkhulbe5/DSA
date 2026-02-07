package com.dsa;

import com.dsa.CycleInLinkedList.ListNode;

public class IntersectionPointInCycle {

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	
	public ListNode intersectionPoint(ListNode head) {
		ListNode small = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			small = small.next;
			fast = fast.next.next;
		}
		if (small == fast)
			small = head;
		
		while(small != fast) {
			small = small.next;
			fast = fast.next;
		}
		return small;

	}
}
