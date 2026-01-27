package com.dsa;

public class FoldLinkedList {

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode midNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode forw;
		while (curr != null) {
			forw = curr.next;
			curr.next = prev;
			prev = curr;
			curr = forw;
		}
		return prev;
	}

	public void foldList(ListNode head) {

		if (head == null || head.next == null)
			return;

		ListNode mid = midNode(head);
		ListNode nhead = mid.next;
		mid.next = null;
		nhead = reverseList(nhead);

		ListNode c1 = head;
		ListNode c2 = nhead;

		ListNode f1 = null;
		ListNode f2 = null;

		while (c1 != null && c2 != null) {
			f1 = c1.next;
			f2 = c2.next;

			c1.next = c2;
			c2.next = f1;

			c1 = f1;
			c2 = f2;
		}
	}
}
