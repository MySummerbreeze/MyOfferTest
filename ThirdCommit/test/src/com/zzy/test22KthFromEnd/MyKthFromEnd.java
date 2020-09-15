package com.zzy.test22KthFromEnd;

/**
 * Ñ­»·£º
 */

import com.zzy.test18DeleteListNode.ListNode;

/**
 * 
 * @author user
 *
 */
public class MyKthFromEnd {
	
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode index = head;
		int count = 0;
		while(index != null) {
			count++;
			index = index.next;
		}
		if(count<k) {
			return null;
		}
		while(count-k>0) {
			count--;
			head = head.next;
		}
		return head;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		MyKthFromEnd m = new MyKthFromEnd();
		ListNode l = m.getKthFromEnd(head, 2);
		System.out.println(l.val);
	}
}
