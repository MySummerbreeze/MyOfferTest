package com.zzy.test9Queue;

import java.util.Stack;

public class CQueue {

	Stack<Integer> stack1 = null;
	Stack<Integer> stack2 = null;
	
    public CQueue() {
    	//初始化两个栈
    	stack1 = new Stack();
    	stack2 = new Stack();
    }
    
    public void appendTail(int value) {
    	stack1.push(value);
    }
    
    public int deleteHead() {
    	if(stack2.isEmpty()) {
    		if(stack1.isEmpty()) {
    			return -1;
    		}else {
    			while(!stack1.isEmpty()) {
    				stack2.push(stack1.pop());
    			}
    		}
    	}
    	return stack2.pop();
    }
    
    
    public static void main(String[] args) {
    	CQueue c = new CQueue();
    	System.out.println(c.deleteHead());
    	c.appendTail(5);
    	c.appendTail(2);
    	System.out.println(c.deleteHead());
    	System.out.println(c.deleteHead());
	}
}
