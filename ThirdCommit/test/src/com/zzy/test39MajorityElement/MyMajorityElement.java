package com.zzy.test39MajorityElement;

/**
 * 剑指Offer提供了两种思路：
 * 		一种是基于数组的特性：
 * 			两个变量，一个为次数，一个为数组中的一个数字，只需要遍历一遍数组，当是该数字的时候次数+1，当不是改数字的时候次数减一
 * @author user
 *
 */

public class MyMajorityElement {
	public int majorityElement(int[] nums) {
		if(nums == null||nums.length == 0) {
			return 0;
		}
		int num = nums[0];
		int count = 1;
		for(int i = 1;i<nums.length;i++) {
			if(count == 0) {
				num = nums[i];
			}
			if(nums[i] == num) {
				count++;
			}else count--;
		}
		return num;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
		System.out.println(new MyMajorityElement().majorityElement(nums));
	}
}
