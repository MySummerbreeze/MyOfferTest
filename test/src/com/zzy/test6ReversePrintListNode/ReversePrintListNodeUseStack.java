package com.zzy.test6ReversePrintListNode;

import java.util.Stack;

/**
 * �ٷ��Ƽ�ʹ��ջ
 * �ݹ�ʱ����ģ̫���ʹ��ʱ��Ϳռ�̫��
 * @author user
 *
 */

public class ReversePrintListNodeUseStack {
	public int[] reversePrint(ListNode head) {
		if(head == null) {
			return new int[0];
		}
		Stack<Integer> stack = new Stack<>();
		ListNode headIndex = head;
		int length = 0;
		while(headIndex != null) {
			stack.push(headIndex.val);
			headIndex = headIndex.next;
			length++;
		}
		int[] results = new int[length];
		int i = 0;
		while(i<length&&stack.peek()!=null) {
			results[i] = stack.pop();
			i++;
		}
		return results;
    }
	public static void main(String[] args) {
		ReversePrintListNodeUseStack r = new ReversePrintListNodeUseStack();
		//����һ������
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new  ListNode(2);
		
		int[] is = r.reversePrint(head);
		for (int i : is) {
			System.out.println(i);
		}
	}
}
