package com.zzy.test20NumberStr;

/**
 * 表示数值的字符串：
 * 		剑指Offer介绍中有两种字符串是数字：
 * 			其中（A为数值的整数部分，B紧跟着小数点为数值的小数部分，C紧跟着e或者E为数值的指数部分）
 * 			A[.[B]][e|EC]或者.B[e|EC]
 * 
 * 		其中AC可以带+-号，而B表示小数部分，不能够有+-号，只有整数部分
 * 		
 * @author user
 *
 */

public class IsNumberStr {
	int index = 0;
	public boolean isNumber(String s) {
		if(s == null) return false; 
		//先将s转为char[]
		char[] cs = new char[s.length()+1];
		cs = s.toCharArray();
		cs[s.length()-1] = '\0';
		boolean result = scanInteger(cs);
		//java与C++不同的地方，c++数组最后的数为'\0'，但java没有
		
		//if(cs.length == 1||index == cs.length||index+1 == cs.length) return result&&index == cs.length;
		
		//小数部分
		if(cs[index] == '.') {
			//剑指offer对||进行了解释：
			/* 其中可以有种方式
			 * 第一种(.123)
			 * 第二种(123.)
			 * 第三种(123.123)
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
	//该函数用来扫描数字0~9,只要有数字就返回true
	public boolean scanUnsignedInteger(char[] cs) {
		//48为0,57为9,一个小总结，在写数组时，要将边界判断放在判断前
		//例如在这里就将index<cs.length放在前边
		int count = index;
		while(cs[index]>=48&&cs[index]<=57) {
			index++;
		}
		return index-count>0;//若其中含有若干数字则返回true
	}
	//该函数用来判断+-号
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
