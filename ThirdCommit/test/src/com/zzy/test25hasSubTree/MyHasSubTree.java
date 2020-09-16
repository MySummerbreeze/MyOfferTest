package com.zzy.test25hasSubTree;

/**
 * ���ı�����ʹ�õݹ���Ϊ���ʣ�����Ҫ֪��ʲô��Ҫ�ݹ飬�����Ƶݹ飿
 * �±ߵ�demoΪ��ָOffer��26�⣬�����ӽṹ
 * ����ʵ�����ǰ���ǰ������ķ�ʽ���б�����isSubStructure����������������ҵ�������ͬ�Ľڵ㡣
 * doesTreeAHaveTreeB�����������жϸ�������ͬ�ڵ��Ƿ���ͬһ��������
 * ��ͬ�����в�ͬ���÷���
 * @author user
 *
 */

public class MyHasSubTree {
	public static boolean isSubStructure(TreeNode A, TreeNode B) {
		boolean result = false;
		if(A != null&&B != null) {
			//����ֵ�����ȥƥ��������
			if(A.val == B.val) {
				result = doesTreeAHaveTreeB(A, B);
			}
			//����ֵ�����,ƥ�������������
			if(!result) {
				result = isSubStructure(A.left, B);
			}
			//ƥ�������������
			if(!result) {
				result = isSubStructure(A.right, B);
			}
		}
		return result;
	}
	
	public static boolean doesTreeAHaveTreeB(TreeNode A, TreeNode B) {
		//BΪ�գ�С��Ϊ�գ�˵���Ѿ�ƥ�䵽ͷ������true
		if(B == null) {
			return true;
		}
		//С����Ϊ�գ�������Ϊ�գ�˵����ƥ��
		if(A == null) {
			return false;
		}
		//����ֵ�����Ҳ��ƥ��
		if(A.val != B.val) {
			return false;
		}
		//���ӽڵ�����ӽڵ���붼���
		return doesTreeAHaveTreeB(A.left, B.left)&&doesTreeAHaveTreeB(A.right, B.right);
	}
	
	public static void main(String[] args) {
		TreeNode gen = new TreeNode(4);
		gen.left = new TreeNode(2);
		gen.right = new TreeNode(3);
		gen.left.left = new TreeNode(4);
		gen.left.right = new TreeNode(5);
		gen.right.left = new TreeNode(6);
		gen.right.right = new TreeNode(7);
		gen.left.left.left = new TreeNode(8);
		gen.left.left.right = new TreeNode(9);
		
		TreeNode B = new TreeNode(4);
		B.left = new TreeNode(8);
		B.right = new TreeNode(9);
		
		isSubStructure(gen,B);
	}
}
//[4,2,3,4,5,6,7,8,9]
//[4,8,9]
