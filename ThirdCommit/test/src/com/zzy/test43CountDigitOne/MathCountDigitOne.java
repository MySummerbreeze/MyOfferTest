package com.zzy.test43CountDigitOne;

/**
 * ��ѧ���������
 * 		�ҳ�ÿһλ��1�ĸ����������и�λ��1+ʮλ��1+��λ��1����
 * 		ÿһλ��1�ĸ������䱾���ֵ���Լ���λ���͵�λ��ֵһ�����
 * 		���磺203����0���λ����˵��203�����µ�����ʮλ��Ϊ1 ��һ��Ϊ20������λΪ2����λΪ3
 * 		cur����λ��ֵ��high�����λֵ��low�����λֵ��digΪλ����ʮλΪ10����λΪ100
 * 		��cur = 0ʱ����λ��1�ĸ���Ϊ��high*dig
 * 		��cur = 1ʱ��1�ĸ���Ϊ��high*dig+low+1
 * 		��cur > 1ʱ��1�ĸ���Ϊ��(high+1)*dig
 * @author user
 *
 */

public class MathCountDigitOne {
	public int countDigitOne(int n) {
		int count = 0;
		int dig = 1;
		int high = n;
		int cur = 0;
		while(high>0) {
			cur = high%10;
			high = high/10;
			int low = n%dig;
			if(cur == 0) {
				count += high*dig;
			}else if(cur == 1) {
				count += high*dig+low+1;
			}else {
				count += (high+1)*dig;
			}
			dig*=10;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(new MathCountDigitOne().countDigitOne(824883294));
	}
}
