package com.zzy.test34PathSum;

import java.util.ArrayList;
import java.util.List;

import com.zzy.test32levelOrder.TreeNode;

/**
 *二叉树中和为某一值的路径:
 *	重点为前序遍历，
 * @author user
 *
 */

public class MyPathSum {
	List<List<Integer>> results = new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root == null) {
			return new ArrayList<>();
		}
		List<Integer> list = new ArrayList<>();
		preface(list,root,sum);
		return results;
	}
	
	public List<Integer> preface(List<Integer> list,TreeNode root,int sum){
		//判断当前值是否为空，为空则返回
		if(root == null) {
			return list;
		}
		//不为空则将该节点值加入list中，并sum自减
		list.add(root.val);
		sum -= root.val;
		//判断当前sum是否为0，并且是最底的数，为0说明已经找到
		if(sum == 0&&root.left==null&&root.right==null) {
			results.add(new ArrayList<>(list));
			list.remove(list.size()-1);
			return list;
		}
		preface(list,root.left,sum);
		preface(list,root.right,sum);
		list.remove(list.size()-1);
		return list;
	}
	
	public static void main(String[] args) {
		//[5,4,8,11,null,13,4,7,2,null,null,5,1]
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		System.out.println(new MyPathSum().pathSum(root,22)==null);;
	}
}
