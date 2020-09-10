package com.zzy.sort;

/**
 * ��������
 * 		��Ҫ˼�룺
 * 			һ������׼��һ����������С��ͬ�Ŀ����飬��ÿһ�����뵽��Ӧ��λ�ã����ǲ�������
 * 				���׼ȷ�Ĳ��뵽��Ӧλ�ã����������ǰһ����С�ں�һ����
 * 			Ҳ����ֻ��һ���������Ͻ����ﵽ���������Ŀ�ġ�
 * 				��ͷ��ʼ���ȸ���һ��Ԫ�������ٸ�ǰ����Ԫ�����򣬽�����ǰ�������������ơ�ÿ��������һ��ֵ����ǰ����ȷ�ĵط���
 * @author user
 *
 */

public class MyInsertionSort {
	public static void insertionSort(int[] array) {
		for(int i = 1;i<array.length;i++) {
			for(int j = i;j>0;j--) {
				if(array[j]<array[j-1]) {
					int tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
				}else {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,-1};
		insertionSort(array);
		for (int i : array) {
			System.out.print(i+" ");
		}
	}
	
	
	
}
