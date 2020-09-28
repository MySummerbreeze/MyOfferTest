package com.zzy.test48LengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * ʹ�û������ڵķ���������ָ�룬һ��ָ��ǰ���̶���������һ��ָ�������ƶ���������̶�����ָ����ȵ��ַ����������ַ����У�
 * ��һ����������Ż�˫ָ��
 * 
 * @author zzy
 *
 */

public class MyLengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if(s == null||s.length() == 0){
			return 0;
		}
		if(s.length() == 1){
			return 1;
		}
		String MaxStr = new String();//��Ҫ�洢���ַ���
		int left = 0;
		int right = 0;
		while(left<s.length()){//��ʣ�µ��ַ����ĳ���Ҫ���ڵ�ǰ��ַ����ĳ��ȣ�˵�����л����ܹ�����
			right = left+1;
			Set<Character> set = new HashSet<>();
			set.add(s.charAt(left));
			while(right<s.length()){
				if(set.contains(s.charAt(right))){
					break;
				}else set.add(s.charAt(right));
				right++;
			}
			if(right-left>MaxStr.length()){//�ж�����������ĳ��ȴ��ڵ�ǰ����ַ����ĳ��ȣ�����д洢
				MaxStr = s.substring(left,right);
			}
			left++;
		}
		System.out.println(MaxStr);
		return MaxStr.length();
    }
	
	public static void main(String[] args) {
		String str = "aab";
		System.out.println(new MyLengthOfLongestSubstring().lengthOfLongestSubstring(str));
	}
}
