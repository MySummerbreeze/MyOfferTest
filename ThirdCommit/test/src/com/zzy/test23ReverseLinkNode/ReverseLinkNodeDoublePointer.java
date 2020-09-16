package com.zzy.test23ReverseLinkNode;

import com.zzy.test18DeleteListNode.ListNode;

/**
 * LeetCode�ⷨ��
 * 		˫ָ�룺
 * 			����ָ�룬һ��ָ��ǰһ����һ��ָ���һ����ѭ��һ�飬��ָ��ָ��ǰָ�룬���demo
 * @author user
 *
 */

public class ReverseLinkNodeDoublePointer {
	public ListNode doublePointer(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode before = null;
		ListNode after = head;
		while(after.next != null) {
			ListNode tmp = after;
			after = after.next;
			tmp.next = before;
			before = tmp;
		}
		after.next = before;
		return after;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		/*head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);*/
		ReverseLinkNodeDoublePointer m = new ReverseLinkNodeDoublePointer();
		ListNode l = m.doublePointer(head);
		while(l != null) {
			System.out.print(l.val+" ");
			l = l.next;
		}
	}
}
