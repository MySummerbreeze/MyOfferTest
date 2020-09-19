package com.zzy.test29SpiralOrder;

/**
 * 重新寻找方法：
 * 		根据之前的思路，一个x*y的矩阵，可以根据之前矩阵中的数组来解决，当触碰到边界条件时就转向
 * @author user
 *
 */

public class SpiralOrder {
	public int[] spiralOrder(int[][] matrix) {
		if(matrix.length == 0) {
			return new int[0];
		}
		int m = matrix.length;
        int n = matrix[0].length;
		int rowBegain = 0,colBegain = 0,rowEnd = matrix.length-1,colEnd = matrix[0].length-1;
		int[] results = new int[m*n];
		int index = 0;
		while(true) {
			for(int i = colBegain;rowBegain<=rowEnd&&i<=colEnd;i++) {
				results[index++] = matrix[rowBegain][i];
			}
			rowBegain++;
			for(int i = rowBegain;colBegain<=colEnd&&i<=rowEnd;i++) {
				results[index++] = matrix[i][colEnd];
			}
			colEnd--;
			for(int i = colEnd;rowBegain<=rowEnd&&i>=colBegain;i--) {
				results[index++] = matrix[rowEnd][i];
			}
			rowEnd--;
			for(int i = rowEnd;colBegain<=colEnd&&i>=rowBegain;i--) {
				results[index++] = matrix[i][colBegain];
			}
			colBegain++;
			if(index == m * n){
                break;
            }
		}
		return results;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,7},{9,10,11}};
		int[] results = new SpiralOrder().spiralOrder(matrix);
		for (int i : results) {
			System.out.print(i+" ");
		}
	}
}





//之前的demo
/*
if(matrix.length == 0) {
	return null;
}
int rowBegain = 0,colBegain = 0,rowEnd = matrix.length,colEnd = matrix[0].length;
int[] results = new int[rowEnd*colEnd];
int index = 0;
while(true) {
	for(int i = colBegain;i<colEnd;i++) {
		results[index++] = matrix[rowBegain][i];
	}
	colEnd--;
	if(rowBegain == rowEnd||colBegain == colEnd) {
		break;
	}
	for(int i = rowBegain+1;i<rowEnd;i++) {
		results[index++] = matrix[i][colEnd];
	}
	rowEnd--;
	if(rowBegain == rowEnd||colBegain == colEnd) {
		break;
	}
	for(int i = colEnd-1;i>=colBegain;i--) {
		results[index++] = matrix[rowEnd][i];
	}
	if(rowBegain == rowEnd||colBegain == colEnd) {
		break;
	}
	for(int i = rowEnd-1;i>rowBegain;i--) {
		results[index++] = matrix[i][colBegain];
	}
	if(rowBegain == rowEnd||colBegain == colEnd) {
		break;
	}
	colBegain++;
	rowBegain++;
}
return results;*/