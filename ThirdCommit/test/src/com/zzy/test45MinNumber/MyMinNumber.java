package com.zzy.test45MinNumber;

/**
 * 把数组排成最小数：
 * 	 两两相连有两种比法，mn或是nm
 * 	需要注意的是最前可能为0，为0的话需要特殊处理
 * 	
 * 伪冒泡排序法：
 * 
 * @author user
 *
 */

public class MyMinNumber {
	public String minNumber(int[] nums) {
		if(nums == null || nums.length == 0) {
			return "";
		}
		StringBuilder results = new StringBuilder();
		for(int i = 0;i<nums.length;i++) {
			for(int j = i+1;j<nums.length;j++) {
				sortTwoNum(nums,i,j);
			}
			results.append(nums[i]);
		}
		return results.toString();
    }
	
	
	
	public void sortTwoNum(int[] nums, int i, int j) {
		// TODO 自动生成的方法存根
		String pre = String.valueOf(nums[i])+String.valueOf(nums[j]);
		String cur = String.valueOf(nums[j])+String.valueOf(nums[i]);
		for(int k = 0;k<pre.length();k++) {
			if(pre.charAt(k)>cur.charAt(k)) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				break;
			}else if(pre.charAt(k)<cur.charAt(k)) {
				break;
			}
		}
	}



	public static void main(String[] args) {
		int[] nums = {1,4,74,2545,5,88231,3,6,9};
		System.out.println(new MyMinNumber().minNumber(nums));
	}
}

/*public String getMergeNumber(String str,int i) {
	String iStr = String.valueOf(i);
	int j = 0;
	for(;j<str.length()&&j<iStr.length();j++) {
		//若两个字符相等，则比较下一个，若str的当前字符大于iStr的当前字符，则将iStr一方放前边
		//若str的当前字符小于IStr的当前字符，则将str放前边
		//若某一方遍历完成，即没有下一个节点，则查看另一个字符串的下一个字符与当前字符比较
		if(str.charAt(j) > iStr.charAt(j)) {
			return iStr+str;
		}else if(str.charAt(j) < iStr.charAt(j)) {
			return str+iStr;
		}
	}
	if(j>=str.length()&&j>=iStr.length()) {
		return iStr+str;
	}
	if(j>=str.length()) {//如果是str遍历到头，则看istr的j节点
		if(iStr.charAt(j)<=iStr.charAt(j-1)) return iStr+str;
		else return str+iStr;
	}
	if(j>=iStr.length()) {
		if(str.charAt(j)<=str.charAt(j-1)) return str+iStr;
		else return iStr+str;
	}
	return "";
}*/









/*public String getMinNumber(int[] nums) {
	String result = null;
	int firstZeroNum = 0;
	for (int i : nums) {
		if(i == 0) {//若是前导0,记为特殊处理,直接跳过
			firstZeroNum ++;
			continue;
		}
		if(result == null) {
			result = String.valueOf(i);
		}else {
			result = getMergeNumber(result, i);
		}
	}
	if(firstZeroNum>0) {
		StringBuilder sb = new StringBuilder();
		while(firstZeroNum>0) {
			sb.append("0");
			firstZeroNum--;
		}
		return new String(sb+result);
	}
	return result;
}
public String getMergeNumber(String str,int i) {
	String iStr = str+i;
	str = i+str;
	for(int j = 0;j<str.length();j++) {
		if(str.charAt(j)>iStr.charAt(j)) {
			return iStr;
		}else if(str.charAt(j)<iStr.charAt(j)) {
			return str;
		}
	}
	return str;
}*/