package com.zzy.test29SpiralOrder;

/**
 * ˳ʱ���ӡ����:
 * 		�Լ�д���ķ�������ȫ���������ύ����Ϊ�÷���ֻ������x*x�ľ��󣬶�x*y�ľ���������
 * @author user
 *
 */

public class MySpiralOrder {
	public int[] spiralOrder(int[][] matrix) {
		if(matrix == null) {
			return null;
		}
		//���շ���ֵ
		int[] results = new int[matrix.length*matrix[0].length];
		int index = 0;
		int startPoint = 0;
		//����
		
		int rows = matrix.length,cols = matrix[0].length;
		int loopNum = (matrix.length/2)+(matrix.length%2);
		//ע����4*4�ľ���Ϊ��
		/**
		 * 		1,	2,	3,	4	A
		 * 		12,	13,	14,	5
		 * 		11,	16,	15,	6
		 * 	C	10,	9,	8,	7
		 * 					B
		 * 
		 * AΪ�����ѭ�����յ����λ�ã������Ҫ�䵽5��λ��
		 * B��Ҫ�䵽8��λ��
		 * C��Ҫ�䵽11��λ��
		 */
		while(loopNum>startPoint) {
			//���
			int row = startPoint,col = startPoint;
			while(col<cols) {
				results[index++] = matrix[row][col++];
			}
			//��һ��ѭ�����յõ�col=4,row=0
			col-=1;
			row+=1;
			while(row<rows) {
				results[index++] = matrix[row++][col];
			}
			//��һ��ѭ�����յõ�col=3,row=4
			row-=1;
			col-=1;
			while(col>=startPoint) {
				results[index++] = matrix[row][col--];
			}
			//��һ��ѭ�����յõ�col=-1,row=3
			col+=1;
			row-=1;
			while(row>startPoint) {
				results[index++] = matrix[row--][col];
			}
			//��ʼ��ǰ�����յ����
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
