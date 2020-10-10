package com.zzy.test54KthLargest;

import com.zzy.test25hasSubTree.TreeNode;

public class MyKthLargest {
	
	int result,kNum;
	public int kthLargest(TreeNode root, int k){
		if(root == null)return 0;
		kNum = k;
		dfs(root);
		return result;
	}
	//ÖÐÐòµ¹Ðò
	public void dfs(TreeNode root){
		if(root == null)return;
		dfs(root.right);
		if(kNum == 0)return;
		if(--kNum == 0)result = root.val;
		dfs(root.left);
	}
}
