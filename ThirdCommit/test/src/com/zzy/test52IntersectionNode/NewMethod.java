package com.zzy.test52IntersectionNode;

/**
 * ��������ĳ��Ȳ�һ�����������ǿ��Խ�������������A����ѭ�����֮���B�����ͷ����ʼѭ������B������ͬ
 * @author ��־��
 *
 */

//ͨ��
public class NewMethod {
	ListNode A = null;
	ListNode B = null;
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null||headB == null){
			return null;
		}
		A = headA;
		B = headB;
		ListNode result = getNode(headA,headB);
		return result;
	}
	public ListNode getNode(ListNode headA, ListNode headB){
		//������߶���Ϊ�գ����ж��Ƿ���ȣ�������������һ��ѭ��
		if(headA!=null&&headB!=null){
			if(headA == headB) return headA;
			return getNode(headA.next,headB.next);
		}else if(headA==null&&headB!=null){//���AΪ�գ���A����һ���ڵ�ָ��B��ͷ�ڵ�
			return getNode(B,headB);
		}else if(headA!=null&&headB==null){
			return getNode(headA,A);
		}else{
			return null;
		}
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
		
		new NewMethod().getIntersectionNode(headA.next.next,headA);
	}
}
