package com.zzy.test6ReversePrintListNode;

public class ReversePrintListNode {
	
	/**
	 * ʹ��Stringʱ�Ὣ��λ����ֵ���ձ�Ϊ1λ����������
	 * @param head
	 * @return
	 */
	public int[] reversePrint(ListNode head) {
		//Ϊ���򷵻ؿ�
		if(head == null) {
			return new int[0];
		}
		StringBuilder sb = new StringBuilder();
		ListNode headIndex = head;
		while(headIndex != null) {
			sb.append(headIndex.val);
			headIndex = headIndex.next;//����ָ����һ������
		}
		System.out.println(sb.reverse());
		int[] results = new int[sb.length()];
		//char��int���Ƚ�char��Ϊstring����ʹ��Integer.parseInt()
		for(int i = 0;i<sb.length();i++) {
			results[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
		}
		return results;
    }
	
	public static void main(String[] args) {
		ReversePrintListNode r = new ReversePrintListNode();
		//����һ������
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new  ListNode(2);
		
		int[] is = r.reversePrint(head);
		for (int i : is) {
			System.out.println(i);
		}
	}
}
