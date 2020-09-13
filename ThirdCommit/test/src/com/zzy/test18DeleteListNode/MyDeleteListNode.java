package com.zzy.test18DeleteListNode;

/**
 * 删除指定值的节点：
 * 		遍历链表方法：遍历链表很简单，只需要判断是否有下一个节点即可
 * 			但需要做的操作是删除节点：
 * 				剑指Offer为我们提供了两种删除节点的方式：i,j,k,l其中j为所要删除的节点
 * 					方法一：i指向k即可，即i.next = k;
 * 					方法二：将k的val赋值给j,将j指向k的下一个节点l,即j.val = k.val,j.next = k.next;
 * @author user
 *
 */

public class MyDeleteListNode {
	//method1
	public ListNode deleteListNode(ListNode head,int val) {
		if(head == null) {
			return null;
		}
		//若第一个就是则直接返回头结点的下一个节点，边界条件
		if(head.val == val) {
			return head.next;
		}
		ListNode before = head;
		ListNode index = head.next;
		while(index != null) {
			if(index.val == val) {
				before.next = index.next;
				break;
			}
			before = index;
			index = index.next;
		}
		return head;
	}
	
	//method2
	public ListNode deleteListNode2(ListNode head,int val) {
		if(head == null) {
			return null;
		}
		//若第一个就是则直接返回头结点的下一个节点，边界条件
		if(head.val == val) {
			return head.next;
		}
		ListNode before = head;
		ListNode index = head;
		while(true) {
			//检查是否是最后一个元素
			if(index.next == null) {
				//是最后一个元素则直接判断是否是要删除的元素
				if(index.val == val) before.next = null;
				break;
			}
			//若找到
			if(index.val == val) {
				index.val = index.next.val;
				index.next = index.next.next;
				break;
			}
			before = index;
			index = index.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		//创建节点
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);
		MyDeleteListNode m = new MyDeleteListNode();
		ListNode index = m.deleteListNode2(null, 9);
		while(index != null) {
			System.out.print(index.val+" ");
			index = index.next;
		}
	}
}
