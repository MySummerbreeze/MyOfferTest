package com.zzy.test35CopyRandomList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 采用分治法：method1
 * 		分为两部分，第一部分将原链表去掉随机指向的部分先去掉，先复制没有随机指向的部分，每次遍历将其节点与随机指向存放入一个HashMap中
 * 		第二部分，设置其随机指向
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
		if(head.next == null) {//还有这里应该是判断下一个是否为空，假如当前为空，则获取val会出错
			return copyHead;
		}
		copyHead.val = head.val;
		//在这需要注意，不能写为copyHead.next = head.next;否则就成了直接copy地址了,应该copy的是val
		copyHead.next = new Node(head.next.val);
		//这也入坑了，传值是.next,而不是自身
		copyNext(head.next,copyHead.next,hm);
		//这里传入的是copyNode和Node之间的关系
		hm.put(head.next ,copyHead.next);
		return copyHead;
	}
	
	public Node copyRandom(Node copyHead,HashMap<Node,Node> hm) {
		for (Map.Entry<Node, Node> entry : hm.entrySet()) {
			//Key为原链表，value为现链表
			//根据原链表当前节点的random获取到现链表当前节点的的random，赋值给现链表的当前节点
			entry.getValue().random = hm.get(entry.getKey().random);;
		}
		return copyHead;
	}
	
	public static void main(String[] args) {
		//测试用例的编写
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
			System.out.println("真实值："+node.val);
			node = node.next;
		}
	}
}
