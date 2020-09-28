package com.zzy.test50FirstUniqChar;

import java.util.*;

/**
 * List¼¯ºÏ´æ´¢
 * @author zzy
 *
 */

public class MyFirstUniqChar {
	public char firstUniqChar(String s) {
		if(s == null||s.length() == 0) return ' ';
		Map<Character,Boolean> map = new LinkedHashMap<>();
		for(int i = 0;i<s.length();i++)
			map.put(s.charAt(i), map.get(s.charAt(i)) == null?true:false);
		for(Map.Entry<Character, Boolean> entry : map.entrySet()){
			if(entry.getValue()) return entry.getKey();
		}
		return ' ';
    }
	
	public static void main(String[] args) {
		String s = "kabccdeff";
		System.out.println(new MyFirstUniqChar().firstUniqChar("15616"));
	}
}
