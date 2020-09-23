package com.zzy.test43CountDigitOne;
/**
 * ��������1~n������1���ֵĴ�����
 * 		ʱ�临�Ӷ�O(nlogn)
 * ��Ȼ������ԣ���������ʱ�临�Ӷȵ�����offer�ļ�����С
 * @author user
 *
 */
public class MyCountDigitOne {
	public int countDigitOne(int n) {
		int count = 0;
		while(n>0) {
			int index = n;
			while(index>0) {
				if(index%10 == 1) {//�����λ��Ϊ1
					count++;
				}
				index/=10;
			}
			n--;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(new MyCountDigitOne().countDigitOne(824883294));
	}
}
