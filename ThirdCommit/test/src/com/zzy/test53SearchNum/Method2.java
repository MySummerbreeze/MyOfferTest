package com.zzy.test53SearchNum;

import java.util.Arrays;

/**
 * ���ַ���
 * 		��������м��ж��Ƿ���ڻ�С�ڻ���ڣ����ݹ�
 * @author ��־��
 *
 */

public class Method2 {
	public int search(int[] nums, int target) {
        if(nums == null||nums.length == 0){
        	return 0;
        }
		int mid = nums.length/2;
        if(nums[mid] == target){//�����࿪ʼ��
        	int count = 1;
        	int index = mid+1;
        	while(index<nums.length){
        		if(nums[index]!=target){
        			break;
        		}
        		count++;
        		index++;
        	}
        	index = mid -1;
        	while(index>=0){
        		if(nums[index]!=target){
        			break;
        		}
        		count++;
        		index--;
        	}
        	return count;
        }else if(nums[mid] > target){//˵���������
        	return search(Arrays.copyOfRange(nums, 0, mid),target);
        }else{
        	return search(Arrays.copyOfRange(nums, mid+1, nums.length),target);
        }
    }
	
	
	public static void main(String[] args) {
		int[] is = {8,8,8,8,8,8,8};
		System.out.println(new Method2().search(is,8));
	}
}
