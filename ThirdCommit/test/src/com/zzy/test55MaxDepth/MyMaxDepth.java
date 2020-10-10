package com.zzy.test55MaxDepth;

import com.zzy.test25hasSubTree.TreeNode;

/**
 * ����������ȣ�
 * 		�������dfs
 * @author ��־��
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
