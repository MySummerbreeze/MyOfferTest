package com.zzy.test34PathSum;

import java.util.ArrayList;
import java.util.List;

import com.zzy.test32levelOrder.TreeNode;

/**
 *�������к�Ϊĳһֵ��·��:
 *	�ص�Ϊǰ�������
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
		//�жϵ�ǰֵ�Ƿ�Ϊ�գ�Ϊ���򷵻�
		if(root == null) {
			return list;
		}
		//��Ϊ���򽫸ýڵ�ֵ����list�У���sum�Լ�
		list.add(root.val);
		sum -= root.val;
		//�жϵ�ǰsum�Ƿ�Ϊ0����������׵�����Ϊ0˵���Ѿ��ҵ�
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
