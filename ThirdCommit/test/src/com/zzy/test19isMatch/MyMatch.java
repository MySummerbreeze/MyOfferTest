package com.zzy.test19isMatch;

/**
 * �Լ����뷨��	
 * 		ʹ������ָ�룬ͬʱ��ʼƥ�䣬ʹ��ѭ������ƥ�䣬
 * 		���շ���ѭ���Ĵ���̫�������࣬���ҷ��ӣ������жϵ���˼·���ң�
 * 		������LeetCode�ϱ��ҵ���һ������
 * @author user
 *	����һ��demo�п��Կ�������ʹ�õ���dfs�ݹ�ķ�ʽ��ģ��֮ǰ�����е�����һ��
 *		������
 *			������һ�������������õݹ麯����
 *				�ú����������ַ�����Ϊ���ַ����飬ʹ�����ʱ��Ϊ����
 *				��ε�������ƥ�亯��
 *			����ƥ�亯���У�����(��һ���ַ����飬��һ���ַ����鵱ǰָ����±꣬�ڶ����ַ����飬�ڶ����ַ����鵱ǰָ����±�)
 *				ÿһ�ε��õݹ�ʱ��Ҫ�ж��Ƿ�ƥ����ɻ���δƥ����ɣ�
 *					ƥ����ɣ���������ָ����±궼ͬʱԽ�磬index==length
 *					δƥ����ɣ�һ��Խ�����һ��û��Խ��
 *					ƥ�����˵������ȷ��ƥ�䣬����true��δƥ�����˵��������ȷ��ƥ�䣬����false
 *				�жϵ�ǰ�ַ��Ƿ�ƥ�䣬���Ҹ�ֵ��һ��boolean���ͣ�
 *					ϸ�򣺵��ڱ��ʽ�ַ��Ƿ���.���������ַ����ĵ�ǰ�ַ���ͬ
 *				���˵���ʽ����һ���ַ���*������Ҫ�鿴���ʽ�ĵ�ǰ�ַ����ַ�������һ���ַ��Ƿ���ȣ�
 *				������*�ŵ���һ���ַ��뵱ǰ���ַ��� ���ַ��Ƿ����
 *				�������*����ôֻ�����ǵ�ǰ���ʽ�ַ�Ϊ.���������ַ�����ȣ�����Ļ�����false��
 *
 */

public class MyMatch {
	
	public boolean isMatch(String text, String pattern) {
	    char[] t = text.toCharArray();
	    char[] p = pattern.toCharArray();
	    return isMatchHelper(t, 0, p, 0);
	}

	private boolean isMatchHelper(char[] t, int index, char[] p, int pIndex) {
	    //ƥ�����
	    if (index == t.length && pIndex == p.length) {
	        return true;
	    }
	    //δƥ����ȫ
	    if (index <= t.length && pIndex == p.length) {
	        return false;
	    }
	    //��ǰ�ַ�ƥ���ж�
	    boolean matchSuc = p[pIndex] == t[index] || p[pIndex] == '.';
	    if (p.length - pIndex >= 2 && p[pIndex + 1] == '*') {
	        //ƥ��0�λ���
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
	//����������ȣ�������ж��Ƿ���*.������������ѭ��
	if(s.charAt(sIndex) != p.charAt(pIndex)) {
		//���ж��Ƿ������һ��Ԫ�أ�Ȼ���ж���һ�������ǲ���*
		if(p.charAt(pIndex) == '*') {
			//�����*�ţ���ѭ��s�ҵ�һ����*��һ������ȵ��ַ���������*ǰһ���������
			while(sIndex<s.length()&&pIndex+1<p.length()) {
				//����s�ҵ�����*��һ����ƥ�䣬��p���ָ��*����һ��Ԫ��pֱ������ѭ��
				//Ҫôƥ��ɹ���Ҫôƥ��ʧ��ֱ�ӷ���false
				if(s.charAt(sIndex) == p.charAt(pIndex+2)) {
					pIndex+=2;
					break;
				}else if(s.charAt(sIndex) == p.charAt(pIndex)) {
					sIndex++;
					continue; 
				}else return false;
			}
		}else if(p.charAt(pIndex) == '.') {//����.����Դ���
			continue;
		}else {
			return false;
		}
	}
}*/


/*
public static boolean isMatch(String s, String p) {
	//����ָ��
	int sIndex = 0;
	int pIndex = 0;
	//����Խ������
	boolean isOutIndex = (pIndex<p.length()&&sIndex>=s.length())||(pIndex>=p.length()&&sIndex<s.length());
	//����������,������ͬʱԽ�����
	boolean isReturn = pIndex>=p.length()&&sIndex>=s.length();
    while(!isOutIndex&&!isReturn) {//��һ��Խ�����һ��û��Խ����˵�������
    	//�������������˵����Ҫô����Ĳ���ȣ�Ҫô��*��Ҫô��.
    	if(s.charAt(sIndex) != p.charAt(pIndex)) {
    		//�����*������Ҫ֪��*����һ�����Ƿ���s�ĵ�ǰ��һ����������*����һ������.
    		if(p.charAt(pIndex) == '*') {
    			//����ѭ����ֱ���ҵ�s��ֵ��.��ƥ�������*ǰ���ַ�����ȣ�������*��һ�����
    			while(pIndex>0&&pIndex<p.length()&&sIndex>0&&sIndex<s.length()) {
					//��ƥ�䣬�����ѭ��
					if(p.charAt(pIndex-1) == '.'||p.charAt(pIndex-1) == s.charAt(sIndex)) {//����һ����.������һ���뵱ǰƥ���������һ��ѭ��
    					sIndex++;
    					continue;
    				}else if(p.charAt(pIndex+1) == s.charAt(sIndex)) {//������*����һ����
    					sIndex++;
    					break;
    				}else return false;//�������.Ҳ������һ���ַ���Ҳ������һ���ַ�����ֻ�в�ƥ��
    			}
    		}else if(p.charAt(pIndex) == '.') {//����.�������һ��ѭ����ɶ�����ܣ���Ϊ�����ַ������ȵ�����һ��
    			
    		}else return false;//������Ĳ����
    	}
    	//ʣ�µľ�������ˣ���Ⱦͼ�������
    	sIndex++;
		pIndex++;
		//�����ж��Ƿ�ѭ��������
		isOutIndex = (pIndex<p.length()&&sIndex>=s.length())||(pIndex>=p.length()&&sIndex<s.length());
		isReturn = pIndex>=p.length()&&sIndex>=s.length();
    }
    //������ΪԽ�������ѭ���򷵻�false
    if(isOutIndex) return false;
    else return true;
}*/
