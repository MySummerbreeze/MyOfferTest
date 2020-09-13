package com.zzy.test4FindNumberIn2DArray;

/**
 * 二维数组中的查找
 * 		右上角开始：
 * 			若所要查找的数大于右上角数，则向下找，若小于则向左找
 * @author user
 *
 */

public class FindNumber {
	public boolean FindNumberIn2DArray(int[][] matrix, int target) {
		
		if(matrix.length == 0||matrix == null) {
			return false;
		}
		
		//（i,j）
		int i = 0;//行
		int j = matrix[0].length-1;//列
		//需要注意的是，在这里需要让j=0
		while(i<matrix.length&&j>=0) {
			if(target>matrix[i][j]) {
				i++;
				continue;
			}else if(target<matrix[i][j]) {
				j--;
				continue;
			}else {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		FindNumber f = new FindNumber();
		int[][] matrix = {
		                  {-5}
		                };
		boolean b = f.FindNumberIn2DArray(matrix, -5);
		System.out.println(b);
	}
}
