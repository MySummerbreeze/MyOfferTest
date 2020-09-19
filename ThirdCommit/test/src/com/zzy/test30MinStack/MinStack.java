package com.zzy.test30MinStack;

import java.util.Stack;

/**
 * 原栈不变，而辅助栈存放当在当前数之前的最小值
 * 		例如：A:7,5,9,8,4
 * 			B:7,5,5,5,4
 * @author user
 *
 */

public class MinStack {
	 /** initialize your data structure here. */
	
	private Stack<Integer> stackA;//A用来存放原栈
	private Stack<Integer> stackB;//B用来存放辅助栈
	
    public MinStack() {
    	stackA = new Stack<>();
    	stackB = new Stack<>();
    }
    
    public void push(int x) {
    	if(stackA.isEmpty()) {
    		stackA.push(x);
    		stackB.push(x);
    		return;
    	}
    	//若辅助栈顶的数比当前插入数大
    	if(x>stackB.peek()) {
    		stackB.push(stackB.peek());
    	}else stackB.push(x);
    	stackA.push(x);
    }
    
    public void pop() {
    	stackA.pop();
    	stackB.pop();
    }
    
    public int top() {
    	if(stackA.isEmpty()) {
    		return 0;
    	}
    	return stackA.peek();
    }
    
    public int min() {
    	return stackB.peek();
    }
    
    
    public static void main(String[] args) {
		MinStack ms = new MinStack();

		System.out.println("当前的栈顶"+ms.top());
		System.out.println("当前的最小值"+ms.min());
		ms.pop();
		System.out.println("当前的栈顶"+ms.top());
		System.out.println("当前的最小值"+ms.min());
		ms.pop();
		System.out.println("当前的栈顶"+ms.top());
		System.out.println("当前的最小值"+ms.min());
		ms.pop();
		System.out.println("当前的栈顶"+ms.top());
		System.out.println("当前的最小值"+ms.min());
		ms.pop();
		System.out.println("当前的栈顶"+ms.top());
		System.out.println("当前的最小值"+ms.min());
	}
}
