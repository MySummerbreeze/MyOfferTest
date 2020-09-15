package com.zzy.test22KthFromEnd;

import com.zzy.test18DeleteListNode.ListNode;

/**
 * 递归法：
 * 		两个全局变量，一个作为计数器，一个作为返回节点的最终结果
 * 		递归到临界点，递归结束，开始count++
 * 		直到count==k时将当前的head赋值给reslutNode
 * 		最终返回resultNode
 * @author user
 *
 */

public class ReKethFromEnd {
	int count = 0;
	ListNode resultNode = null;
	public ListNode getReKethFromEnd(ListNode head, int k) {
		if(head != null) {
			getReKethFromEnd(head.next, k);
		}else return null;
		count++;
		if(count == k) {
			resultNode = head;
		}
		return resultNode;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);
		ReKethFromEnd m = new ReKethFromEnd();
		ListNode l = m.getReKethFromEnd(head, 5);
		System.out.println(l.val);
	}
}
