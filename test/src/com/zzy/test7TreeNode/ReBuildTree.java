package com.zzy.test7TreeNode;

import java.util.Arrays;

/**
 * �ؽ����������ٷ��ⷨ��
 * 		����ǰ��������ص㣬����֪������һ��ǰ�������ֵΪ���ڵ�
 * 		��������������ص��Լ�ǰ������л�ȡ�ĸ��ڵ㣬�����ҵ����ڵ����������������
 * 		���ϱߵķ�������ѭ�������ؽ�������
 * @author user
 *
 *	ǰ����� preorder = [3,9,20,15,7]
 *	������� inorder = [9,3,15,20,7]
 *
 */

public class ReBuildTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         * ��Ҫʹ�õݹ����������
         * ÿ�εݹ����������ǣ�
         * 		����ҵ����ڵ㣿
         * 		����ҵ���������
         * 		����ҵ���������
         */
		//�ж�ǰ���ֵ�������ֵ�Ƿ�Ϊ��
		if(preorder.length == 0||inorder.length == 0) {
			return null;
		}
		//���Ƚ���ÿ�εĸ��ڵ�,���ڵ��ֵ����
		TreeNode t = new TreeNode(preorder[0]);
		//����ҵ����ڵ��������,��������
		for(int i = 0;i<inorder.length;i++) {
			if(t.val == inorder[i]) {//�������˵���ҵ��˸��ڵ�
				//�������ĳ�����i
				//��Ҫ�ҵ���������ǰ�������
				//��������ǰ��,��ȡ�ӵڶ���Ԫ�ص����ڵ㣨��������Ԫ�ص�����
				int[] left_pre = Arrays.copyOfRange(preorder, 1, i+1);
				//������������,��ȡ�ӵ�һ��Ԫ�ص����ڵ㣨��������Ԫ�ص�����
				int[] left_ino = Arrays.copyOfRange(inorder, 0, i);
				//�ؽ�������
				t.left = buildTree(left_pre,left_ino);
				
				//�������ĳ�����inorder.length-i-1
				//��������ǰ�������
				//ǰ��:�Ӹ��ڵ����һ���ڵ㿪ʼ��������
				int[] right_pre = Arrays.copyOfRange(preorder, i+1, preorder.length);
				//���򣺴Ӹ��ڵ����һ���ڵ㿪ʼ��������
				int[] right_ino = Arrays.copyOfRange(inorder, i+1, inorder.length);
				t.right = buildTree(right_pre,right_ino);
				//ֱ������ѭ��
				break;
			}
		}
		return t;
    }
	
	
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		ReBuildTree r = new ReBuildTree();
		TreeNode t = r.buildTree(preorder, inorder);
		//����������
/*		TreeNode leftTree = null;
		TreeNode rightTree = null;*/
		/*while(t.left != null||t.right != null) {
			System.out.println(t.val);
			if(leftTree != null&&rightTree != null ) {
				System.out.println(leftTree.val+"------"+rightTree.val);
			}else if(leftTree != null&&rightTree == null) {
				System.out.println(leftTree.val);
			}else if(leftTree == null&&rightTree != null) {
				System.out.println(rightTree.val);
			}
			if(t.left!=null) {
				leftTree = t.left;
			}
			if(t.right != null) {
				rightTree = t.right;
			}
		}*/
		
	}
}
