package com.zzy.test17PrintMax;

import java.util.Stack;

/**
 * ��ӡ��1������nλ����
 * 		��LeetCode��Ҫ�󷵻����飬�������ţ�����д��������demo
 * 		�������Ŀ��Ȼ�������飬�˽⵽����Ĵ�СӦ����10^n-1,���ǿ��Զ���һ������Ϊ10^n������
 * 		
 * ��ȻLeetCode��С������Ѷȣ�ֻ��һ�������ţ�����ռ�ü�����ܴ�Ŀռ䣬��ʹ�ռ临�Ӷȱ��ʮ�ִ�
 * ���������Ҫ���ݽ�ָOffer�е�˼·��������ӡ�����������޷Ŵ�
 * 		����n��ܴ�,��long long���Ͷ��洢���ˣ���������ֻ��ʹ���ַ��������ַ�����
 * 		��LeetCode��ʹ�����飬��Ϊ������û������޶ȵģ���������̶�ȡ���ڼ����
 * 		��ָOffer�������ṩ��һ��������
 * 			ʹ���ַ���ģ�����ֵļ�1����
 * 		
 * 
 * 2020/9/12��¼����������
 * @author user
 *
 */

public class MyPrintNumbers {
	public static int[] printNumbers(int n) {
		int[] results = new int[(int) Math.pow(10, n)-1];
		for(int i = 0;i<results.length;i++) {
			results[i] = i+1;
		}
		return results;
	}
	
	public static void printNumbersModelPlus(int n) {
		//9����
		char[] cs = {'0','1','2','3','4','5','6','7','8','9'};
		long printNums = (long)Math.pow(10, n)-1;
		//��ǰλ��
		int length = 1;
		char[] result = new char[n];
		while(printNums>0) {
			//��10����ÿ10length+1
			int i = 0;
			for(;i<10&&printNums>0;i++) {
				result[n] = cs[i];
				printNums--;
			}
			length++;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("is "+ 100 + 5);
		System.out.println(100 + 5 +"is ");
		System.out.println("is "+ (100 + 5));
	}
}

class Base{
    public Base(String s){
        System.out.print("B");
    }

}
