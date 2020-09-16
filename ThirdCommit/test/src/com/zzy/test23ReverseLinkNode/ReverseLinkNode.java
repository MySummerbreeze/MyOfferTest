package com.zzy.test23ReverseLinkNode;

import com.zzy.test18DeleteListNode.ListNode;
import com.zzy.test22KthFromEnd.ReKethFromEnd;

/**
 * ��ת����
 * 		�����뵽�ݹ飺
 * 		��������ȫ�ֱ�����һ����Ϊ���շ���ֵ��һ����Ϊ������
 * 		���ף���ʼ��ֵ���½�������������ǰֵ����������������������ֵ�����շ���ֵ....
 * ��ǰdemoΪLeetCode��һ��������demo
 * @author user
 *
 */

public class ReverseLinkNode {
	public ListNode reverseList(ListNode head) {
		//head==null���жϵ�һ��head == null
		if(head == null||head.next == null) {
			return head;
		}
		//�ݹ���ã����մ��׷��ص������һ��ֵ
		ListNode result = reverseList(head.next);
		//���׷���֮��head�ǵ����ڶ���ֵ��head.next�����һ��ֵ��head.next.next�����һ��ֵ����һ���ڵ㣬ָ��head������һ����·
		head.next.next = head;
		//�ƻ���·
		head.next = null;
		return result;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);
		ReverseLinkNode m = new ReverseLinkNode();
		ListNode l = m.reverseList(head);
		while(l != null) {
			System.out.print(l.val+" ");
			l = l.next;
		}
	}

	
}


/*ListNode newHead = null;
ListNode newNode = null;
public ListNode reverseList(ListNode head) {
	if(head == null) {
		return head;
	}
	reverse(head);
    return newHead;
}

public void reverse(ListNode head) {
	if(head.next != null) {
    	reverse(head.next);
    }else {
    	//newNode��Ϊ�����Ľڵ�
    	newNode = new ListNode(head.val);
    	//newHead��Ϊͷ�ڵ�
    	newHead = newNode;
    	return;
    }
	newNode.next = new ListNode(head.val);
	newNode = newNode.next;
}*/