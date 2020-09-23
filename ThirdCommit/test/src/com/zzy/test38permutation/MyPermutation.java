package com.zzy.test38permutation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 字符串的排列：
 * 		使用set集合可以免去查重，使用动态规划，不断插入
 * 		想象很美好，可是实现不了，能力水平有限
 * @author user
 *
 */

public class MyPermutation {
	Set<char[]> set = new HashSet<>();
	char[] cs ;
	public String[] permutation(String s) {
		cs = new char[s.length()];
		addToSet(s);
		String[] ss = transSetToStringArray();
		return ss;
	}
	private String[] transSetToStringArray() {
		return null;
	}
	private void addToSet(String s) {
		if(s.length() == 0) {
			return;
		}else addToSet(s.substring(s.length()-1));
		if(s.length() == 1) {
			cs = s.toCharArray();
			return;
		}
		Iterator<char[]> iter = set.iterator();
		while(iter.hasNext()) {
			char[] index = iter.next();
			/*for() {
				
			}*/
		}
	}
	
	
}
