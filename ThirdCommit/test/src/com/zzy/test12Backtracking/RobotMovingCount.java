package com.zzy.test12Backtracking;

/**
 * �����˵��˶���Χ��
 * 		ÿ��ֻ�����������ƶ�һ�񣬻��ǻ����㷨
 * 		���Թ���һ�����󣬻������߹��ĵ㣬��¼
 * 		���û����㷨�������д��緵��
 * @author user
 *
 */

public class RobotMovingCount {
	public static int movingCount(int m, int n, int k) {
		/**
		 * ����������ʼ�����������ݷ�Ϊ��һ������
		 */
		
		//�����жϼ�������
		if(m<=0||n<=0) {
			return 0;
		}
		if(k==0) {
			return 1;
		}
		//Ϊtrue��˵���Ѿ�������
		boolean[][] bs = new boolean[m][n];
		
		return dfs(0,0,m,n,bs,k);
	}
	
	public static int dfs(int row, int col, int rows, int cols, boolean[][] bs, int k) {
		int count = 0;
		//�жϱ߽�����,������磬�����߹������ǲ����ߣ���ֱ�ӷ���0
		if(row<0||row>=rows||col<0||col>=cols||bs[row][col] == true||!checkGo(row,col,k)) {
			return 0;
		}
		//����һ��˵���õ�����ߣ����丳ֵtrue
		bs[row][col] = true;
		count = dfs(row+1,col,rows,cols,bs,k)+dfs(row-1,col,rows,cols,bs,k)+dfs(row,col+1,rows,cols,bs,k)+dfs(row,col-1,rows,cols,bs,k);
		return ++count;
	}

	//�ж��Ƿ�õ����ߣ������򷵻�true�����ܷ���false
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
