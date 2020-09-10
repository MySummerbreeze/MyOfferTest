package com.zzy.sort;

/**
 * 选择排序：
 * 		思想就是每一趟找出剩下的数中最小的一个，比较是能够和任何两个数比较
 * @author user
 * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 */

public class MySelectionSort {
	
	public static void selectionSort(int[] array) {
		if(array == null||array.length == 0) {
			return;
		}
		for(int i = 0;i<array.length;i++) {
			//每一趟，找出最小的一个
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
