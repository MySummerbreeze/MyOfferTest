package com.zzy.test16Power;

/**
 * 数值的整数次方：
 * 		该面试题旨在让我们模仿编写Math.pow(double base,int exponent)方法，
 * 		我们可以很容易的想到使用n此循环，
 * 		但这题考察的不在于此，而是检查你的想法，你能否想到当边界条件怎样去实现
 * 		当exponent为0时，为负数时，当base为0时，为负数时，你考虑到了没有？
 * 		我们可以知道，当指数为0，任何数都为1，但0的0次方没有意义，所以无论是返回1还是0皆可
 * 		另外我们可以想到，当指数为负数时，我们可以先将其求绝对值，最后我们可以进行循环，最后进行求导
 * 		但当基数也就是base为0时，如何求导？显然会报错，因此我们需要求证面试官一个解决错误的方法
 * 以上是剑指Offer提供的基础解法，但没有考虑到效率问题，接下来他为我们提供了一个更为效率的解决方法
 * 		当指数为32时，可以看做时base^8^2、base^4^2^2……
 * 		可以有这么一个公式：a^n = a^(n/2)*a^(n/2)				n为偶数
 * 							a^((n-1)/2)*a^((n-1)/2)*a	n为奇数
 * 		使用递归
 * 指数为负解决：我自己的解决方法是一个Boolean类型作为标记，到最后result求倒数
 * 			但在LeetCode中看到一个解决方法是直接将base求倒数，使用倒数进行运算
 * 
 * 在题解时遇到的问题：
 * 		第一次提交错误，是在递归函数中使用了：return pow(base,exponent/2)*pow(base,exponent/2);，这与循环没区别，时间复杂度与循环一样，O(n)
 * 		第二次提交错误，测试用例为：2.00000 -2147483648:
 * 			首先我们看到-2147483648，就知道是int的边界条件，但我们需要知道，Integer.MAX_VALUE = 2147483647;
 * 			int的最大值存不了2147483648，所以无论怎样不能赋值，
 * 			而且根据测试了解到Integer.MAX_VALUE+1 = Integer.MIN_VALUE，Integer.MAX_VALUE+2 = Integer.MIN_VALUE+1……
 * 			但是int i = 2147483647+1;
 * 			百度一下：
 * 			Integer.max_value = 01111111 111111111111111111111111 01111111
 * 			111111111111111111111111+1= 10000000 00000000 00000000 00000000
 * 			最高位是符号位为1，是负数，负数的源码是补码取反+1，刚好等于Integer.min_value
 * @author user
 *
 */

public class MyPower {
	//基础解法，直接超时，不可取
	public static double basePow(double base,int exponent) {
		if(exponent == 0) {
			return 1;
		}
		boolean eIsNegative = false;
		if(exponent < 0) {
			eIsNegative = true;
			exponent = -exponent;
		}
		double result = 1.0000;
		while(exponent != 0) {
			result *= base;
			exponent--;
		}
		if(eIsNegative) {//若是负号，则需要求倒数
			if(result == 0) {
				return 0;
			}
			result = 1.0/result;
		}
		return result;
	}
	
	public static double myPow(double base, int exponent) {
		if(exponent == 0) {
			return 1;
		}
		//使用long类型存储，因为当MAX_VALUE取负数时int类型不能存储
		long e = exponent;
		boolean eIsNegative = false;
		if(exponent < 0) {
			eIsNegative = true;
			e = -e;
		}
		double result = pow(base,e);
		if(eIsNegative) {//若是负号，则需要求倒数
			if(result == 0) {
				return 0;
			}
			result = 1.0/result;
		}
		return result;
	}
	
	
	//只需要解决次方问题，不需要解决边界问题
	public static double pow(double base,long exponent) {
		double result = 1;
		if(exponent == 1) {
			return base;
		}else if(exponent%2 == 1) {
			result = pow(base,(exponent-1)/2);
			return result*result*base;
		}else if(exponent%2 == 0) {
			result = pow(base,exponent/2);
			return result*result;
		}
		return -1;
	}
	
	public static void main(String[] args) {
//		System.out.println(myPow(2.00000,-2147483648));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		int i = Integer.MAX_VALUE+1;
		System.out.println(i);
		
	}
}
