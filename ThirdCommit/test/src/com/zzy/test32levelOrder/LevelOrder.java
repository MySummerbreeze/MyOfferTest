/**
 * 
 */
package com.zzy.test32levelOrder;

import java.util.ArrayList;

/**
 *��ָOffer���ṩ��һ�ֽⷨ��
 *	�������ڵ㣬Ȼ�󽫸��ڵ�ֵ�������飬�ٽ�����Ľڵ����һ��������Ȼ���������ȡ������ĵ�һ���ڵ㼴�����ȳ�
 *	�����뵽���ʹ�������ŵĻ������ǿ��Զ�ʹ��������Ȼ��ȡ�������ȳ��������������뵽�������С�
 *	ʵ��ʱ���֣���ָOffer��ֱ���������LeetCode��Ҫ����һ�����飬Ȼ���������������ֵ��һ����
 *	��������˼·�ǿ��еģ�����ʹ�ö��в����У�����������ȡ��ʹ�����鼯������õķ������ܹ��������������ʱ����
 * 
 * @author user
 * 
 * ����˼·����Ϊ���������������BFS����BFSͨ���������е������ȳ�����ʵ��
 */
//һ��ȫ�ֵĶ���,��java��û��ʵ�ֶ��У�����ֻ��һ���ӿڣ�ʹ����Ҫ�Լ�ȥʵ�֣���java������ģ�������LinkedList
public class LevelOrder {
	public int[] levelOrder(TreeNode root) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if(root == null) {
			return new int[0];
		}
		//���ϱ�����ָ��
		int index = 0;
		list.add(root);
		//��������һ��֪ʶ�㣬��String������length(),����Ϊlength,����Ϊsize()
		while(index<list.size()) {
			if(list.get(index).left != null) {
				list.add(list.get(index).left);
			}
			if(list.get(index).right != null) {
				list.add(list.get(index).right);
			}
			index++;
		}
		int[] results = new int[list.size()];
		for (int i = 0;i<results.length;i++) {
			results[i] = list.get(i).val;
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
		
		int[] results = new LevelOrder().levelOrder(root);
		for (int i : results) {
			System.out.print(i+" ");
		}
	}
	
}
