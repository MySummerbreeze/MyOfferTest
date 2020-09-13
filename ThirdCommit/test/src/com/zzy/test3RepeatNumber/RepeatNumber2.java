package com.zzy.test3RepeatNumber;
/**
 * ���Ž⣺
 * 		�����е�������Ϊ�±꣺��ÿһ���������±���ֵ��ͬ��λ�ã�����ֵ2���������������±�Ϊ2��ֵ����
 * 		���磺{2,3,1,0,2,5,3}		��һ��Ԫ��2��Ӧ�õ��±�Ϊ2�ĵط��������1����
 * 			{1,3,2,0,2,5,3}		�ڶ���Ԫ��3��Ӧ�õ��±�Ϊ3�ĵط��������0����
 * 			{1,0,2,3,2,5,3}		������Ԫ��2���ϱ߽��������Ѿ������±���ֵ���
 * 			{1,0,2,3,2,5,3}		���ĸ�Ԫ��ͬ��
 * 		��Ϊ��{1,0,2,3,2,5,3}		�����Ԫ���±���ֵ��ͬ�����㷵������
 * @author user
 *
 */
public class RepeatNumber2 {
	public int findRepeatNumber(int[] nums) {
		/**
		 * ���ж��Ƿ�Ϊ��
		 */
		if(nums.length == 0||nums == null) {
			return -1;
		}
		/**
		 * ���ж��Ƿ���С��0������һ�����
		 */
		for(int i = 0;i<nums.length;i++) {
			if(nums[i]<0) {
				return -1;
			}
		}
		//�ص�
		int i = 0;
		while(i<nums.length) {//��������
			if(nums[i] == i) {//����ǰ�±����Ӧ��ֵ��ͬ���������˴�ѭ����������һ��ѭ��
				i++;
				continue;
			}
			if(nums[nums[i]] == nums[i]) {//����ǰֵ�뵱ǰֵ��Ϊ�±�����Ӧ��ֵ��ͬʱ��ֱ�ӷ��ظ�ֵ����Ϊ�ظ�
				return nums[i];
			}
			//���н�������
			//�����������
			int tmp = nums[i];
			nums[i] = nums[tmp];
			nums[tmp] = tmp;
		}
		return -1;
    }
	
	public static void main(String[] args) {
		RepeatNumber2 r = new RepeatNumber2();
		int[] nums = {3, 1, 0, 2, 5, 3}; 
		System.out.println(r.findRepeatNumber(nums));
	}

}
