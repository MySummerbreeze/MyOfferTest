package com.zzy.test4FindNumberIn2DArray;

/**
 * ��ά�����еĲ���
 * 		���Ͻǿ�ʼ��
 * 			����Ҫ���ҵ����������Ͻ������������ң���С����������
 * @author user
 *
 */

public class FindNumber {
	public boolean FindNumberIn2DArray(int[][] matrix, int target) {
		
		if(matrix.length == 0||matrix == null) {
			return false;
		}
		
		//��i,j��
		int i = 0;//��
		int j = matrix[0].length-1;//��
		//��Ҫע����ǣ���������Ҫ��j=0
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
