package com.zzy.test22KthFromEnd;

import com.zzy.test18DeleteListNode.ListNode;

/**
 * �ݹ鷨��
 * 		����ȫ�ֱ�����һ����Ϊ��������һ����Ϊ���ؽڵ�����ս��
 * 		�ݹ鵽�ٽ�㣬�ݹ��������ʼcount++
 * 		ֱ��count==kʱ����ǰ��head��ֵ��reslutNode
 * 		���շ���resultNode
 * @author user
 *
 */

public class ReKethFromEnd {
	int count = 0;
	ListNode resultNode = null;
	public ListNode getReKethFromEnd(ListNode head, int k) {
		if(head != null) {
			getReKethFromEnd(head.next, k);
		}else return null;
		count++;
		if(count == k) {
			resultNode = head;
		}
		return resultNode;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);
		ReKethFromEnd m = new ReKethFromEnd();
		ListNode l = m.getReKethFromEnd(head, 5);
		System.out.println(l.val);
	}
}
