package com.zzy.test53SearchNum;

/**
 * 暴力法：
 * 		时间复杂度o(n)
 * @author 张志琰
 *
 */

public class SearchNum {
	public int search(int[] nums, int target) {
		int count = 0;
		for (int i = 0;i<nums.length;i++) {
			if(nums[i] == target)count++;
			if(i<nums.length-1&&nums[i] != target&&count != 0){
				break;
			}
		}
		return count;
    }
}
