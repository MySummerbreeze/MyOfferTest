package com.zzy.test35CopyRandomList;

/**
 * 采用空间换时间的做法：
 * 		比如		1-2-3-4
 * 		我们可以：	1-1'-2-2'-3-3'-4-4'
 * 		而假如1的random指向4，那么1'的random就指向4的next
 * 		最终可以删除原节点，只剩下copy的链表
 * @author user
 *
 */

public class CopyLinkedListMethod2 {
	public Node copyRandomList(Node head) {
		if(head == null) {
			return head;
		}
		//首先合并链表
		head = mergeLinkedList(head);
		//其次设置random
		head = setRandom(head);
		//最后分离两个链表
		head = build2(head);
		return head;
	}

	public Node build2(Node head){
        //将链表拆成两个，注意要恢复原有的链表
        Node res = head.next;
        Node tmp = res;

        head.next = head.next.next;//这一步不可缺少，保证第一个复制节点对N N'的分离操作
        head = head.next;
        while(head!=null){
            tmp.next = head.next;
            head.next = head.next.next;
            tmp=tmp.next;
            head = head.next;
         }
        return res;
    }

	public Node setRandom(Node head) {
		Node index = head;
		while(index != null) {
			if(index.random == null) {
				index.next.random = null;
			}else {
				index.next.random = index.random.next;
			}
			index = index.next.next;
		}
		return head;
	}

	public Node mergeLinkedList(Node head) {
		if(head != null) {
			Node node = new Node(head.val);
			node.next = head.next;
			head.next = node;
			mergeLinkedList(head.next.next);
		}
		return head;
	}
	
	public static void main(String[] args) {
		Node head = new Node(7);
		/*head.next = new Node(13);
		head.next.next = new Node(11);
		head.next.next.next = new Node(10);
		head.next.next.next.next = new Node(1);
		
		head.random = null;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head;*/
		
		Node node = new CopyLinkedListMethod2().copyRandomList(head);
		while(node != null) {
			System.out.println("真实值："+node.val);
			node = node.next;
		}
	}
}
