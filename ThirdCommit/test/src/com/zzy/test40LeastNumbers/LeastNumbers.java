package com.zzy.test40LeastNumbers;

import java.util.Arrays;

public class LeastNumbers {
	public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0||arr == null||arr.length == 0) {
        	return new int[0];
        }
        if(k>=arr.length) {
        	return arr;
        }
        partitionArray(arr, 0, arr.length - 1, k);
		return Arrays.copyOfRange(arr, 0, k);
    }
	void partitionArray(int[] arr, int lo, int hi, int k) {
	    // 做一次 partition 操作
	    int m = partition(arr, lo, hi);
	    // 此时数组前 m 个数，就是最小的 m 个数
	    if (k == m) {
	        // 正好找到最小的 k(m) 个数
	        return;
	    } else if (k < m) {
	        // 最小的 k 个数一定在前 m 个数中，递归划分
	        partitionArray(arr, lo, m-1, k);
	    } else {
	        // 在右侧数组中寻找最小的 k-m 个数
	        partitionArray(arr, m+1, hi, k);
	    }
	}

	int partition(int[] arr,int start,int end) {
		int low = start;
		int high = end;
		int base = arr[high];
		while(true) {
			while(low<high&&arr[low]<=base) {
				low++;
			}
			while(low<high&&arr[high]>=base) {
				high--;
			}
			if(low<high) {
				int tmp = arr[low];
				arr[low] = arr[high];
				arr[high] = tmp;
			}else {
				arr[end] = arr[low];
				arr[low] = base;
				break;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
		nums = new LeastNumbers().getLeastNumbers(nums,5);
		for (int i : nums) {
			System.out.print(i+" ");
		}
	}
}
