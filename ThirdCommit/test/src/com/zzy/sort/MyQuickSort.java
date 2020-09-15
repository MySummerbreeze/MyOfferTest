package com.zzy.sort;

/**
 * 快速排序的思想是：
 * 		找出一个基准值，将小于基准值的数放置在基准值的左边，大于基准值的数放置在基准值的右边
 * 		（一般基准值选取是左端右端和中间位置三个数的中位数作为基准）
 * 		实现这一思想使用的是双指针法：（基准值默认在0的位置）
 * 			两个指针，一个指向0，一个指向length-1,基准值先与length-1比较，若小于基准值，则将其赋值给0
 * @author user
 *	快速排序平均时间复杂度O（nlogn），最好情况O（nlogn），最坏情况，O（n^2）,空间复杂度O(logn),不稳定
 *		
 *		快速排序正常写法：
 *		         （partition二分）一个函数用来实现找到一个基准，将数组进行简单排序（将小于基准的放置在左边，大于的放置在右边）
 *		并准确的将该基准放入应在的位置，返回值是该基准的下标
 *		         一个quickSort函数：作为主调用函数用来实现递归
 */

public class MyQuickSort {
	
	public static void quickSort(int[] array,int start,int end) {
		//若最终只剩一个数则直接返回
		if(start>=end) {
			return;
		}
		int low = start;
		int high = end;
		//最后一个值作为基准
		int tmp = array[high];
		while(low<high) {
			while(tmp<array[low]&&low<high) {
				low++;
			}
			while(tmp>array[high]&&low<high) {
				high--;
			}
			if(low<high) {
				int t = array[low];
				array[low] = array[high];
				array[high] = t;
			}else {
				//交换最后的值
				array[end] = array[low];
				array[low] = tmp;
			}
		}
		//递归调用左半数组
        quickSort(array, start, low-1);
        //递归调用右半数组
        quickSort(array, low+1, end);
	}
	
	public static void main(String[] args) {
		int[] array = {2,1,6,4,5,9};
		quickSort(array,0,array.length-1);
		for (int i : array) {
			System.out.print(i+" ");
		}
	}
	
}
