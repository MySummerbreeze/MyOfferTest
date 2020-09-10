package com.zzy.test10Fibonacci;
/**
 * 
 * @author user
 *
 */
public class Fibonacci {
	/**
	 * 数组
	 * @param n
	 * @return
	 */
	public static int fib(int n) {
		if(n == 0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		int[] is = new int[n+1];
		is[0] = 0;
		is[1] = 1;
		for(int i = 2;i<=n;i++) {
			is[i] = is[i-1]+is[i-2];
			is[i] %= 1000000007;
		}
		
		return is[n];
    }
	/**
	 * 递归：超时，代码可读性强，但质量差
	 * @param n
	 * @return
	 */
	public static int fib1(int n) {
        if(n == 0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		int fn = fib(n-1)+fib(n-2);
		fn%=1000000007;
		return fn;
    }
	
	/**
	 * 使用三个数，太繁琐，不建议，最好的还是使用数组
	 * @param args
	 */
	public static int fib2(int n) {
        if(n == 0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		if(n==2){
			return 1;
		}
		int i = 0,j = 1,k = i+j;
		int index = 0;
		while(true) {
			if(index!=n) {
				i = j+k;
				index++;
			}else return i;
			i%=1000000007;
			if(index!=n) {
				k = i+j;
				index++;
			}else return k;
			k%=1000000007;
			if(index!=n) {
				j = k+i;
				index++;
			}else return j;
			j%=1000000007;
		}
    }
	public static void main(String[] args) {
		System.out.println(fib2(100000000));
		System.out.println(fib(100000000));
	}
}
