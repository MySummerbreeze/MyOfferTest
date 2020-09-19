package com.zzy.test35CopyRandomList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ���÷��η���method1
 * 		��Ϊ�����֣���һ���ֽ�ԭ����ȥ�����ָ��Ĳ�����ȥ�����ȸ���û�����ָ��Ĳ��֣�ÿ�α�������ڵ������ָ������һ��HashMap��
 * 		�ڶ����֣����������ָ��
 * @author user
 *
 */

public class CopyRandomLinkedList {
	public Node copyRandomList(Node head) {
		if(head == null) {
			return null;
		}
		Node copyHead = new Node(head.val);
		HashMap<Node,Node> hm = new HashMap<>();
		hm.put(head, copyHead);
		copyHead = copyNext(head,copyHead,hm);
		copyHead = copyRandom(copyHead, hm);
		return copyHead;
	}

	public Node copyNext(Node head, Node copyHead,HashMap<Node,Node> hm) {
		if(head.next == null) {//��������Ӧ�����ж���һ���Ƿ�Ϊ�գ����統ǰΪ�գ����ȡval�����
			return copyHead;
		}
		copyHead.val = head.val;
		//������Ҫע�⣬����дΪcopyHead.next = head.next;����ͳ���ֱ��copy��ַ��,Ӧ��copy����val
		copyHead.next = new Node(head.next.val);
		//��Ҳ����ˣ���ֵ��.next,����������
		copyNext(head.next,copyHead.next,hm);
		//���ﴫ�����copyNode��Node֮��Ĺ�ϵ
		hm.put(head.next ,copyHead.next);
		return copyHead;
	}
	
	public Node copyRandom(Node copyHead,HashMap<Node,Node> hm) {
		for (Map.Entry<Node, Node> entry : hm.entrySet()) {
			//KeyΪԭ����valueΪ������
			//����ԭ����ǰ�ڵ��random��ȡ��������ǰ�ڵ�ĵ�random����ֵ��������ĵ�ǰ�ڵ�
			entry.getValue().random = hm.get(entry.getKey().random);;
		}
		return copyHead;
	}
	
	public static void main(String[] args) {
		//���������ı�д
		Node head = new Node(7);
		head.next = new Node(13);
		head.next.next = new Node(11);
		head.next.next.next = new Node(10);
		head.next.next.next.next = new Node(1);
		
		head.random = null;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head;
		
		Node node = new CopyRandomLinkedList().copyRandomList(head);
		while(node != null) {
			System.out.println("��ʵֵ��"+node.val);
			node = node.next;
		}
	}
}
