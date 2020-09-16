package com.zzy.test27MirrorTree;

import com.zzy.test25hasSubTree.TreeNode;

public class MyMirrorTree {
	public TreeNode mirrorTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		mirrorTree(root.left);
		mirrorTree(root.right);
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode gen = new TreeNode(4);
		gen.left = new TreeNode(7);
		gen.right = new TreeNode(2);
		gen.left.left = new TreeNode(1);
		gen.left.right = new TreeNode(5);
		gen.right.left = new TreeNode(6);
		gen.right.right = new TreeNode(7);
		gen.left.left.left = new TreeNode(8);
		gen.left.left.right = new TreeNode(9);
		
		MyMirrorTree m = new MyMirrorTree();
		TreeNode root = m.mirrorTree(gen);
		
		printMyTree(root);
		
	}

	private static void printMyTree(TreeNode root) {
		// TODO 自动生成的方法存根
		
		System.out.print(root.val+" ");
		if(root.left!=null) {
			printMyTree(root.left);
		}
		if(root.right!=null) {
			printMyTree(root.right);
		}
		
	}
}
