package com.zzy.test49NthUglyNumber;

/**
 * 暴力解法：
 * 		循环遍历每一个数字，是否为丑数（判断该数字是否能够被2.3.5整除最终结果为1）
 * 最终提交超时
 * @author zzy
 *
 */

public class MyNthUglyNumber {
	public int nthUglyNumber(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		int count = 0;
		int i = 0;
		while(count<n){
			++i;
			if(isUgly(i)){
				count++;
			}
		}
		return i;
	}
	
	public boolean isUgly(int num){
		while(num % 2 == 0){
			num/=2;
		}
		while(num % 3 == 0){
			num/=3;
		}
		while(num % 5 == 0){
			num/=5;
		}
		return (num == 1)?true:false;
	}
	
	public static void main(String[] args) {
		System.out.println(new MyNthUglyNumber().nthUglyNumber(1000));
	}
}
