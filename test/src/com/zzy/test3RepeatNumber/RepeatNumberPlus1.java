package com.zzy.test3RepeatNumber;
/**
 * 不修改数组找出重复的数字
 * 方法一：
 * 		暴力解法：双重循环（该方法没有改变数组）
 * @author user
 *
 */
public class RepeatNumberPlus1 {
	public int findRepeatNumber(int[] nums) {
		for(int i = 0;i<nums.length;i++) {
			for(int j = i+1;j<nums.length;j++) {
				if(nums[i]==nums[j]) {
					return nums[i];
				}
			}
		}
		return -1;
    }
}
