package com.dsa;

public class CycleInLinkedList {

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public boolean hasCycle(ListNode head) {
		ListNode small = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			small = small.next;
			fast = fast.next.next;
		}
		if (small == fast)
			return true;
		else
			return false;

	}
}
