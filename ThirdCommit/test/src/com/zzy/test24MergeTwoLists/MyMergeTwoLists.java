package com.zzy.test24MergeTwoLists;

import com.zzy.test18DeleteListNode.ListNode;

/**
 * �ϲ�����������б�
 * 		�½�һ���ڵ���Ϊ���յķ���ֵ��resultNode�����½�һ���ڵ���Ϊ����ֵ�ڵ�ĵ����ߣ�indexNode����
 * 		����l1��l2���Ƚ�l1��l2�Ĵ�С��Ȼ���½�һ���ڵ㣬ֵΪС��һ������������
 * @author user
 *
 */

public class MyMergeTwoLists {
	public ListNode	mergeTwoLists(ListNode l1, ListNode l2) {
		//ֻҪһ��Ϊ���򷵻���һ��
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		//�����µĽڵ������洢����ֵ
		/**
		 * ��new ListNode(-1)�ķ�����
		 * 		��Java�У��½�ʵ�����������ڸ�ֵ֮ǰ
		 * 		����û�ж�JVMԭ����й������˽⣬��˲�������͸���Ľ���
		 * 		���磬��ListNode resultNode = null;
		 * 			 ListNode indexNode = resultNode;
		 * 			 indexNode = new ListNode(0);
		 * 			��ʱֻ��indexNode��Ϊnull����resultNode��ȻΪnull
		 */
		ListNode resultNode = new ListNode(-1);
		ListNode indexNode = resultNode;
		while(l1 != null&&l2 != null) {
			if(l1.val<=l2.val) {//l1��ֵС��l2
				indexNode.next = new ListNode(l1.val);
				indexNode = indexNode.next;
				l1 = l1.next;
			}else if(l1.val>l2.val) {//l1��ֵ����l2
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
