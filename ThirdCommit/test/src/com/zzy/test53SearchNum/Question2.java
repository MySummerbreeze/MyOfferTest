package com.zzy.test53SearchNum;

/**
 * 0~n-1��ȱʧ������:
 * 		ͬ����ʹ�ö��ַ������ַ�ʵ������Ҫ����ָ�룬��һ��ָ��ͷ��������ָ��β���ڶ����ǣ�ͷ+β��/2
 * @author ��־��
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
