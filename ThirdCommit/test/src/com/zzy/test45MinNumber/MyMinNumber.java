package com.zzy.test45MinNumber;

/**
 * �������ų���С����
 * 	 �������������ֱȷ���mn����nm
 * 	��Ҫע�������ǰ����Ϊ0��Ϊ0�Ļ���Ҫ���⴦��
 * 	
 * αð�����򷨣�
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
		// TODO �Զ����ɵķ������
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
		//�������ַ���ȣ���Ƚ���һ������str�ĵ�ǰ�ַ�����iStr�ĵ�ǰ�ַ�����iStrһ����ǰ��
		//��str�ĵ�ǰ�ַ�С��IStr�ĵ�ǰ�ַ�����str��ǰ��
		//��ĳһ��������ɣ���û����һ���ڵ㣬��鿴��һ���ַ�������һ���ַ��뵱ǰ�ַ��Ƚ�
		if(str.charAt(j) > iStr.charAt(j)) {
			return iStr+str;
		}else if(str.charAt(j) < iStr.charAt(j)) {
			return str+iStr;
		}
	}
	if(j>=str.length()&&j>=iStr.length()) {
		return iStr+str;
	}
	if(j>=str.length()) {//�����str������ͷ����istr��j�ڵ�
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
		if(i == 0) {//����ǰ��0,��Ϊ���⴦��,ֱ������
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