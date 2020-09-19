package com.zzy.test32levelOrder;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder34 {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        List<List<TreeNode>> list = new ArrayList<>();
        if(root == null) {
        	return results;
        }
        int i = 0;
        //将根节点加入到list中
        List<TreeNode> other = new ArrayList<TreeNode>();
        other.add(root);
        list.add(other);
        while(i<list.size()) {
        	//每一行都需要一个新的List
        	List<TreeNode> newList = new ArrayList<>();
        	for(int j = 0;j<list.get(i).size();j++) {
        		//上一个Node
        		TreeNode lastNode = list.get(i).get(j);
        		if(lastNode.left != null) {
        			newList.add(lastNode.left);
            	}
        		if(lastNode.right != null) {
        			newList.add(lastNode.right);
        		}
        	}
        	if(newList.size() == 0) {
        		break;
        	}
        	list.add(newList);
        	i++;
        }
        boolean reverse = false;
        for (List<TreeNode> t : list) {
        	List<Integer> newIntegers = new ArrayList<>();
        	if(!reverse) {
        		reverse = true;
        		for(TreeNode j : t) {
    				newIntegers.add(j.val);
    			}
        	}else {
        		reverse = false;
        		for(int j = t.size()-1;j>=0;j--) {
    				newIntegers.add(t.get(j).val);
    			}
        	}
        	results.add(newIntegers);
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
		
		List<List<Integer>> results = new LevelOrder34().levelOrder(root);
		for (List<Integer> i : results) {
			for(int j : i) {
				System.out.print(j+" ");
			}
		}
	}
}
