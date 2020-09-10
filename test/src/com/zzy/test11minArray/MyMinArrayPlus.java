package com.zzy.test11minArray;

/**
 * ��ת�������С���֣�
 * 		��Ϊ�����Ѿ��������ǣ���������һ���̶���������ģ�������ǿ���ʹ�ö��ֲ���
 * 		ʹ������ָ�룬һ��ָ������ˣ�һ�����Ҷˣ�һ���м䣬
 * 		������˵��������м����ʱ��4,5,1,2,3��,�����Ҷ˵�ָ�������м�ָ��
 * 		������˵���С���м����ʱ(3,4,5,1,2),������˵�ָ��ָ���м�ָ��
 * 		����ѭ������������ָ������ʱ���м�ָ������ָ���غϣ���˵����С����������ָ���в�����
 * 		
 * @author user
 *
 */

public class MyMinArrayPlus {
	
	public static int minArray(int[] numbers) {
		int left = 0;
		int right = numbers.length-1;
		while(left<right){
			int mid = left+(right-left)/2;
			if(numbers[right]<numbers[mid]){
				left = mid+1;
			}else if(numbers[right]>numbers[mid]){
				right = mid;				
			}else {
				right--;
			}
		}
		return numbers[left];
    }
	
	public static int minnumbers(int[] numbers) {
		//�����ų��������������Ϊ��
		if(numbers == null||numbers.length == 0) {
			return -1;
		}
		//����ָ�룬һ��low��һ��high
		int low = 0;
		int high = numbers.length-1;
		//ѭ��������low<high,������������˵��û���ҵ����ʵģ����ֱ�ӷ��ص�һ��Ԫ�أ�������������ʣ�
		int mid = low;
		while(numbers[low]>=numbers[high]) {
			if(high-low==1) {//high-low==1
				mid = high;
				break;
			}
			mid = (low+high)/2;
			if(numbers[low]<=numbers[mid]) {
				low = mid;
			}else if(numbers[mid]<=numbers[high]) {
				high = mid;
			}
		}
		return numbers[mid];
	}
	public static void main(String[] args) {
		int[] numbers = {1};
		System.out.println(minnumbers(numbers));
	}
}
