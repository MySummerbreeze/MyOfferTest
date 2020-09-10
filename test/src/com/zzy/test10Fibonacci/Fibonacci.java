package com.zzy.test10Fibonacci;
/**
 * 
 * @author user
 *
 */
public class Fibonacci {
	/**
	 * ����
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
	 * �ݹ飺��ʱ������ɶ���ǿ����������
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
	 * ʹ����������̫�����������飬��õĻ���ʹ������
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
