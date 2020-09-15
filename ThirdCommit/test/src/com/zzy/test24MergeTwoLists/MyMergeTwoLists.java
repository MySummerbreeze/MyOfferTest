package com.zzy.test24MergeTwoLists;

import com.zzy.test18DeleteListNode.ListNode;

/**
 * 合并两个排序的列表：
 * 		新建一个节点作为最终的返回值（resultNode），新建一个节点作为返回值节点的迭代者（indexNode），
 * 		遍历l1和l2，比较l1和l2的大小，然后新建一个节点，值为小的一方，继续迭代
 * @author user
 *
 */

public class MyMergeTwoLists {
	public ListNode	mergeTwoLists(ListNode l1, ListNode l2) {
		//只要一个为空则返回另一个
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		//创建新的节点用来存储返回值
		/**
		 * 对new ListNode(-1)的分析：
		 * 		在Java中，新建实例操作必须在赋值之前
		 * 		本人没有对JVM原理进行过深入了解，因此不能做出透彻的解释
		 * 		例如，当ListNode resultNode = null;
		 * 			 ListNode indexNode = resultNode;
		 * 			 indexNode = new ListNode(0);
		 * 			此时只有indexNode不为null，而resultNode仍然为null
		 */
		ListNode resultNode = new ListNode(-1);
		ListNode indexNode = resultNode;
		while(l1 != null&&l2 != null) {
			if(l1.val<=l2.val) {//l1的值小于l2
				indexNode.next = new ListNode(l1.val);
				indexNode = indexNode.next;
				l1 = l1.next;
			}else if(l1.val>l2.val) {//l1的值大于l2
				indexNode.next = new ListNode(l2.val);
				indexNode = indexNode.next;
				l2 = l2.next;
			}
		}
		if(l1 == null) {
			indexNode.next = l2;
		}else {
			indexNode.next = l1;
		}
		return resultNode.next;
	}
	
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(5);
		head1.next.next.next = new ListNode(7);
		
		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(6);
		head2.next.next.next = new ListNode(8);
		
		MyMergeTwoLists m = new MyMergeTwoLists();
		ListNode l = m.mergeTwoLists(null,null);
		while(l != null) {
			System.out.print(l.val+" ");
			l = l.next;
		}
	}
}
