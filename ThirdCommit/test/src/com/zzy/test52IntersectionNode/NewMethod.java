package com.zzy.test52IntersectionNode;

/**
 * 两个链表的长度不一样，但是我们可以将其连起来，当A链表循环完成之后从B链表的头部开始循环，而B链表相同
 * @author 张志琰
 *
 */

//通过
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
		//如果两者都不为空，则判断是否相等，不相等则进行下一次循环
		if(headA!=null&&headB!=null){
			if(headA == headB) return headA;
			return getNode(headA.next,headB.next);
		}else if(headA==null&&headB!=null){//如果A为空，则A的下一个节点指向B的头节点
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
