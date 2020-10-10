package com.zzy.test53SearchNum;

/**
 * 0~n-1中缺失的数字:
 * 		同样的使用二分法：二分法实际上需要三个指针，第一个指向头，第三个指向尾，第二个是（头+尾）/2
 * @author 张志琰
 *
 */

public class Question2 {
	public int missingNumber(int[] nums) {
		int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
