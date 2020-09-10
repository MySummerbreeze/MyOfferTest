package com.zzy.sort;

/**
 * ѡ������
 * 		˼�����ÿһ���ҳ�ʣ�µ�������С��һ�����Ƚ����ܹ����κ��������Ƚ�
 * @author user
 * ��������T(n) = O(n2)  ��������T(n) = O(n2)  ƽ�������T(n) = O(n2)
 */

public class MySelectionSort {
	
	public static void selectionSort(int[] array) {
		if(array == null||array.length == 0) {
			return;
		}
		for(int i = 0;i<array.length;i++) {
			//ÿһ�ˣ��ҳ���С��һ��
			int minIndex = i;
			for(int j = i+1;j<array.length;j++) {
				if(array[j]<array[i]) {
					minIndex = j;
				}
			}
			int tmp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = tmp;
		}
	}
	
	
	public static void main(String[] args) {
		int[] is = new int[] {9,2,5,6,4,8,3,1,7};
		selectionSort(is);
		for (int i : is) {
			System.out.print(i+" ");
		}
	}
}
