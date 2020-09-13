package com.zzy.test16Power;

/**
 * ��ֵ�������η���
 * 		��������ּ��������ģ�±�дMath.pow(double base,int exponent)������
 * 		���ǿ��Ժ����׵��뵽ʹ��n��ѭ����
 * 		�����⿼��Ĳ����ڴˣ����Ǽ������뷨�����ܷ��뵽���߽���������ȥʵ��
 * 		��exponentΪ0ʱ��Ϊ����ʱ����baseΪ0ʱ��Ϊ����ʱ���㿼�ǵ���û�У�
 * 		���ǿ���֪������ָ��Ϊ0���κ�����Ϊ1����0��0�η�û�����壬���������Ƿ���1����0�Կ�
 * 		�������ǿ����뵽����ָ��Ϊ����ʱ�����ǿ����Ƚ��������ֵ��������ǿ��Խ���ѭ������������
 * 		��������Ҳ����baseΪ0ʱ������󵼣���Ȼ�ᱨ�����������Ҫ��֤���Թ�һ���������ķ���
 * �����ǽ�ָOffer�ṩ�Ļ����ⷨ����û�п��ǵ�Ч�����⣬��������Ϊ�����ṩ��һ����ΪЧ�ʵĽ������
 * 		��ָ��Ϊ32ʱ�����Կ���ʱbase^8^2��base^4^2^2����
 * 		��������ôһ����ʽ��a^n = a^(n/2)*a^(n/2)				nΪż��
 * 							a^((n-1)/2)*a^((n-1)/2)*a	nΪ����
 * 		ʹ�õݹ�
 * ָ��Ϊ����������Լ��Ľ��������һ��Boolean������Ϊ��ǣ������result����
 * 			����LeetCode�п���һ�����������ֱ�ӽ�base������ʹ�õ�����������
 * 
 * �����ʱ���������⣺
 * 		��һ���ύ�������ڵݹ麯����ʹ���ˣ�return pow(base,exponent/2)*pow(base,exponent/2);������ѭ��û����ʱ�临�Ӷ���ѭ��һ����O(n)
 * 		�ڶ����ύ���󣬲�������Ϊ��2.00000 -2147483648:
 * 			�������ǿ���-2147483648����֪����int�ı߽���������������Ҫ֪����Integer.MAX_VALUE = 2147483647;
 * 			int�����ֵ�治��2147483648�����������������ܸ�ֵ��
 * 			���Ҹ��ݲ����˽⵽Integer.MAX_VALUE+1 = Integer.MIN_VALUE��Integer.MAX_VALUE+2 = Integer.MIN_VALUE+1����
 * 			����int i = 2147483647+1;
 * 			�ٶ�һ�£�
 * 			Integer.max_value = 01111111 111111111111111111111111 01111111
 * 			111111111111111111111111+1= 10000000 00000000 00000000 00000000
 * 			���λ�Ƿ���λΪ1���Ǹ�����������Դ���ǲ���ȡ��+1���պõ���Integer.min_value
 * @author user
 *
 */

public class MyPower {
	//�����ⷨ��ֱ�ӳ�ʱ������ȡ
	public static double basePow(double base,int exponent) {
		if(exponent == 0) {
			return 1;
		}
		boolean eIsNegative = false;
		if(exponent < 0) {
			eIsNegative = true;
			exponent = -exponent;
		}
		double result = 1.0000;
		while(exponent != 0) {
			result *= base;
			exponent--;
		}
		if(eIsNegative) {//���Ǹ��ţ�����Ҫ����
			if(result == 0) {
				return 0;
			}
			result = 1.0/result;
		}
		return result;
	}
	
	public static double myPow(double base, int exponent) {
		if(exponent == 0) {
			return 1;
		}
		//ʹ��long���ʹ洢����Ϊ��MAX_VALUEȡ����ʱint���Ͳ��ܴ洢
		long e = exponent;
		boolean eIsNegative = false;
		if(exponent < 0) {
			eIsNegative = true;
			e = -e;
		}
		double result = pow(base,e);
		if(eIsNegative) {//���Ǹ��ţ�����Ҫ����
			if(result == 0) {
				return 0;
			}
			result = 1.0/result;
		}
		return result;
	}
	
	
	//ֻ��Ҫ����η����⣬����Ҫ����߽�����
	public static double pow(double base,long exponent) {
		double result = 1;
		if(exponent == 1) {
			return base;
		}else if(exponent%2 == 1) {
			result = pow(base,(exponent-1)/2);
			return result*result*base;
		}else if(exponent%2 == 0) {
			result = pow(base,exponent/2);
			return result*result;
		}
		return -1;
	}
	
	public static void main(String[] args) {
//		System.out.println(myPow(2.00000,-2147483648));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		int i = Integer.MAX_VALUE+1;
		System.out.println(i);
		
	}
}
