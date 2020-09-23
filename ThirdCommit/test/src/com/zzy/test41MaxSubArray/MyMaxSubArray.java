package com.zzy.test41MaxSubArray;

/**
 * ǰ׺��˼�룺
 * 			-2,1,-3,4,-1,2,1
 * ǰ׺��Ϊ��0,-2,-1,-4,0,-1,1,2
 * ��ĳ������ĺͣ�Sum[r]-Sum[l-1]
 * ��������-2~1������ͣ�-1-0=-1
 * 	         ��1��4������ͣ�2--4=6
 * 		��ʽ�Ƶ���Sum[r]=Sum[l-1]+al+a(l+1)+����+ar
 * @author user
 *
 */

public class MyMaxSubArray {
	public int maxSubArray(int[] nums) {
		if(nums.length == 0||nums == null) return 0;
		if(nums.length == 1) return nums[0];
		int nowSum = 0;
		int minSum = 0;
		int max = nums[0];
		for(int i = 0;i<nums.length;i++) {
			nowSum +=nums[i];
			if(max<nowSum-minSum){
				max = nowSum-minSum;
			}
			if(nowSum<minSum) {//�����ϸ���ʱǰ׺��С��С��֮ǰ��Сǰ׺�ͣ��򽫵�ǰ��Сǰ׺�ͱ�Ϊ��ǰǰ׺��
				minSum = nowSum;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,1};
		System.out.println(new MyMaxSubArray().maxSubArray(nums));
	}
}
