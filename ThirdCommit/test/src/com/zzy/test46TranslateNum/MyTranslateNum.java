package com.zzy.test46TranslateNum;

/**
 * 把数字翻译成字符串：
 * 		使用动态规划为最优解：
 * 		通过计算得知，该题满足公式：f(n) =f(n-2)+f(n-1)（斐波那契数列） 
 * 				——>1						=f(n-1)两数不呢组成a~z的情况
 * 		1		——>1
 * 		1,2		——>2
 * 		1,2,2	——>3
 * 		1,2,2,5	——>5
 * 		1,2,2,8	——>3
 * @author user
 *
 */

public class MyTranslateNum {
	public int translateNum(int num) {
		//将num转为字符串
		String str = String.valueOf(num);
		if(str.length()<2) {
			return str.length();
		}
		
		//新建结果集dp
		int pre = 1;//初始化前两个值
		int cur = 1;
		int result = 0;
		//for循环求出dp这个数组
		for(int i = 1;i<str.length();i++) {//i是dp的下标,j是str的下标
			if((str.charAt(i)-'0')+(str.charAt(i-1)-'0')*10 >= 10&&(str.charAt(i)-'0')+(str.charAt(i-1)-'0')*10 < 26) {//如果说当前值与上一个值相加最终结果在10-26之间，则dp[i] = dp[i-1]+dp[i-2];
				result = pre+cur;
			}else {
				result = cur;
			}
			pre = cur;
			cur = result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new MyTranslateNum().translateNum(12258));
	}
	
}
