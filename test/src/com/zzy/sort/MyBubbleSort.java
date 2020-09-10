package com.zzy.sort;

/**
 * ð������
 * 		˼�����ÿһ�ˣ��ҳ�����һ�����Ƚ��Ǳ�����������ڵıȽ�
 * @author user
 *	��������T(n) = O(n)   ��������T(n) = O(n2)   ƽ�������T(n) = O(n2)
 */

public class MyBubbleSort {
	public static void bubbleSort(int[] array) {
		for(int i = 0;i<array.length;i++) {
			
			//j<array.length-i-1
			for(int j = 0;j<array.length-i-1;j++) {
				if(array[j+1]<array[j]) {
					int t = array[j+1];
					array[j+1] = array[j];
					array[j] = t;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2,6,4,9,5,7,3,1,8};
		bubbleSort(array);
		for (int i : array) {
			System.out.print(i+" ");
		}
	}
}
