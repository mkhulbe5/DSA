package com.dsa;

public class ReverseInGroups {

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

	
	public static int length(ListNode head) {
		ListNode curr = head;
		int len = 0;
		while(curr != null) {
			curr = curr.next;
			len++;
		}
		return len;
	}
	
	static ListNode th = null;
	static ListNode tt = null;
	public  static void addNodeInFront(ListNode head) {
		if(th == null) {
			th = head;
			tt= head;
		}
		else {
			head.next = th;
			th = head;
		}
	}
	
	
	public static ListNode reverseInGroups(ListNode head,int k) {
		if(head == null || head.next == null || k == 1)return head;
		
		int len = length(head);
		ListNode oh = null;
		ListNode ot = null;
		ListNode curr = head;
	   while(len >= k) {
		   int tempk = k;
		   
		   while(tempk -- > 0) {
			ListNode forw = curr.next;
			curr.next = null;
			addNodeInFront(curr);
			curr = forw;
		   }
		   
		   if(oh == null) {
			   oh = th;
			   ot = tt;
		   }
		   else {
			 oh.next = th;
			 ot = tt;
		   } 
		   th = null;
		   tt = null;
		   len -= k;

	   }
	   
	   ot.next = curr;
	   return oh;
	}
	
}
