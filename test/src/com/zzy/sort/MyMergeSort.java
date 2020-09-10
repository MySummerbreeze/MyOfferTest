package com.zzy.sort;

import java.util.Arrays;

/**
 * �鲢����
 * 		9,2,5,6,4,8,3,1,7
 * 		2,9,5,6,4,8,1,3,7
 * 		2,5,6,9,1,3,4,8,7
 * 		1,2,3,4,5,6,8,9,7
 * 		1,2,3,4,5,6,7,8,9
 * 		�����ǹ鲢�����˳��
 * 			�ֽ����Ϊ����һ�飬��ÿ������
 * 			�ٽ����Ϊÿ�ĸ�һ�飬���ϱ�����һ��ϲ�������ѭ��
 * 		�������ʵ�֣�
 * 			һ������ʵ��������飬��ʵ�ֵݹ�
 * 			һ������ʵ����������ϲ���������������������飩
 * 
 * ��������T(n) = O(n)  ��������T(n) = O(nlogn)  ƽ�������T(n) = O(nlogn)
 * @author user
 *
 */

public class MyMergeSort {
	public static int[] MergeSort(int[] array) {
		//��ֻ��һ��������0�����򴥵׷���
		if(array.length<2) {
			return array;
		}
		int mid = array.length/2;
		int[] left = Arrays.copyOfRange(array, 0, mid);
		int[] right = Arrays.copyOfRange(array, mid, array.length);
		return Merge(MergeSort(left),MergeSort(right));		
	}
	
	//��������ϲ�
	public static int[] Merge(int[] left,int[] right) {
		//һ��������źϲ��������
		int[] array = new int[left.length+right.length];
		//ѭ��������ֱ������������û����
		int leftIndex = 0;
		int rightIndex = 0;
		int rsIndex = 0;
		//ѭ����������С�ķ������շ��ؽ����
		while((leftIndex<left.length&&left.length>0)&&(rightIndex<right.length&&right.length>0)) {
			if(left[leftIndex]<right[rightIndex]) {
				array[rsIndex++] = left[leftIndex++];
			}else{
				array[rsIndex++] = right[rightIndex++];
			}
		}
		//�鿴�Ƿ���ʣ�µ�
		if(leftIndex != left.length) {
			while(leftIndex<left.length) {
				array[rsIndex++] = left[leftIndex++];
			}
		}
		if(rightIndex != right.length) {
			while(rightIndex<right.length) {
				array[rsIndex++] = right[rightIndex++];
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		
		//���Ժϲ�
		/*int[] left = {2,9},right = {1,2};
		int[] array = Merge(left,right);*/
		
		int[] array = MergeSort(new int[] {9,2,5,6,4,8,3,1,7});
		
		for (int i : array) {
			System.out.print(i+" ");
		}
		
	}
}
