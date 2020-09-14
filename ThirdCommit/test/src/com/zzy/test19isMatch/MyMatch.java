package com.zzy.test19isMatch;

/**
 * 自己的想法：	
 * 		使用两个指针，同时开始匹配，使用循环进行匹配，
 * 		最终发现循环的代码太过于冗余，并且繁杂，各种判断导致思路混乱，
 * 		于是在LeetCode上边找到了一个代码
 * @author user
 *	在这一套demo中可以看到作者使用的是dfs递归的方式，模仿之前矩阵中的数组一样
 *		解析：
 *			首先是一个函数用来调用递归函数：
 *				该函数将两个字符串变为了字符数组，使其迭代时更为方便
 *				其次调用正则匹配函数
 *			正则匹配函数中：参数(第一个字符数组，第一个字符数组当前指向的下标，第二个字符数组，第二个字符数组当前指向的下标)
 *				每一次调用递归时就要判断是否匹配完成或是未匹配完成：
 *					匹配完成：两个数组指向的下标都同时越界，index==length
 *					未匹配完成：一个越界而另一个没有越界
 *					匹配完成说明是正确的匹配，返回true，未匹配完成说明不是正确的匹配，返回false
 *				判断当前字符是否匹配，并且赋值给一个boolean类型：
 *					细则：当期表达式字符是否是.，或者与字符串的当前字符相同
 *				如果说表达式的下一个字符是*，则需要查看表达式的当前字符和字符串的下一个字符是否相等，
 *				或者是*号的下一个字符与当前的字符串 的字符是否相等
 *				如果不是*，那么只可能是当前表达式字符为.或者是与字符串相等，否则的话就是false了
 *
 */

public class MyMatch {
	
	public boolean isMatch(String text, String pattern) {
	    char[] t = text.toCharArray();
	    char[] p = pattern.toCharArray();
	    return isMatchHelper(t, 0, p, 0);
	}

	private boolean isMatchHelper(char[] t, int index, char[] p, int pIndex) {
	    //匹配完成
	    if (index == t.length && pIndex == p.length) {
	        return true;
	    }
	    //未匹配完全
	    if (index <= t.length && pIndex == p.length) {
	        return false;
	    }
	    //当前字符匹配判断
	    boolean matchSuc = p[pIndex] == t[index] || p[pIndex] == '.';
	    if (p.length - pIndex >= 2 && p[pIndex + 1] == '*') {
	        //匹配0次或多次
	        return isMatchHelper(t, index, p, pIndex + 2) || (matchSuc && isMatchHelper(t, index + 1, p, pIndex));
	    }
	    return matchSuc && isMatchHelper(t, index + 1, p, pIndex + 1);
	}
	
	public static void main(String[] args) {
		String s = "aab";
		String p = "a*b";
		System.out.println();
	}
}

/*for(;sIndex<s.length()||pIndex<p.length();sIndex++,pIndex++) {
	if(pIndex>=p.length()) {
		return false;
	}
	if(sIndex>=s.length()) {
		return true;
	}
	//若两数不想等，则进入判断是否含有*.，若相等则继续循环
	if(s.charAt(sIndex) != p.charAt(pIndex)) {
		//先判断是否是最后一个元素，然后判断下一个符号是不是*
		if(p.charAt(pIndex) == '*') {
			//如果是*号，则循环s找到一个与*下一个数相等的字符，或是与*前一个数不想等
			while(sIndex<s.length()&&pIndex+1<p.length()) {
				//若是s找到了与*下一个数匹配，则p光标指向*的下一个元素p直接跳出循环
				//要么匹配成功，要么匹配失败直接返回false
				if(s.charAt(sIndex) == p.charAt(pIndex+2)) {
					pIndex+=2;
					break;
				}else if(s.charAt(sIndex) == p.charAt(pIndex)) {
					sIndex++;
					continue; 
				}else return false;
			}
		}else if(p.charAt(pIndex) == '.') {//若是.则可以代替
			continue;
		}else {
			return false;
		}
	}
}*/


/*
public static boolean isMatch(String s, String p) {
	//两个指针
	int sIndex = 0;
	int pIndex = 0;
	//数组越界条件
	boolean isOutIndex = (pIndex<p.length()&&sIndex>=s.length())||(pIndex>=p.length()&&sIndex<s.length());
	//返回真条件,是这俩同时越界才行
	boolean isReturn = pIndex>=p.length()&&sIndex>=s.length();
    while(!isOutIndex&&!isReturn) {//当一个越界而另一个没有越界则说明不相等
    	//若两个不相等则说明：要么是真的不想等，要么是*，要么是.
    	if(s.charAt(sIndex) != p.charAt(pIndex)) {
    		//如果是*，则需要知道*的上一个数是否与s的当前数一样，或者是*的上一个数是.
    		if(p.charAt(pIndex) == '*') {
    			//进入循环，直到找到s的值与.不匹配或是与*前的字符不相等，或是与*下一个相等
    			while(pIndex>0&&pIndex<p.length()&&sIndex>0&&sIndex<s.length()) {
					//若匹配，则继续循环
					if(p.charAt(pIndex-1) == '.'||p.charAt(pIndex-1) == s.charAt(sIndex)) {//若上一个是.或者上一个与当前匹配则进行下一轮循环
    					sIndex++;
    					continue;
    				}else if(p.charAt(pIndex+1) == s.charAt(sIndex)) {//若等于*的下一个数
    					sIndex++;
    					break;
    				}else return false;//如果不是.也不是上一个字符，也不是下一个字符，则只有不匹配
    			}
    		}else if(p.charAt(pIndex) == '.') {//若是.则进入下一轮循环，啥都不管，因为和两字符真的想等的条件一样
    			
    		}else return false;//这是真的不相等
    	}
    	//剩下的就是相等了，相等就继续迭代
    	sIndex++;
		pIndex++;
		//这是判断是否循环的条件
		isOutIndex = (pIndex<p.length()&&sIndex>=s.length())||(pIndex>=p.length()&&sIndex<s.length());
		isReturn = pIndex>=p.length()&&sIndex>=s.length();
    }
    //若是因为越界而跳出循环则返回false
    if(isOutIndex) return false;
    else return true;
}*/
