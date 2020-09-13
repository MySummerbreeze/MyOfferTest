package com.zzy.test17PrintMax;

import java.util.Stack;

/**
 * 打印从1到最大的n位数：
 * 		在LeetCode中要求返回数组，用数组存放，于是写下了以下demo
 * 		看清楚题目，然后定义数组，了解到数组的大小应该是10^n-1,我们可以定义一个长度为10^n的数组
 * 		
 * 显然LeetCode缩小了题的难度，只用一个数组存放，将会占用计算机很大的空间，会使空间复杂度变得十分大：
 * 因此我们需要根据剑指Offer中的思路操作：打印的数将会无限放大
 * 		由于n会很大,大到long long类型都存储不了，所以我们只能使用字符串或是字符数组
 * 		在LeetCode中使用数组，因为数组是没有最大限度的，数组的最大程度取决于计算机
 * 		剑指Offer给我们提供了一个方法：
 * 			使用字符串模拟数字的加1操作
 * 		
 * 
 * 2020/9/12记录：做不出来
 * @author user
 *
 */

public class MyPrintNumbers {
	public static int[] printNumbers(int n) {
		int[] results = new int[(int) Math.pow(10, n)-1];
		for(int i = 0;i<results.length;i++) {
			results[i] = i+1;
		}
		return results;
	}
	
	public static void printNumbersModelPlus(int n) {
		//9个数
		char[] cs = {'0','1','2','3','4','5','6','7','8','9'};
		long printNums = (long)Math.pow(10, n)-1;
		//当前位数
		int length = 1;
		char[] result = new char[n];
		while(printNums>0) {
			//计10器，每10length+1
			int i = 0;
			for(;i<10&&printNums>0;i++) {
				result[n] = cs[i];
				printNums--;
			}
			length++;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("is "+ 100 + 5);
		System.out.println(100 + 5 +"is ");
		System.out.println("is "+ (100 + 5));
	}
}

class Base{
    public Base(String s){
        System.out.print("B");
    }

}
