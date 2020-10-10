package com.zzy.test52IntersectionNode;

import java.util.*;

/**
 * 不使用递归，可以使用栈，压完栈之后两个栈同时弹出，记录当前弹出的值，并查看下一个弹出值是否相等
 * @author 张志琰
 *
 */

public class AnotherMethod {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null||headB == null){//做一个边界处理
			return null;
		}
		//定义两个栈：
		Stack<ListNode> a = new Stack<>();
		Stack<ListNode> b = new Stack<>();
		//将链表A压入栈
		while(headA != null){
			a.push(headA);
			headA = headA.next;
		}
		while(headB != null){
			b.push(headB);
			headB = headB.next;
		}
		ListNode result = null;
		//同时弹栈：
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
