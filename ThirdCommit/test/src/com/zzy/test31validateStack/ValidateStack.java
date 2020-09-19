package com.zzy.test31validateStack;

import java.util.Stack;

public class ValidateStack {
	
	//pushed原栈，popped弹出栈
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		if(pushed.length == 0||popped.length == 0||popped.length != pushed.length) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int indexPush = 0;
		int indexPop = 0;
		while(indexPush<pushed.length) {
			//如果栈内不为空，并且栈顶元素等于下一个弹栈元素，则直接弹栈，并且指针下移
			if(!stack.isEmpty()&&popped[indexPop] == stack.peek()) {
				stack.pop();
				indexPop++;
			}else if(popped[indexPop] == pushed[indexPush]) {//若下一个入栈元素与即将弹栈元素相等，则直接跳过
				indexPush++;
				indexPop++;
			}else {
				stack.push(pushed[indexPush]);
				indexPush++;
			}
		}
		if(stack.isEmpty()) {//当栈为空则说明在上个循环以及弹出完成，说明全部匹配，返回true
			return true;
		}else {//否则，开始慢慢匹配
			while(!stack.isEmpty()&&indexPop<popped.length) {
				if(stack.pop() == popped[indexPop]) {
					indexPop++;
				}else {
					return false;
				}
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		int[] pushed = {1,2,3,4,5}, popped = {2,3,4,5,1};
		System.out.println(validateStackSequences(pushed,popped));
	}
}
