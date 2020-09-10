package com.zzy.sort;

/**
 * 冒泡排序：
 * 		思想就是每一趟，找出最大的一个，比较是必须跟两个相邻的比较
 * @author user
 *	最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
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
