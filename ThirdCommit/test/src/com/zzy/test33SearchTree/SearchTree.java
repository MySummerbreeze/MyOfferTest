package com.zzy.test33SearchTree;

import java.util.Arrays;

/**
 * �����������ĸ��
 * 		��������һ�ÿ����������Ǿ����������ʵĶ������� 
 * 		���������������գ��������������н���ֵ��С�����ĸ�����ֵ��
 * 		���������������գ��������������н���ֵ���������ĸ�����ֵ��
 * 		������������Ҳ�ֱ�Ϊ������������
 * ���ʹ��һ�������ж��Ƿ���һ��������������
 * 		{5,7,6,9,11,10,8}
 * 		������Ϊ����������������һ���ڵ�һ���Ǹ��ڵ㣬�����ڵ�������ҽڵ㣬С������ڵ㣬���������Ϊ5,7,6��������Ϊ:9,11,10
 * 		8Ҫ�������е���������С�����е�������
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
    			//�ݹ��ҽڵ�
    			result = verifyPostorder(Arrays.copyOfRange(postorder, 0, i));
        	}else if(postorder[i]<postorder[indexEnd]&&!(mid<0)){
        		//������ڱ����ҽڵ㣬��Ҫ�ҽڵ����е�����Ҫ���ڸ��ڵ㣬�������С�ڸ��ڵ�ģ���ֱ�ӷ���false
        		return false;
        	}
    		if(!result) return result; 
        }
        if(mid<0) {//mid<0˵��û�и��ڵ�֮ǰ��û�д��ڸ��ڵ��,�����´�0��ʼ����
        	mid = 0;
        }
        result = result&&verifyPostorder(Arrays.copyOfRange(postorder, mid, indexEnd));
        //�ݹ���ڵ㣬������ҽڵ�Ľ��
        return result;
    }
	
	public static void main(String[] args) {
		int[] postorder = {5, 2, -17, -11, 25, 76, 62, 98, 92, 61};
		System.out.println(new SearchTree().verifyPostorder(postorder));
	}
}
