/**
 * 
 */
package com.zzy.test32levelOrder;

import java.util.ArrayList;

/**
 *剑指Offer中提供了一种解法：
 *	遍历根节点，然后将根节点值放入数组，再将其余的节点放入一个容器，然后从容器中取出放入的第一个节点即先入先出
 *	可以想到如果使用容器放的话，我们可以都使用容器，然后都取。先入先出的容器很容易想到，即队列。
 *	实现时发现，剑指Offer中直接输出，而LeetCode需要存入一个数组，然后输出，两者最终值不一样，
 *	所以这种思路是可行的，但是使用队列不可行，不能随用随取，使用数组集合是最好的方法，能够在最终输出数组时遍历
 * 
 * @author user
 * 
 * 这种思路被称为，广度优先搜索（BFS），BFS通常借助队列的先入先出特性实现
 */
//一个全局的队列,在java中没有实现队列，队列只是一个接口，使用需要自己去实现，而java给出的模拟对列是LinkedList
public class LevelOrder {
	public int[] levelOrder(TreeNode root) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if(root == null) {
			return new int[0];
		}
		//集合遍历的指针
		int index = 0;
		list.add(root);
		//在这里有一个知识点，是String类型是length(),数组为length,集合为size()
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
