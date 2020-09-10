package com.zzy.test7TreeNode;

import java.util.Arrays;

/**
 * 重建二叉树（官方解法）
 * 		根据前序遍历的特点，可以知道，第一个前序遍历的值为根节点
 * 		根据中序遍历的特点以及前序遍历中获取的根节点，可以找到根节点的左子树和右子树
 * 		以上边的方法进行循环就能重建二叉树
 * @author user
 *
 *	前序遍历 preorder = [3,9,20,15,7]
 *	中序遍历 inorder = [9,3,15,20,7]
 *
 */

public class ReBuildTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         * 需要使用递归来解决问题
         * 每次递归解决的问题是：
         * 		如何找到根节点？
         * 		如何找到左子树？
         * 		如何找到右子树？
         */
		//判断前序的值和中序的值是否为空
		if(preorder.length == 0||inorder.length == 0) {
			return null;
		}
		//首先建立每次的根节点,根节点的值有了
		TreeNode t = new TreeNode(preorder[0]);
		//其次找到根节点的左子树,和右子树
		for(int i = 0;i<inorder.length;i++) {
			if(t.val == inorder[i]) {//若相等则说明找到了根节点
				//左子树的长度是i
				//需要找到左子树的前序和中序
				//左子树的前序,截取从第二个元素到根节点（不包括）元素的数组
				int[] left_pre = Arrays.copyOfRange(preorder, 1, i+1);
				//左子树的中序,截取从第一个元素到根节点（不包括）元素的数组
				int[] left_ino = Arrays.copyOfRange(inorder, 0, i);
				//重建左子树
				t.left = buildTree(left_pre,left_ino);
				
				//右子树的长度是inorder.length-i-1
				//右子树的前序和中序
				//前序:从根节点的下一个节点开始，到结束
				int[] right_pre = Arrays.copyOfRange(preorder, i+1, preorder.length);
				//中序：从根节点的下一个节点开始，到结束
				int[] right_ino = Arrays.copyOfRange(inorder, i+1, inorder.length);
				t.right = buildTree(right_pre,right_ino);
				//直接跳出循环
				break;
			}
		}
		return t;
    }
	
	
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		ReBuildTree r = new ReBuildTree();
		TreeNode t = r.buildTree(preorder, inorder);
		//遍历二叉树
/*		TreeNode leftTree = null;
		TreeNode rightTree = null;*/
		/*while(t.left != null||t.right != null) {
			System.out.println(t.val);
			if(leftTree != null&&rightTree != null ) {
				System.out.println(leftTree.val+"------"+rightTree.val);
			}else if(leftTree != null&&rightTree == null) {
				System.out.println(leftTree.val);
			}else if(leftTree == null&&rightTree != null) {
				System.out.println(rightTree.val);
			}
			if(t.left!=null) {
				leftTree = t.left;
			}
			if(t.right != null) {
				rightTree = t.right;
			}
		}*/
		
	}
}
