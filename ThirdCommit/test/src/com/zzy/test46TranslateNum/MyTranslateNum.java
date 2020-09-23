package com.zzy.test46TranslateNum;

/**
 * �����ַ�����ַ�����
 * 		ʹ�ö�̬�滮Ϊ���Ž⣺
 * 		ͨ�������֪���������㹫ʽ��f(n) =f(n-2)+f(n-1)��쳲��������У� 
 * 				����>1						=f(n-1)�����������a~z�����
 * 		1		����>1
 * 		1,2		����>2
 * 		1,2,2	����>3
 * 		1,2,2,5	����>5
 * 		1,2,2,8	����>3
 * @author user
 *
 */

public class MyTranslateNum {
	public int translateNum(int num) {
		//��numתΪ�ַ���
		String str = String.valueOf(num);
		if(str.length()<2) {
			return str.length();
		}
		
		//�½������dp
		int pre = 1;//��ʼ��ǰ����ֵ
		int cur = 1;
		int result = 0;
		//forѭ�����dp�������
		for(int i = 1;i<str.length();i++) {//i��dp���±�,j��str���±�
			if((str.charAt(i)-'0')+(str.charAt(i-1)-'0')*10 >= 10&&(str.charAt(i)-'0')+(str.charAt(i-1)-'0')*10 < 26) {//���˵��ǰֵ����һ��ֵ������ս����10-26֮�䣬��dp[i] = dp[i-1]+dp[i-2];
				result = pre+cur;
			}else {
				result = cur;
			}
			pre = cur;
			cur = result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new MyTranslateNum().translateNum(12258));
	}
	
}
