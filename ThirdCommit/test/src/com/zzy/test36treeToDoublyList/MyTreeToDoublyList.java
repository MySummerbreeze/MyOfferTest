package com.zzy.test36treeToDoublyList;

public class MyTreeToDoublyList {
	//��������ȫ�ֱ�����һ�������շ���ֵ��ͷ��㣬һ����pre����һ���ڵ�
	Node head , pre;	
	public Node treeToDoublyList(Node root) {//˫ѭ������leftΪǰָ�룬rightΪ��ָ��
		if(root == null) return null;
		dfs(root);
		head.left = pre;//��ѭ������
		pre.right = head;
		return head;
	}
	
	public void dfs(Node cur) {
		if(cur != null) return;//�ݹ���ֹ����
		dfs(cur.left);//ǰ���ȱ�����ڵ�
		if(pre != null)  pre.right = cur;//��������򽫱��ڵ���Ϊ��һ���ڵ����һ���ڵ�
		else head = cur;//����һ���ڵ�Ϊ����˵�����׸��ڵ㣬���׸��ڵ㸳ֵ
		cur.left = pre;//��ǰ�ڵ����һ���ڵ�Ϊpre
		pre = cur;
		dfs(cur.right);
	}
}
