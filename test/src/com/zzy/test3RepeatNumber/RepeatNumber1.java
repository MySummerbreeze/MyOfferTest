package com.zzy.test3RepeatNumber;
/**
 * ÅÅĞòÕÒ£º±©Á¦·¨
 * @author user
 *
 */
public class RepeatNumber1 {
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
	
	public static void main(String[] args) {
		RepeatNumber1 r = new RepeatNumber1();
		int[] nums = {1}; 
		System.out.println(r.findRepeatNumber(nums));
	}
}
