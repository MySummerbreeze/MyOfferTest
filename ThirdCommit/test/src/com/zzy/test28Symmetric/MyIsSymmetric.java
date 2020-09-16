package com.zzy.test28Symmetric;

import com.zzy.test25hasSubTree.TreeNode;

/**
 * 判断是否是镜像的二叉树：
 * 		可以利用上一题的方法获取镜像再进行遍历比较。
 * 下边有递归的写法
 * @author user
 *
 */

public class MyIsSymmetric {
	/*
	 * 递归写法
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		return recur(root.left,root.right);
    }

	public boolean recur(TreeNode left, TreeNode right) {
		if(left == null&&right == null) {
			return true;
		}
		if(left == null||right == null||left.val != right.val) {
			return false;
		}
		return recur(left.left, right.right) && recur(left.right,right.left);
	}

	
	/**
	 * 两个树判断:
	 * 		在执行的时候发现了一个问题，当我去执行翻转函数时，将原二叉树也变成了翻转，
	 * 		即在内存中自始至终都只有一个实例，因为在之前的翻转函数中，我没有使用额外的空间，所以造成了这种结果
	 * 		
	 * 		
	 * @param root
	 * @param mirrorTree
	 * @return
	 */
	public boolean isSymmetric1(TreeNode root) {
		TreeNode index = null;
		index = mirrorTree(root);
		return isEqual(root, index);
	}
	
	public boolean isEqual(TreeNode root, TreeNode mirrorTree) {
		if(root == null&&mirrorTree == null) {
			return true;
		}else if(root == null||mirrorTree == null){
			return false;
		}
		if(root.val == mirrorTree.val) {
			return isEqual(root.left,mirrorTree.left)&&isEqual(root.right,mirrorTree.right);
		}else return false;
	}

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
		TreeNode gen = new TreeNode(1);
		gen.left = new TreeNode(2);
		gen.right = new TreeNode(2);
		gen.left.left = new TreeNode(3);
		gen.left.right = new TreeNode(4);
		gen.right.left = new TreeNode(4);
		gen.right.right = new TreeNode(3);
		gen.left.left.left = new TreeNode(8);
		gen.left.left.right = new TreeNode(9);

		MyIsSymmetric m = new MyIsSymmetric();
		
		System.out.println(m.isSymmetric1(gen));
	}
}
