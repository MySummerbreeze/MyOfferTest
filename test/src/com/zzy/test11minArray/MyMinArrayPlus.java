package com.zzy.test11minArray;

/**
 * 旋转数组的最小数字：
 * 		因为题意已经告诉我们，该数组在一定程度上是有序的，因此我们可以使用二分查找
 * 		使用三个指针，一个指向最左端，一个最右端，一个中间，
 * 		当最左端的数大于中间的数时（4,5,1,2,3）,将最右端的指针移向中间指针
 * 		当最左端的数小于中间的数时(3,4,5,1,2),将最左端的指针指向中间指针
 * 		依次循环，当有两个指针相遇时（中间指针与左指针重合），说明最小数在这三个指针中产生。
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
		//首先排除特殊情况，数组为空
		if(numbers == null||numbers.length == 0) {
			return -1;
		}
		//两个指针，一个low，一个high
		int low = 0;
		int high = numbers.length-1;
		//循环条件是low<high,若不满足条件说明没有找到合适的，因此直接返回第一个元素（有序数组的性质）
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
