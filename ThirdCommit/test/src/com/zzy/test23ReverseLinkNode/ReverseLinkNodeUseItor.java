package com.zzy.test23ReverseLinkNode;

import java.util.Stack;

import com.zzy.test18DeleteListNode.ListNode;

/**
 * ʹ�õ�����
 * 		����֪����ջ�Ľṹ���Ƚ������ʹ��ջ������ת������Ϊ���ʣ�ʱ�临�Ӷ�ֻ��ҪO(2n)
 * 
 * @author user
 *
 */

public class ReverseLinkNodeUseItor {
	public ListNode reverseList(ListNode head) {
		if(head == null) {
			return head;
		}
		//����һ��ջ
		Stack<Integer> stack = new Stack<>();
		while(head != null) {
			stack.push(head.val);
			head = head.next;
		}
		ListNode index = new ListNode(stack.pop());
		ListNode resulthead= index;
		while(!stack.isEmpty()) {
			index.next = new ListNode(stack.pop());
			index = index.next;
		}
		return resulthead;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);
		ReverseLinkNodeUseItor m = new ReverseLinkNodeUseItor();
		ListNode l = m.reverseList(head);
		while(l != null) {
			System.out.print(l.val+" ");
			l = l.next;
		}
	}
}
