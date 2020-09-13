package com.zzy.test3RepeatNumber;
/**
 * 最优解：
 * 		数组中的数字作为下标：将每一个数放入下标与值相同的位置，例如值2，放入与数组中下标为2的值交换
 * 		例如：{2,3,1,0,2,5,3}		第一个元素2，应该到下标为2的地方，因此与1交换
 * 			{1,3,2,0,2,5,3}		第二个元素3，应该到下标为3的地方，因此与0交换
 * 			{1,0,2,3,2,5,3}		第三个元素2，上边交换过，已经满足下标与值相等
 * 			{1,0,2,3,2,5,3}		第四个元素同上
 * 		变为：{1,0,2,3,2,5,3}		第五个元素下标与值不同，满足返回条件
 * @author user
 *
 */
public class RepeatNumber2 {
	public int findRepeatNumber(int[] nums) {
		/**
		 * 先判断是否为空
		 */
		if(nums.length == 0||nums == null) {
			return -1;
		}
		/**
		 * 再判断是否有小于0的数，一遍遍历
		 */
		for(int i = 0;i<nums.length;i++) {
			if(nums[i]<0) {
				return -1;
			}
		}
		//重点
		int i = 0;
		while(i<nums.length) {//遍历数组
			if(nums[i] == i) {//若当前下标与对应的值相同，则跳过此次循环，进行下一次循环
				i++;
				continue;
			}
			if(nums[nums[i]] == nums[i]) {//若当前值与当前值作为下标所对应的值相同时，直接返回该值，因为重复
				return nums[i];
			}
			//进行交换操作
			//具体操作见上
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
