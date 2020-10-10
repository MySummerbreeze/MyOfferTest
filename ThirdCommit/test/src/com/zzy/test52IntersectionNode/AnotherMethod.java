package com.zzy.test52IntersectionNode;

import java.util.*;

/**
 * ��ʹ�õݹ飬����ʹ��ջ��ѹ��ջ֮������ջͬʱ��������¼��ǰ������ֵ�����鿴��һ������ֵ�Ƿ����
 * @author ��־��
 *
 */

public class AnotherMethod {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null||headB == null){//��һ���߽紦��
			return null;
		}
		//��������ջ��
		Stack<ListNode> a = new Stack<>();
		Stack<ListNode> b = new Stack<>();
		//������Aѹ��ջ
		while(headA != null){
			a.push(headA);
			headA = headA.next;
		}
		while(headB != null){
			b.push(headB);
			headB = headB.next;
		}
		ListNode result = null;
		//ͬʱ��ջ��
		while(!a.isEmpty()&&!b.isEmpty()){
			if(a.peek() == b.peek()){
				result = a.pop();
				b.pop();
			}else{
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ListNode headA = new ListNode(4);
		headA.next = new ListNode(1);
		headA.next.next = new ListNode(8);
		headA.next.next.next = new ListNode(4);
		headA.next.next.next.next = new ListNode(5);
		
		ListNode headB = new ListNode(5);
		headB.next = new ListNode(0);
		headB.next.next = new ListNode(1);
		headB.next.next.next = headA.next.next;
		
		new AnotherMethod().getIntersectionNode(null,headB);
	}
}
