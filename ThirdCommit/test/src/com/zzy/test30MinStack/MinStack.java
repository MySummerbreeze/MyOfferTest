package com.zzy.test30MinStack;

import java.util.Stack;

/**
 * ԭջ���䣬������ջ��ŵ��ڵ�ǰ��֮ǰ����Сֵ
 * 		���磺A:7,5,9,8,4
 * 			B:7,5,5,5,4
 * @author user
 *
 */

public class MinStack {
	 /** initialize your data structure here. */
	
	private Stack<Integer> stackA;//A�������ԭջ
	private Stack<Integer> stackB;//B������Ÿ���ջ
	
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
    	//������ջ�������ȵ�ǰ��������
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

		System.out.println("��ǰ��ջ��"+ms.top());
		System.out.println("��ǰ����Сֵ"+ms.min());
		ms.pop();
		System.out.println("��ǰ��ջ��"+ms.top());
		System.out.println("��ǰ����Сֵ"+ms.min());
		ms.pop();
		System.out.println("��ǰ��ջ��"+ms.top());
		System.out.println("��ǰ����Сֵ"+ms.min());
		ms.pop();
		System.out.println("��ǰ��ջ��"+ms.top());
		System.out.println("��ǰ����Сֵ"+ms.min());
		ms.pop();
		System.out.println("��ǰ��ջ��"+ms.top());
		System.out.println("��ǰ����Сֵ"+ms.min());
	}
}
