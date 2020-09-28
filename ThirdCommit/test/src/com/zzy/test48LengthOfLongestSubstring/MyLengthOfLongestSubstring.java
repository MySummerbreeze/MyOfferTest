package com.zzy.test48LengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * 使用滑动窗口的方法，两个指针，一个指向前（固定不动），一个指向后（向后移动，遇到与固定不动指针相等的字符则存入最大字符串中）
 * 下一个类中详见优化双指针
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
		String MaxStr = new String();//所要存储的字符串
		int left = 0;
		int right = 0;
		while(left<s.length()){//所剩下的字符串的长度要大于当前最长字符串的长度，说明还有机会能够更长
			right = left+1;
			Set<Character> set = new HashSet<>();
			set.add(s.charAt(left));
			while(right<s.length()){
				if(set.contains(s.charAt(right))){
					break;
				}else set.add(s.charAt(right));
				right++;
			}
			if(right-left>MaxStr.length()){//判断如果所碰到的长度大于当前最大字符串的长度，则进行存储
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
