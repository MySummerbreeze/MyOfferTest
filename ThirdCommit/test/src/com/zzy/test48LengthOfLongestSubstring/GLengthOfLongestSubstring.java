package com.zzy.test48LengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * 优化滑动窗口：
 * 		滑动窗口并随时更新最大值，当遇到相等的元素时左指针右移
 * @author zzy
 *
 */

public class GLengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if(s == null||s.length() == 0){
			return 0;
		}
        if(s.length() == 1){
			return 1;
		}
        int left = 0;
        int right = 0;
        int MaxNum = 0;
        Set<Character> set = new HashSet<>();
		while(left<s.length()&&right<s.length()){
			while(set.contains(s.charAt(right))){
				set.remove(s.charAt(left++));
			}
			set.add(s.charAt(right));
			MaxNum = Math.max(MaxNum, set.size());
			right++;
		}
		return MaxNum;
    }
	
	public static void main(String[] args) {
		String str = "aab";
		System.out.println(new GLengthOfLongestSubstring().lengthOfLongestSubstring(str));
	}
}
