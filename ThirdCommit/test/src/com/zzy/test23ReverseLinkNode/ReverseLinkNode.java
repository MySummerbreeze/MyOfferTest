package com.zzy.test23ReverseLinkNode;

import com.zzy.test18DeleteListNode.ListNode;
import com.zzy.test22KthFromEnd.ReKethFromEnd;

/**
 * 翻转链表：
 * 		首先想到递归：
 * 		定义两个全局变量，一个作为最终返回值，一个作为迭代器
 * 		触底，开始赋值，新建迭代器，将当前值赋给迭代器，将迭代器赋值给最终返回值....
 * 当前demo为LeetCode中一个博主的demo
 * @author user
 *
 */

public class ReverseLinkNode {
	public ListNode reverseList(ListNode head) {
		//head==null是判断第一次head == null
		if(head == null||head.next == null) {
			return head;
		}
		//递归调用，最终触底返回的是最后一个值
		ListNode result = reverseList(head.next);
		//触底返回之后，head是倒数第二个值，head.next是最后一个值，head.next.next是最后一个值的下一个节点，指向head，即成一个环路
		head.next.next = head;
		//破坏环路
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
    	//newNode作为遍历的节点
    	newNode = new ListNode(head.val);
    	//newHead作为头节点
    	newHead = newNode;
    	return;
    }
	newNode.next = new ListNode(head.val);
	newNode = newNode.next;
}*/