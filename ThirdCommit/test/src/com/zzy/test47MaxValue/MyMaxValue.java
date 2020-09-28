package com.zzy.test47MaxValue;

/**
 * 动态规划
 * @author zzy
 *
 */

public class MyMaxValue {
	
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		int[][] nums = {{0}};
		System.out.println(new MyMaxValue().maxValue(grid));;
	}

	public int maxValue(int[][] grid) {
		//判断边界条件
		if(grid == null||grid.length == 0) {
			return 0;
		}
		for(int i = 0;i<grid.length;i++) {
			for(int j = 0;j<grid[0].length;j++) {
				//第一个
				if(i == 0&&j == 0) grid[i][j] = grid[i][j];
				else if(i == 0) grid[i][j] = grid[i][j-1]+grid[i][j];//行为0
 				else if(j == 0) grid[i][j] = grid[i-1][j]+grid[i][j];
 				else {
 					if(grid[i][j-1]>grid[i-1][j]) {
 						grid[i][j] = grid[i][j-1]+grid[i][j];
 					}else {
 						grid[i][j] = grid[i-1][j]+grid[i][j];
 					}
 				}
			}
		}
		return grid[grid.length-1][grid[0].length-1];
	}
}


/*static int sum;
public int maxValue(int[][] grid) {
	if(grid == null||grid.length == 0) {
		return 0;
	}
	sum = 0;
	dfs(grid,0,0,0);
	return sum;
}

public void dfs(int[][] grid, int i, int j,int nowSum) {
	// TODO 自动生成的方法存根
	if(i>=grid.length||j>=grid[0].length) {//如果越界则计算当前的value触底返回
		if(sum<nowSum) {
			sum = nowSum;
		}
		return;
	}
	nowSum += grid[i][j];
	dfs(grid,i+1,j,nowSum);
	dfs(grid,i,j+1,nowSum);
}*/
