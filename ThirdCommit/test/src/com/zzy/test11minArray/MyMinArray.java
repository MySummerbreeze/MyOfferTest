package com.zzy.test11minArray;

import java.util.Arrays;

/**
 * 旋转数组的最小数字
 * @author user
 *	首先想到的是重新新建一个空间用来存放并返回，这样操作最简单
 */

public class MyMinArray {
	public static int minArray(int[] array) {
		if(array.length == 0) {
			return -1;
		}else if(array.length ==1) {
			return array[0];
		}
		int[] results = new int[array.length];
		int i = 1;
		for(;i<array.length;i++) {
			if(array[i-1]>array[i]) {
				return array[i];
			}
		}
		return array[0];
	}
	
	public static void main(String[] args) {
		int[] array = {1,3,5};
		System.out.println(minArray(array));
	}
}
