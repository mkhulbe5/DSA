package com.dsa;

public class PalindromeList {

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

	public boolean isPalindrome(ListNode head) {
		ListNode firstHead = midNode(head);
		ListNode nhead = firstHead.next;
		nhead = reverseList(nhead);

		ListNode c1 = firstHead;
		ListNode c2 = nhead;

		while (c1 != null && c2 != null) {
			if (c1.val != c2.val)
				return false;
		}
		nhead = reverseList(nhead);
		firstHead.next = head;
		return true;
	}

}
