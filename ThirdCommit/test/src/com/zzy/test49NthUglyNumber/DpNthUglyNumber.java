package com.zzy.test49NthUglyNumber;

public class DpNthUglyNumber {
	public int nthUglyNumber(int n){
		if(n == 0)return 0;
		if(n == 1)return 1;
		int[] dp = new int[n];
		int index = 1;
		int a = 0;
		int b = 0;
		int c = 0;
		dp[0] = 1;
		while(index<n){
			dp[index] = Math.min(dp[a]*2, Math.min(dp[b]*3, dp[c]*5));
			if(dp[index] == dp[a]*2)a++;
			if(dp[index] == dp[b]*3)b++;
			if(dp[index] == dp[c]*5)c++;
			index++;
		}
		return dp[n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(new DpNthUglyNumber().nthUglyNumber(1325));
	}
}
