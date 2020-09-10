package com.zzy.sort;

/**
 * 插入排序：
 * 		主要思想：
 * 			一组数，准备一个与该数组大小相同的空数组，将每一个插入到对应的位置，就是插入排序。
 * 				如何准确的插入到对应位置，即必须大于前一个数小于后一个数
 * 			也可以只用一组数，不断交换达到插入排序的目的。
 * 				从头开始，先给第一个元素排序，再给前两个元素排序，接着是前三个，依次类推。每此排序将下一个值放入前边正确的地方。
 * @author user
 *
 */

public class MyInsertionSort {
	public static void insertionSort(int[] array) {
		for(int i = 1;i<array.length;i++) {
			for(int j = i;j>0;j--) {
				if(array[j]<array[j-1]) {
					int tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
				}else {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,-1};
		insertionSort(array);
		for (int i : array) {
			System.out.print(i+" ");
		}
	}
	
	
	
}
