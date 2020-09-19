package com.zzy.test33SearchTree;

import java.util.Arrays;

/**
 * 二叉搜索树的概念：
 * 		它或者是一棵空树，或者是具有下列性质的二叉树： 
 * 		若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 		若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 		它的左、右子树也分别为二叉排序树。
 * 如何使用一个数组判断是否是一个二叉排序树：
 * 		{5,7,6,9,11,10,8}
 * 		该数组为后序排序，排序的最后一个节点一定是根节点，而根节点大于其右节点，小于其左节点，因此右子树为5,7,6。左子树为:9,11,10
 * 		8要大于所有的右子树，小于所有的左子树
 * @author user
 *
 */

public class SearchTree {
	public boolean verifyPostorder(int[] postorder) {
        if(postorder.length == 0||postorder == null||postorder.length == 1) {
        	return true;
        }
        int indexEnd = postorder.length-1;
        boolean result = true;
        int mid = -1;
        int i = 0;
        for(;i<indexEnd;i++) {
        	if(postorder[i]>postorder[indexEnd]&&mid<0) {
        		mid = i;
    			//递归右节点
    			result = verifyPostorder(Arrays.copyOfRange(postorder, 0, i));
        	}else if(postorder[i]<postorder[indexEnd]&&!(mid<0)){
        		//如果是在遍历右节点，需要右节点所有的数都要大于根节点，但如果有小于根节点的，则直接返回false
        		return false;
        	}
    		if(!result) return result; 
        }
        if(mid<0) {//mid<0说明没有根节点之前的没有大于根节点的,则重新从0开始遍历
        	mid = 0;
        }
        result = result&&verifyPostorder(Arrays.copyOfRange(postorder, mid, indexEnd));
        //递归左节点，并组合右节点的结果
        return result;
    }
	
	public static void main(String[] args) {
		int[] postorder = {5, 2, -17, -11, 25, 76, 62, 98, 92, 61};
		System.out.println(new SearchTree().verifyPostorder(postorder));
	}
}
