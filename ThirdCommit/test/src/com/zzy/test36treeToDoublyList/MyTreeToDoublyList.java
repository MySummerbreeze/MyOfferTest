package com.zzy.test36treeToDoublyList;

public class MyTreeToDoublyList {
	//设置两个全局变量，一个是最终返回值即头结点，一个是pre即上一个节点
	Node head , pre;	
	public Node treeToDoublyList(Node root) {//双循环链表：left为前指针，right为后指针
		if(root == null) return null;
		dfs(root);
		head.left = pre;//将循环接上
		pre.right = head;
		return head;
	}
	
	public void dfs(Node cur) {
		if(cur != null) return;//递归终止条件
		dfs(cur.left);//前序先遍历左节点
		if(pre != null)  pre.right = cur;//如果不是则将本节点作为上一个节点的下一个节点
		else head = cur;//若上一个节点为空则说明是首个节点，将首个节点赋值
		cur.left = pre;//当前节点的上一个节点为pre
		pre = cur;
		dfs(cur.right);
	}
}
