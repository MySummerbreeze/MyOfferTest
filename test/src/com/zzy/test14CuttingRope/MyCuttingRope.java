package com.zzy.test14CuttingRope;

/**
 * �����ӣ�
 * 		��ʵ�����ǿ���֪����������С�ڵ���3ʱ�����ǵļ���ʱ�̶��ģ�û��̫��ı仯
 * 		���ǰ����ֱ�ӿ���ʹ���ж���д
 * 		��ֱ�ӵĽⷨ���Ƕ�̬�滮�������Ϊn��С���⣬ÿһ��С������������Ǹ����⣩
 * @author user
 *
 */

public class MyCuttingRope {
	public static int cuttingRope(int n) {
        //�����жϱ߽�����
		if(n < 2) {
			return 0;
		}
		if(n == 2) {
			return 1;
		}
		if(n == 3) {
			return 2;
		}
		
		//��Σ�һ�����������п��ܵ�ֵ��n��4��n�����ֵ��,n+1��ԭ���Ǵ�0��ʼ��
		int[] products = new int[n+1];
		//�����ĸ�����ʾ����һ����ȥ���ܵõ������ֵ
		//���磺��1��ʱ���κ���ֻ�ܳ���1
		//������ʱ���κ������Զ�
		//��4��ʱ����Ϊ��n=4��ʱ������ֵ��4�����ԣ�����������Գ���4
		//��5��ʱ��n=5ʱ���ֵ��6������ֱ�ӳ���6���������ٷ�Ϊ2*3������ʡȥ�˲���
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		//��һ��ѭ����������n,��4��ʼ
		for(int i = 4;i<=n;i++) {
			//�ڶ���ѭ������ÿһ�������ֵ
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
