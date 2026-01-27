package com.dsa;

public class MergeSortedLists {

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode mergeLists(ListNode head, ListNode head2) {

		ListNode c1 = head;
		ListNode c2 = head2;

		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;

		while (c1 != null && c2 != null) {
			if (c1.val < c2.val) {
				prev.next = c1;
				c1 = c1.next;
			} else {
				prev.next = c2;
				c2 = c2.next;
			}
			prev = prev.next;
		}

		prev.next = c1 != null ? c1 : c2;
		return dummy;
	}
}
