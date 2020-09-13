package com.zzy.test14CuttingRope;

/**
 * 剪绳子：
 * 		其实，我们可以知道，当绳子小于等于3时，我们的剪法时固定的，没有太多的变化
 * 		因此前三个直接可以使用判断来写
 * 		最直接的解法就是动态规划（将其分为n个小问题，每一个小问题合起来就是该问题）
 * @author user
 *
 */

public class MyCuttingRope {
	public static int cuttingRope(int n) {
        //首先判断边界条件
		if(n < 2) {
			return 0;
		}
		if(n == 2) {
			return 1;
		}
		if(n == 3) {
			return 2;
		}
		
		//其次，一个数组存放所有可能的值（n从4到n的最大值）,n+1的原因是从0开始的
		int[] products = new int[n+1];
		//以下四个数表示，第一剪下去所能得到的最大值
		//例如：剪1的时候，任何数只能乘以1
		//剪二的时候，任何数乘以二
		//剪4的时候，因为当n=4的时候的最大值是4，所以，其余的数可以乘以4
		//剪5的时候，n=5时最大值是6，所以直接乘以6，而不用再分为2*3，所以省去了步骤
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		//第一层循环，遍历到n,从4开始
		for(int i = 4;i<=n;i++) {
			//第二层循环，找每一个的最大值
			for(int j = 2;j<=i/2;j++) {
				products[i] = products[i]>products[j]*products[i-j] ? products[i]: products[j]*products[i-j];
			}
		}
		return products[n];
    }
	
	public static void main(String[] args) {
		System.out.println(cuttingRope(10));
	}
}
