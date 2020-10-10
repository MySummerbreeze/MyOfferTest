package com.zzy.test52IntersectionNode;

/**
 * 剑指Offer中说明了，当两个单向链表有公共节点时，其后的所有的节点都相同
 * 即两个链表只能以Y的形状表示而不能是X，因此递归是一个很好的解决方法
 * 如何实现两个链表同时递归：
 * 		最终无法实现。
 * @author 张志琰
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
