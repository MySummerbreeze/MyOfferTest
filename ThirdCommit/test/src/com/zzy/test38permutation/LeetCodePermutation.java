package com.zzy.test38permutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode�ϵ�һ������д�ģ��������
 * @author user
 *
 */


/*
 * abcd������
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
 * cabd����
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
			res.add(String.valueOf(c)); // ������з���
			return;
		}
		HashSet<Character> set = new HashSet<>();
		for (int i = x; i < c.length; i++) {//xһֱû�䣬iһֱ���������
			if (set.contains(c[i]))
				continue; // �ظ�����˼�֦
			set.add(c[i]);
			swap(i, x); // �������� c[i] �̶��ڵ� x λ
			dfs(x + 1); // �����̶��� x + 1 λ�ַ�
			swap(i, x); // �ָ�����
		}
	}

	void swap(int a, int b) {
		char tmp = c[a];
		c[a] = c[b];
		c[b] = tmp;
	}
}
