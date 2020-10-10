package com.zzy.test52IntersectionNode;

/**
 * ��ָOffer��˵���ˣ����������������й����ڵ�ʱ���������еĽڵ㶼��ͬ
 * ����������ֻ����Y����״��ʾ��������X����˵ݹ���һ���ܺõĽ������
 * ���ʵ����������ͬʱ�ݹ飺
 * 		�����޷�ʵ�֡�
 * @author ��־��
 *
 */

public class IntersectionNode {
	ListNode result = null;
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null&&headB == null) return null;
		getNode(headA,headB);
        return result;
    }
	
	public void getNode(ListNode headA, ListNode headB){
		if(headA == null&&headB == null) return;
        else if(headA == null&&headB != null) getNode(headA, headB.next);
        else if(headA != null&&headB == null) getNode(headA.next, headB);
        else if(headA != null&&headB != null) getNode(headA.next, headB.next);
		if(headA == headB){
			return;
		}else{
			result = headA.next;
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
		headB.next.next.next = new ListNode(8);
		headB.next.next.next.next = new ListNode(4);
		headB.next.next.next.next.next = new ListNode(5);
		
		new IntersectionNode().getIntersectionNode(headA,headB);
	}
}
