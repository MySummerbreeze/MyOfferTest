package com.zzy.test5ReplaceSpace;

/**
 * �ٷ��ⷨ
 * 		�ȼ������еĿո�������ǰ�������µ��ַ����飬�Ӻ���ǰ�����滻
 * @author user
 *
 */

public class ReplaceSpaceTest1 {
	public String replaceSpace(String s) {
		if(s.length() == 0||s == null) {
			return "";
		}
		int spaceNum = 0;		
		for(char c : s.toCharArray()) {
			if(c == ' ') {
				spaceNum++;
			}
		}
		int yindex = s.length()-1;//��Ϊԭ�ַ������±�-1ss
		int index = spaceNum*2+s.length()-1;//��ΪҪ��Ϊ�µ��±�������Ҫ-1
		char[] cs = new char[index+1];//�½�һ��char����
		while(index>=0&&yindex>=0) {
			if(s.charAt(yindex) == ' ') {//�ҵ���ԭ�ַ�������������s
				cs[index] = '0';//��������cs
				index--;
				cs[index] = '2';
				index--;
				cs[index] = '%';
				index--;
				yindex--;
			}else {
				cs[index] = s.charAt(yindex);
				index--;
				yindex--;
			}
		}
		String str = new String(cs);//���ַ�����תΪString����
		return str;
    }
	public static void main(String[] args) {
		ReplaceSpaceTest1 r = new ReplaceSpaceTest1();
		System.out.println(r.replaceSpace(" ��ɳ��ɳ��1  "));;
	}
}
