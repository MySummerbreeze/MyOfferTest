package com.zzy.test53SearchNum;

/**
 * ��������
 * 		ʱ�临�Ӷ�o(n)
 * @author ��־��
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
