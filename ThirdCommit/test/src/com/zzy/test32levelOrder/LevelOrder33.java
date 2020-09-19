package com.zzy.test32levelOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * �������ҵ�ѭ����������Ĳ����Լ�ռ�ݶ�����ڴ�
 * @author user
 *
 */

public class LevelOrder33 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<>();
        List<List<TreeNode>> list = new ArrayList<>();
        if(root == null) {
        	return results;
        }
        int i = 0;
        //�����ڵ���뵽list��
        List<TreeNode> other = new ArrayList<TreeNode>();
        other.add(root);
        list.add(other);
        List<Integer> othernum = new ArrayList<Integer>();
        othernum.add(root.val);
        results.add(othernum);
        while(i<list.size()) {
        	//ÿһ�ж���Ҫһ���µ�List
        	List<Integer> newIntegers = new ArrayList<>();
        	List<TreeNode> newList = new ArrayList<>();
        	for(int j = 0;j<list.get(i).size();j++) {
        		//��һ��Node
        		TreeNode lastNode = list.get(i).get(j);
        		if(lastNode.left != null) {
        			newList.add(lastNode.left);
        			newIntegers.add(lastNode.left.val);
            	}
        		if(lastNode.right != null) {
        			newList.add(lastNode.right);
        			newIntegers.add(lastNode.right.val);
        		}
        	}
        	if(newList.size() == 0) {
        		break;
        	}
        	list.add(newList);
        	results.add(newIntegers);
        	i++;
        }
        return results;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> results = new LevelOrder33().levelOrder(root);
		for (List<Integer> i : results) {
			for(int j : i) {
				System.out.print(j+" ");
			}
		}
	}
}
