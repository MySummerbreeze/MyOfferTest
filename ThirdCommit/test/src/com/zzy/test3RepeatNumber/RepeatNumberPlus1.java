package com.zzy.test3RepeatNumber;
/**
 * ���޸������ҳ��ظ�������
 * ����һ��
 * 		�����ⷨ��˫��ѭ�����÷���û�иı����飩
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
