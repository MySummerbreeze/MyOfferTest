package com.zzy.test29SpiralOrder;

/**
 * 顺时针打印矩阵:
 * 		自己写出的方法，完全不适用于提交，因为该方法只适用于x*x的矩阵，而x*y的矩阵则不适用
 * @author user
 *
 */

public class MySpiralOrder {
	public int[] spiralOrder(int[][] matrix) {
		if(matrix == null) {
			return null;
		}
		//最终返回值
		int[] results = new int[matrix.length*matrix[0].length];
		int index = 0;
		int startPoint = 0;
		//行列
		
		int rows = matrix.length,cols = matrix[0].length;
		int loopNum = (matrix.length/2)+(matrix.length%2);
		//注释以4*4的矩阵为例
		/**
		 * 		1,	2,	3,	4	A
		 * 		12,	13,	14,	5
		 * 		11,	16,	15,	6
		 * 	C	10,	9,	8,	7
		 * 					B
		 * 
		 * A为最外层循环最终到达的位置，因此想要变到5的位置
		 * B想要变到8的位置
		 * C想要变到11的位置
		 */
		while(loopNum>startPoint) {
			//起点
			int row = startPoint,col = startPoint;
			while(col<cols) {
				results[index++] = matrix[row][col++];
			}
			//第一次循环最终得到col=4,row=0
			col-=1;
			row+=1;
			while(row<rows) {
				results[index++] = matrix[row++][col];
			}
			//第一次循环最终得到col=3,row=4
			row-=1;
			col-=1;
			while(col>=startPoint) {
				results[index++] = matrix[row][col--];
			}
			//第一次循环最终得到col=-1,row=3
			col+=1;
			row-=1;
			while(row>startPoint) {
				results[index++] = matrix[row--][col];
			}
			//起始点前进，终点后退
			startPoint++;
			cols--;
			rows--;
		}
		return results;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2},{12,13}};
		int[] results = new MySpiralOrder().spiralOrder(matrix);
		for (int i : results) {
			System.out.print(i+" ");
		}
	}
}
