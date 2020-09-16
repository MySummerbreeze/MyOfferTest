package com.zzy.test28Symmetric;

import com.zzy.test25hasSubTree.TreeNode;

/**
 * �ж��Ƿ��Ǿ���Ķ�������
 * 		����������һ��ķ�����ȡ�����ٽ��б����Ƚϡ�
 * �±��еݹ��д��
 * @author user
 *
 */

public class MyIsSymmetric {
	/*
	 * �ݹ�д��
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
	 * �������ж�:
	 * 		��ִ�е�ʱ������һ�����⣬����ȥִ�з�ת����ʱ����ԭ������Ҳ����˷�ת��
	 * 		�����ڴ�����ʼ���ն�ֻ��һ��ʵ������Ϊ��֮ǰ�ķ�ת�����У���û��ʹ�ö���Ŀռ䣬������������ֽ��
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
