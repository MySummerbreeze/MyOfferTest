package com.zzy.test25hasSubTree;

/**
 * 树的遍历，使用递归最为合适，但需要知道什么需要递归，如何设计递归？
 * 下边的demo为剑指Offer的26题，树的子结构
 * 本题实际上是按照前序遍历的方式进行遍历，isSubStructure函数的意义就在于找到两个相同的节点。
 * doesTreeAHaveTreeB的意义在于判断该两个相同节点是否是同一个子树。
 * 不同函数有不同的用法。
 * @author user
 *
 */

public class MyHasSubTree {
	public static boolean isSubStructure(TreeNode A, TreeNode B) {
		boolean result = false;
		if(A != null&&B != null) {
			//若两值相等则去匹配这俩树
			if(A.val == B.val) {
				result = doesTreeAHaveTreeB(A, B);
			}
			//若两值不相等,匹配大树的左子树
			if(!result) {
				result = isSubStructure(A.left, B);
			}
			//匹配大树的右子树
			if(!result) {
				result = isSubStructure(A.right, B);
			}
		}
		return result;
	}
	
	public static boolean doesTreeAHaveTreeB(TreeNode A, TreeNode B) {
		//B为空（小树为空）说明已经匹配到头，返回true
		if(B == null) {
			return true;
		}
		//小树不为空，但大树为空，说明不匹配
		if(A == null) {
			return false;
		}
		//两者值不相等也不匹配
		if(A.val != B.val) {
			return false;
		}
		//左子节点和右子节点必须都相等
		return doesTreeAHaveTreeB(A.left, B.left)&&doesTreeAHaveTreeB(A.right, B.right);
	}
	
	public static void main(String[] args) {
		TreeNode gen = new TreeNode(4);
		gen.left = new TreeNode(2);
		gen.right = new TreeNode(3);
		gen.left.left = new TreeNode(4);
		gen.left.right = new TreeNode(5);
		gen.right.left = new TreeNode(6);
		gen.right.right = new TreeNode(7);
		gen.left.left.left = new TreeNode(8);
		gen.left.left.right = new TreeNode(9);
		
		TreeNode B = new TreeNode(4);
		B.left = new TreeNode(8);
		B.right = new TreeNode(9);
		
		isSubStructure(gen,B);
	}
}
//[4,2,3,4,5,6,7,8,9]
//[4,8,9]
