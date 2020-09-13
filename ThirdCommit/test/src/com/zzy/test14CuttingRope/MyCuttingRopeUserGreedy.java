package com.zzy.test14CuttingRope;

/**
 * 剪绳子使用贪心算法：
 * 		贪心算法解释：
 * 			例如，平时购物找零钱时，为使找回的零钱的硬币数最少，
 *  		不要求找零钱的所有方案，而是从最大面值的币种开始，
 *  		按递减的顺序考虑各面额，先尽量用大面值的面额，
 *  		当不足大面值时才去考虑下一个较小面值，这就是贪心算法
 *  	贪心算法在本例的使用：
 *  		f(4) = 2*2
 *  		f(5) = 2*3
 *  		f(6) = 3*3
 *  		f(7) = 2*2*3
 *  		f(8) = 2*3*3
 *  		f(9) = 3*3*3
 *  		f(10) = 2*2*3*3
 *  		由此可以看出其实所有的解法都与2和3有关系，因此我们可以试着去找一个n中有几个3
 *  		例如：9的话就是3个三，那就是3的3次方
 *  			10的话就是3个三，和一个1，当出现1时，我们知道该数中需要含有一个4即2*2
 *  			8的话就是2个三，和一个2
 *  		所以有了以上规律，我们就可以编写出如下代码
 * @author user
 *
 */

public class MyCuttingRopeUserGreedy {
	public static int cuttingRope(int n) {
		//我们将小于等于三并且能够不经过运算直接返回的值返回，0,1,2,3
		//0和1返回的是同一个值0
		if(n<2) {
			return 0;
		}
		if(n == 2) {
			return 1;
		}
		if(n == 3) {
			return 2;
		}
		
		//使用一个变量来存储n中有几个3
		int count = n/3;
		long mod = 1000000007;
		//判断当n去掉所有3之后剩下的数
		//若剩下了1，则说明与10类型想同，即让出一个三与1结合变成4
		long result = 1;
		if(n%3 == 1) {
			for(int i = 0;i<count-1;i++) {
				result *= 3;
				result %= mod;
			}
			result *= 4;
		}
		if(n%3 == 2) {
			for(int i = 0;i<count;i++) {
				result *= 3;
				result %= mod;
			}
			result *= 2;
		}
		if(n%3 == 0) {
			for(int i = 0;i<count;i++) {
				result *= 3;
				result %= mod;
			}
		}
		return (int) (result%mod);
	}
	
	public static void main(String[] args) {
		System.out.println(1%1000000007);
		System.out.println(cuttingRope(1000));
	}
}
