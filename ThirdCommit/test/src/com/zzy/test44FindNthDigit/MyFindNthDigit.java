package com.zzy.test44FindNthDigit;

/**
 * 数字序列中某一位的数字:
 * 	if:n>10&&n<(10+2*(100-10))---->说明n所找的数是二位数，找n(99)：(n-10)/2 = 44,(n-10)%2 = 1(第二个数)
 * 	if:n>(10+2*(100-10))&&n<(100+3*(1000-100))----->说明n所找的数是三位数
 * @author user
 *
 */

public class MyFindNthDigit {
	public int findNthDigit(int n) {
		if(n<10) {//n<10直接返回自己，因为是个位
			return n;
		}
		long digit = 2;//位数，初始化为2，十位数
		long dig = 10;//digit^10
		long start = 10;
		long end = start+digit*(dig*10-dig);//10+180+2700+360000,(100-10)*2
		while(true) {
			if(n>=start && n<end) {
				long result = (n-start)/digit+dig;
				long num = (n-start)%digit;
				String str = String.valueOf(result);
				return Integer.parseInt(String.valueOf(str.charAt((int)num)));
			}else {
				dig*=10;
				digit++;
				start = end;
				end += digit*(dig*10-dig);
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(new MyFindNthDigit().findNthDigit(1000000000));
	}
}
