package com.zzy.test3RepeatNumber;
/**
 * 不修改数组找出重复数字
 * 方法二：（官方解法）
 * 		类似于二分法解法：
 * 			按照题目要求，数组中的值小于等于nums.length-1
 * 			因此数组中的值在0~nums.length-1这个范围中
 * 			例如：nums.length-1 = 7
 * 			按照二分法，将范围分为两部分：0~4,5~7
 * 			若0~4中的数字的数目大于4+1，说明0~4中的数字有重复（0开始）
 * 			按照二分法，将范围分为两部分：0~2,3~4
 * 			若0~2中的数字的数目大于2+1，说明0~2中的数字有重复
 * 			.....(依次重复)
 * @author user
 *
 */
public class RepeatNumberPlus2 {
	
}
