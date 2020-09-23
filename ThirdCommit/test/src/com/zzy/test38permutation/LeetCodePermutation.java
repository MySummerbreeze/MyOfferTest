package com.zzy.test38permutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode上的一个博主写的，拿来理解
 * @author user
 *
 */


/*
 * abcd举例：
 * abcd
 * abdc
 * acbd
 * acdb
 * adcb
 * adbc
 * bacd
 * badc
 * bcad
 * bcda
 * bdca
 * bdac
 * cbad
 * cbda
 * cdba
 * cdab
 * cadb
 * cabd……
 */
public class LeetCodePermutation {
	List<String> res = new LinkedList<>();
	char[] c;

	public String[] permutation(String s) {
		c = s.toCharArray();
		dfs(0);
		return res.toArray(new String[res.size()]);
	}
	
	void dfs(int x) {
		if (x == c.length - 1) {
			res.add(String.valueOf(c)); // 添加排列方案
			return;
		}
		HashSet<Character> set = new HashSet<>();
		for (int i = x; i < c.length; i++) {//x一直没变，i一直在往后遍历
			if (set.contains(c[i]))
				continue; // 重复，因此剪枝
			set.add(c[i]);
			swap(i, x); // 交换，将 c[i] 固定在第 x 位
			dfs(x + 1); // 开启固定第 x + 1 位字符
			swap(i, x); // 恢复交换
		}
	}

	void swap(int a, int b) {
		char tmp = c[a];
		c[a] = c[b];
		c[b] = tmp;
	}
}
