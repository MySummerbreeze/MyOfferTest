package com.zzy.test6ReversePrintListNode;

public class ReversePrintListNode {
	
	/**
	 * 使用String时会将两位数的值最终变为1位数，不可行
	 * @param head
	 * @return
	 */
	public int[] reversePrint(ListNode head) {
		//为空则返回空
		if(head == null) {
			return new int[0];
		}
		StringBuilder sb = new StringBuilder();
		ListNode headIndex = head;
		while(headIndex != null) {
			sb.append(headIndex.val);
			headIndex = headIndex.next;//将其指向下一个链表
		}
		System.out.println(sb.reverse());
		int[] results = new int[sb.length()];
		//char变int，先将char变为string，再使用Integer.parseInt()
		for(int i = 0;i<sb.length();i++) {
			results[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
		}
		return results;
    }
	
	public static void main(String[] args) {
		ReversePrintListNode r = new ReversePrintListNode();
		//构建一个链表
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new  ListNode(2);
		
		int[] is = r.reversePrint(head);
		for (int i : is) {
			System.out.println(i);
		}
	}
}
