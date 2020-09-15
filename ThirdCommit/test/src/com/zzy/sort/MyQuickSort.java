package com.zzy.sort;

/**
 * ���������˼���ǣ�
 * 		�ҳ�һ����׼ֵ����С�ڻ�׼ֵ���������ڻ�׼ֵ����ߣ����ڻ�׼ֵ���������ڻ�׼ֵ���ұ�
 * 		��һ���׼ֵѡȡ������Ҷ˺��м�λ������������λ����Ϊ��׼��
 * 		ʵ����һ˼��ʹ�õ���˫ָ�뷨������׼ֵĬ����0��λ�ã�
 * 			����ָ�룬һ��ָ��0��һ��ָ��length-1,��׼ֵ����length-1�Ƚϣ���С�ڻ�׼ֵ�����丳ֵ��0
 * @author user
 *	��������ƽ��ʱ�临�Ӷ�O��nlogn����������O��nlogn����������O��n^2��,�ռ临�Ӷ�O(logn),���ȶ�
 *		
 *		������������д����
 *		         ��partition���֣�һ����������ʵ���ҵ�һ����׼����������м����򣨽�С�ڻ�׼�ķ�������ߣ����ڵķ������ұߣ�
 *		��׼ȷ�Ľ��û�׼����Ӧ�ڵ�λ�ã�����ֵ�Ǹû�׼���±�
 *		         һ��quickSort��������Ϊ�����ú�������ʵ�ֵݹ�
 */

public class MyQuickSort {
	
	public static void quickSort(int[] array,int start,int end) {
		//������ֻʣһ������ֱ�ӷ���
		if(start>=end) {
			return;
		}
		int low = start;
		int high = end;
		//���һ��ֵ��Ϊ��׼
		int tmp = array[high];
		while(low<high) {
			while(tmp<array[low]&&low<high) {
				low++;
			}
			while(tmp>array[high]&&low<high) {
				high--;
			}
			if(low<high) {
				int t = array[low];
				array[low] = array[high];
				array[high] = t;
			}else {
				//��������ֵ
				array[end] = array[low];
				array[low] = tmp;
			}
		}
		//�ݹ�����������
        quickSort(array, start, low-1);
        //�ݹ�����Ұ�����
        quickSort(array, low+1, end);
	}
	
	public static void main(String[] args) {
		int[] array = {2,1,6,4,5,9};
		quickSort(array,0,array.length-1);
		for (int i : array) {
			System.out.print(i+" ");
		}
	}
	
}
