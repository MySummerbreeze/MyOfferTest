package com.zzy.test20NumberStr;

/**
 * ��ʾ��ֵ���ַ�����
 * 		��ָOffer�������������ַ��������֣�
 * 			���У�AΪ��ֵ���������֣�B������С����Ϊ��ֵ��С�����֣�C������e����EΪ��ֵ��ָ�����֣�
 * 			A[.[B]][e|EC]����.B[e|EC]
 * 
 * 		����AC���Դ�+-�ţ���B��ʾС�����֣����ܹ���+-�ţ�ֻ����������
 * 		
 * @author user
 *
 */

public class IsNumberStr {
	int index = 0;
	public boolean isNumber(String s) {
		if(s == null) return false; 
		//�Ƚ�sתΪchar[]
		char[] cs = new char[s.length()+1];
		cs = s.toCharArray();
		cs[s.length()-1] = '\0';
		boolean result = scanInteger(cs);
		//java��C++��ͬ�ĵط���c++����������Ϊ'\0'����javaû��
		
		//if(cs.length == 1||index == cs.length||index+1 == cs.length) return result&&index == cs.length;
		
		//С������
		if(cs[index] == '.') {
			//��ָoffer��||�����˽��ͣ�
			/* ���п������ַ�ʽ
			 * ��һ��(.123)
			 * �ڶ���(123.)
			 * ������(123.123)
			 */
			index++;
			result = scanUnsignedInteger(cs) || result;
		}
		if(cs[index] == 'e'||cs[index] == 'E') {
			index++;
			result = scanInteger(cs)&&result;
		}
        return result&&index == '\0';
    }
	//�ú�������ɨ������0~9,ֻҪ�����־ͷ���true
	public boolean scanUnsignedInteger(char[] cs) {
		//48Ϊ0,57Ϊ9,һ��С�ܽᣬ��д����ʱ��Ҫ���߽��жϷ����ж�ǰ
		//����������ͽ�index<cs.length����ǰ��
		int count = index;
		while(cs[index]>=48&&cs[index]<=57) {
			index++;
		}
		return index-count>0;//�����к������������򷵻�true
	}
	//�ú��������ж�+-��
	public boolean scanInteger(char[] cs) {
		if(cs[index] == '+'||cs[index] == '-') 
			index++;
		return scanUnsignedInteger(cs);
	}
	
	public static void main(String[] args) {
		IsNumberStr i = new IsNumberStr();
		System.out.println(i.isNumber("-123.1e-1"));
	}
}
