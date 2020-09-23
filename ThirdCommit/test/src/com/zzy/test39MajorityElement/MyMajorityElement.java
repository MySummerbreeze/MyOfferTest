package com.zzy.test39MajorityElement;

/**
 * ��ָOffer�ṩ������˼·��
 * 		һ���ǻ�����������ԣ�
 * 			����������һ��Ϊ������һ��Ϊ�����е�һ�����֣�ֻ��Ҫ����һ�����飬���Ǹ����ֵ�ʱ�����+1�������Ǹ����ֵ�ʱ�������һ
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
