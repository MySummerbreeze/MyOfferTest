package com.zzy.test14CuttingRope;

/**
 * ������ʹ��̰���㷨��
 * 		̰���㷨���ͣ�
 * 			���磬ƽʱ��������Ǯʱ��Ϊʹ�һص���Ǯ��Ӳ�������٣�
 *  		��Ҫ������Ǯ�����з��������Ǵ������ֵ�ı��ֿ�ʼ��
 *  		���ݼ���˳���Ǹ����Ⱦ����ô���ֵ����
 *  		���������ֵʱ��ȥ������һ����С��ֵ�������̰���㷨
 *  	̰���㷨�ڱ�����ʹ�ã�
 *  		f(4) = 2*2
 *  		f(5) = 2*3
 *  		f(6) = 3*3
 *  		f(7) = 2*2*3
 *  		f(8) = 2*3*3
 *  		f(9) = 3*3*3
 *  		f(10) = 2*2*3*3
 *  		�ɴ˿��Կ�����ʵ���еĽⷨ����2��3�й�ϵ��������ǿ�������ȥ��һ��n���м���3
 *  		���磺9�Ļ�����3�������Ǿ���3��3�η�
 *  			10�Ļ�����3��������һ��1��������1ʱ������֪����������Ҫ����һ��4��2*2
 *  			8�Ļ�����2��������һ��2
 *  		�����������Ϲ��ɣ����ǾͿ��Ա�д�����´���
 * @author user
 *
 */

public class MyCuttingRopeUserGreedy {
	public static int cuttingRope(int n) {
		//���ǽ�С�ڵ����������ܹ�����������ֱ�ӷ��ص�ֵ���أ�0,1,2,3
		//0��1���ص���ͬһ��ֵ0
		if(n<2) {
			return 0;
		}
		if(n == 2) {
			return 1;
		}
		if(n == 3) {
			return 2;
		}
		
		//ʹ��һ���������洢n���м���3
		int count = n/3;
		long mod = 1000000007;
		//�жϵ�nȥ������3֮��ʣ�µ���
		//��ʣ����1����˵����10������ͬ�����ó�һ������1��ϱ��4
		long result = 1;
		if(n%3 == 1) {
			for(int i = 0;i<count-1;i++) {
				result *= 3;
				result %= mod;
			}
			result *= 4;
		}
		if(n%3 == 2) {
			for(int i = 0;i<count;i++) {
				result *= 3;
				result %= mod;
			}
			result *= 2;
		}
		if(n%3 == 0) {
			for(int i = 0;i<count;i++) {
				result *= 3;
				result %= mod;
			}
		}
		return (int) (result%mod);
	}
	
	public static void main(String[] args) {
		System.out.println(1%1000000007);
		System.out.println(cuttingRope(1000));
	}
}
