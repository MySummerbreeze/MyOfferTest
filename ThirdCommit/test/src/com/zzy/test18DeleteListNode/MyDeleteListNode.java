package com.zzy.test18DeleteListNode;

/**
 * ɾ��ָ��ֵ�Ľڵ㣺
 * 		��������������������ܼ򵥣�ֻ��Ҫ�ж��Ƿ�����һ���ڵ㼴��
 * 			����Ҫ���Ĳ�����ɾ���ڵ㣺
 * 				��ָOfferΪ�����ṩ������ɾ���ڵ�ķ�ʽ��i,j,k,l����jΪ��Ҫɾ���Ľڵ�
 * 					����һ��iָ��k���ɣ���i.next = k;
 * 					����������k��val��ֵ��j,��jָ��k����һ���ڵ�l,��j.val = k.val,j.next = k.next;
 * @author user
 *
 */

public class MyDeleteListNode {
	//method1
	public ListNode deleteListNode(ListNode head,int val) {
		if(head == null) {
			return null;
		}
		//����һ��������ֱ�ӷ���ͷ������һ���ڵ㣬�߽�����
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
		//����һ��������ֱ�ӷ���ͷ������һ���ڵ㣬�߽�����
		if(head.val == val) {
			return head.next;
		}
		ListNode before = head;
		ListNode index = head;
		while(true) {
			//����Ƿ������һ��Ԫ��
			if(index.next == null) {
				//�����һ��Ԫ����ֱ���ж��Ƿ���Ҫɾ����Ԫ��
				if(index.val == val) before.next = null;
				break;
			}
			//���ҵ�
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
		//�����ڵ�
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
