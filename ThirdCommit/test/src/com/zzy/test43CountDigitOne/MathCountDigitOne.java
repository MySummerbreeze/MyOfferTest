package com.zzy.test43CountDigitOne;

/**
 * 数学方法解决：
 * 		找出每一位的1的个数，即所有个位的1+十位的1+百位的1……
 * 		每一位的1的个数由其本身的值，以及高位，和低位的值一起决定
 * 		例如：203，拿0这个位数来说，203及以下的书在十位上为1 的一共为20个，高位为2，低位为3
 * 		cur代表本位的值，high代表高位值，low代表低位值，dig为位数，十位为10，百位为100
 * 		当cur = 0时，本位的1的个数为：high*dig
 * 		当cur = 1时，1的个数为：high*dig+low+1
 * 		当cur > 1时，1的个数为：(high+1)*dig
 * @author user
 *
 */

public class MathCountDigitOne {
	public int countDigitOne(int n) {
		int count = 0;
		int dig = 1;
		int high = n;
		int cur = 0;
		while(high>0) {
			cur = high%10;
			high = high/10;
			int low = n%dig;
			if(cur == 0) {
				count += high*dig;
			}else if(cur == 1) {
				count += high*dig+low+1;
			}else {
				count += (high+1)*dig;
			}
			dig*=10;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(new MathCountDigitOne().countDigitOne(824883294));
	}
}
