package com.zzy.test21ReorderOddEven;

public class BaseReorder {
	public static int[] exchange(int[] nums) {
		//����ָ�룬������ż��ǰ�ߣ�����low��ż����high������
		int low = 0;
		int high = nums.length-1;
		while(low<high) {
			while(low<high&&nums[low]%2 != 0) {
				low++;
			}
			while(low<high&&nums[high]%2 != 1) {
				high--;
			}
			if(low<high&&nums[low]%2 == 0&&nums[high]%2 == 1) {
				int tmp = nums[low];
				nums[low] = nums[high];
				nums[high] = tmp;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums = {};
		exchange(nums);
		for (int i : nums) {
			System.out.print(i+" ");
		}
	}
}
