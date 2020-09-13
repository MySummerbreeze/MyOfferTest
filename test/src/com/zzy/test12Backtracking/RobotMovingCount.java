package com.zzy.test12Backtracking;

/**
 * 机器人的运动范围：
 * 		每次只能上下左右移动一格，还是回溯算法
 * 		可以构建一个矩阵，机器人走过的点，记录
 * 		利用回溯算法，还是有触界返回
 * @author user
 *
 */

public class RobotMovingCount {
	public static int movingCount(int m, int n, int k) {
		/**
		 * 本函数做初始化工作，回溯法为另一个函数
		 */
		
		//首先判断极端条件
		if(m<=0||n<=0) {
			return 0;
		}
		if(k==0) {
			return 1;
		}
		//为true则说明已经便利过
		boolean[][] bs = new boolean[m][n];
		
		return dfs(0,0,m,n,bs,k);
	}
	
	public static int dfs(int row, int col, int rows, int cols, boolean[][] bs, int k) {
		int count = 0;
		//判断边界条件,如果触界，或是走过，或是不能走，都直接返回0
		if(row<0||row>=rows||col<0||col>=cols||bs[row][col] == true||!checkGo(row,col,k)) {
			return 0;
		}
		//到这一步说明该点可以走，则将其赋值true
		bs[row][col] = true;
		count = dfs(row+1,col,rows,cols,bs,k)+dfs(row-1,col,rows,cols,bs,k)+dfs(row,col+1,rows,cols,bs,k)+dfs(row,col-1,rows,cols,bs,k);
		return ++count;
	}

	//判断是否该点能走，能走则返回true，不能返回false
	public static boolean checkGo(int row, int col, int k) {
		int number = 0;
		while(row>0) {
			number += row%10;
			row /= 10;
		}
		while(col>0) {
			number += col%10;
			col /= 10;
		}
		if(number<=k) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(movingCount(1,1,0));
	}
}
