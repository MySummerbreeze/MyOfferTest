package com.zzy.test37Serialize;

import java.util.LinkedList;

import com.zzy.test25hasSubTree.TreeNode;

/**
 * ���л���Ŀ�����ܹ������÷����л���������ǿ������һ���Լ��ܹ��������л���
 * 		��֮ǰ�ؽ��������У�����֪������ǰ����������־Ϳ����ؽ�������
 * 		�������ַ�����������ԣ����Ƚڵ�ֵ������ͬ��������ڷ����л�ʱ��Ҫ��ȫ�������ݶ������ܹ�����
 * 	�ṩ��һ�ַ�����
 * 		����ǰ������������ռ�������һ���ڵ�Ϊ�գ���ʹ��һ������ķ��ű�ǣ����нڵ�����ʹ�ã�����
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
	
	public StringBuilder getSerialize(TreeNode root,StringBuilder sb) {//ǰ��
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
