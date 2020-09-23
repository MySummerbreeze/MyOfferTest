package com.zzy.test43CountDigitOne;
/**
 * 暴力法求1~n整数中1出现的次数：
 * 		时间复杂度O(nlogn)
 * 显然解题可以，但是随着时间复杂度的增大，offer的几率缩小
 * @author user
 *
 */
public class MyCountDigitOne {
	public int countDigitOne(int n) {
		int count = 0;
		while(n>0) {
			int index = n;
			while(index>0) {
				if(index%10 == 1) {//如果个位数为1
					count++;
				}
				index/=10;
			}
			n--;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(new MyCountDigitOne().countDigitOne(824883294));
	}
}
