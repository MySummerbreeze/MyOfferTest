package com.zzy.test41MaxSubArray;

/**
 * 前缀和思想：
 * 			-2,1,-3,4,-1,2,1
 * 前缀和为：0,-2,-1,-4,0,-1,1,2
 * 求某个区间的和：Sum[r]-Sum[l-1]
 * 举例：求-2~1的区间和：-1-0=-1
 * 	         求1到4的区间和：2--4=6
 * 		公式推导：Sum[r]=Sum[l-1]+al+a(l+1)+……+ar
 * @author user
 *
 */

public class MyMaxSubArray {
	public int maxSubArray(int[] nums) {
		if(nums.length == 0||nums == null) return 0;
		if(nums.length == 1) return nums[0];
		int nowSum = 0;
		int minSum = 0;
		int max = nums[0];
		for(int i = 0;i<nums.length;i++) {
			nowSum +=nums[i];
			if(max<nowSum-minSum){
				max = nowSum-minSum;
			}
			if(nowSum<minSum) {//当加上该数时前缀最小和小于之前最小前缀和，则将当前最小前缀和变为当前前缀和
				minSum = nowSum;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,1};
		System.out.println(new MyMaxSubArray().maxSubArray(nums));
	}
}
