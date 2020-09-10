package com.zzy.test5ReplaceSpace;

/**
 * 官方解法
 * 		先计算其中的空格数，提前创建好新的字符数组，从后往前慢慢替换
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
		int yindex = s.length()-1;//作为原字符串的下标-1ss
		int index = spaceNum*2+s.length()-1;//因为要作为新的下标所以需要-1
		char[] cs = new char[index+1];//新建一个char数组
		while(index>=0&&yindex>=0) {
			if(s.charAt(yindex) == ' ') {//找的是原字符串，操作的是s
				cs[index] = '0';//操作的是cs
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
		String str = new String(cs);//将字符数组转为String类型
		return str;
    }
	public static void main(String[] args) {
		ReplaceSpaceTest1 r = new ReplaceSpaceTest1();
		System.out.println(r.replaceSpace(" 大沙发沙发1  "));;
	}
}
