package com.zzy.test55MaxDepth;

import com.zzy.test25hasSubTree.TreeNode;

/**
 * 二叉树的深度：
 * 		深度搜索dfs
 * @author 张志琰
 *
 */

public class MyMaxDepth {
	int depth = 0;
	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
		dfs(root,0);
		return depth;
    }
	
	public void dfs(TreeNode root ,int num){
		if(root == null)return;
		num++;
		dfs(root.left,num);
		dfs(root.right,num);
		depth = Math.max(depth,num);
	}
	
}
