package com.zzy.test35CopyRandomList;

/**
 * ���ÿռ任ʱ���������
 * 		����		1-2-3-4
 * 		���ǿ��ԣ�	1-1'-2-2'-3-3'-4-4'
 * 		������1��randomָ��4����ô1'��random��ָ��4��next
 * 		���տ���ɾ��ԭ�ڵ㣬ֻʣ��copy������
 * @author user
 *
 */

public class CopyLinkedListMethod2 {
	public Node copyRandomList(Node head) {
		if(head == null) {
			return head;
		}
		//���Ⱥϲ�����
		head = mergeLinkedList(head);
		//�������random
		head = setRandom(head);
		//��������������
		head = build2(head);
		return head;
	}

	public Node build2(Node head){
        //��������������ע��Ҫ�ָ�ԭ�е�����
        Node res = head.next;
        Node tmp = res;

        head.next = head.next.next;//��һ������ȱ�٣���֤��һ�����ƽڵ��N N'�ķ������
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
			System.out.println("��ʵֵ��"+node.val);
			node = node.next;
		}
	}
}
