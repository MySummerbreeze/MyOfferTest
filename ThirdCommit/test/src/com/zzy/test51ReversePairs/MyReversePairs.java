package com.zzy.test51ReversePairs;

/**
 * ʱ�临�Ӷ�Ϊo(n^2)�Ľⷨ��
 * 		��ÿһ�������������Ƚϣ��������С�ڸ������¼
 * @author ��־��
 *
 */

public class MyReversePairs {
	public int reversePairs(int[] nums){
		if(nums == null||nums.length == 0||nums.length == 1){
			return 0;
		}
		int resultCount = 0;
		for(int i = 0;i<nums.length;i++){
			for(int j = i+1;j<nums.length;j++){
				if(nums[i]>nums[j]){
					resultCount++;
				}
			}
		}
		return resultCount;
	}
	public static void main(String[] args) {
		int[] nums = {7,5,6,4};
		System.out.println(new MyReversePairs().reversePairs(nums));
	}
}
