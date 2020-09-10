package com.zzy.sort;

import java.util.Arrays;

/**
 * 归并排序：
 * 		9,2,5,6,4,8,3,1,7
 * 		2,9,5,6,4,8,1,3,7
 * 		2,5,6,9,1,3,4,8,7
 * 		1,2,3,4,5,6,8,9,7
 * 		1,2,3,4,5,6,7,8,9
 * 		以上是归并排序的顺序：
 * 			现将其分为两两一组，将每组排序
 * 			再将其分为每四个一组，将上边两两一组合并，依次循环
 * 		具体代码实现：
 * 			一个函数实现数组分组，并实现递归
 * 			一个函数实现两两数组合并（两两数组是有序的数组）
 * 
 * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
 * @author user
 *
 */

public class MyMergeSort {
	public static int[] MergeSort(int[] array) {
		//若只有一个或者是0个，则触底返回
		if(array.length<2) {
			return array;
		}
		int mid = array.length/2;
		int[] left = Arrays.copyOfRange(array, 0, mid);
		int[] right = Arrays.copyOfRange(array, mid, array.length);
		return Merge(MergeSort(left),MergeSort(right));		
	}
	
	//两两数组合并
	public static int[] Merge(int[] left,int[] right) {
		//一个用来存放合并后的数组
		int[] array = new int[left.length+right.length];
		//循环遍历，直到两个数组中没有数
		int leftIndex = 0;
		int rightIndex = 0;
		int rsIndex = 0;
		//循环将两者最小的放入最终返回结果中
		while((leftIndex<left.length&&left.length>0)&&(rightIndex<right.length&&right.length>0)) {
			if(left[leftIndex]<right[rightIndex]) {
				array[rsIndex++] = left[leftIndex++];
			}else{
				array[rsIndex++] = right[rightIndex++];
			}
		}
		//查看是否有剩下的
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
		
		//测试合并
		/*int[] left = {2,9},right = {1,2};
		int[] array = Merge(left,right);*/
		
		int[] array = MergeSort(new int[] {9,2,5,6,4,8,3,1,7});
		
		for (int i : array) {
			System.out.print(i+" ");
		}
		
	}
}
