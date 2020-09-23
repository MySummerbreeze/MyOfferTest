package com.zzy.test37Serialize;

import java.util.LinkedList;

import com.zzy.test25hasSubTree.TreeNode;

/**
 * 序列化的目的是能够最终让反序列化，因此我们可以设计一个自己能够理解的序列化：
 * 		在之前重建二叉树中，我们知道根据前序和中序两种就可以重建二叉树
 * 		但是这种方法有其局限性，首先节点值不能相同，其次是在反序列化时需要将全部的数据读出才能够进行
 * 	提供另一种方法：
 * 		根据前序遍历，遇到空即遇到下一个节点为空，则使用一个特殊的符号标记，所有节点数据使用，隔开
 * @author user
 *
 */

public class MySerializeTree {
	
	public String serialize(TreeNode root) {
		if(root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb = getSerialize(root, sb);
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
    }
	
	public StringBuilder getSerialize(TreeNode root,StringBuilder sb) {//前序
		if(root == null) {
			sb.append("$,");
			return null;
		}
		sb.append(root.val+",");
		getSerialize(root.left, sb);
		getSerialize(root.right, sb);
		return sb;
	}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data == null||data.length() == 0) {
    		return null;
    	}
    	TreeNode root = null;
    	String[] ss = data.split(",");
    	LinkedList<String> queue = new LinkedList<>();
    	for (String string : ss) {
			queue.offer(string);
		}
    	return deserializeUseQueue(root,queue);
    }
    
    public TreeNode deserializeUseQueue(TreeNode node,LinkedList<String> queue) {
    	if(queue == null||queue.peek().equals("$")) {
    		queue.poll();
    		return null; 
    	}
    	TreeNode newNode = new TreeNode(Integer.parseInt(queue.poll()));
		newNode.left = deserializeUseQueue(newNode, queue);
		newNode.right = deserializeUseQueue(newNode, queue);
    	return newNode;
    }
    
    public static void main(String[] args) {
    	TreeNode gen = new TreeNode(-1);
		gen.left = new TreeNode(0);
		gen.right = new TreeNode(-1);
/*		gen.left.left = new TreeNode(4);
		gen.left.right = new TreeNode(5);
		gen.right.left = new TreeNode(6);
		gen.right.right = new TreeNode(7);
		gen.left.left.left = new TreeNode(8);
		gen.left.left.right = new TreeNode(9);*/
//    	TreeNode root = deserialize(serialize(gen));
//		System.out.println(root);
		
		TreeNode node = new MySerializeTree().deserialize(new MySerializeTree().serialize(gen));
		System.out.println(node);
	}
    
}
