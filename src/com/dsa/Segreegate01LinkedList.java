package com.dsa;

import java.util.LinkedList;

public class Segreegate01LinkedList {

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

	public ListNode fetch01LinkedList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode zero = new ListNode(-1);
		ListNode zerop = zero;

		ListNode one = new ListNode(-1);
		ListNode onep = one;

		ListNode curr = head;

		while (curr != null) {
			if (curr.val == 0) {
				zerop.next = curr;
				zerop = zerop.next;
			} else {
				onep.next = curr;
				onep = onep.next;
			}
			curr = curr.next;
		}

		zerop.next = one.next;
		onep.next = null;
		return zero.next;
	}

}
