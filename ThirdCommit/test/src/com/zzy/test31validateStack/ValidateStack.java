package com.zzy.test31validateStack;

import java.util.Stack;

public class ValidateStack {
	
	//pushedԭջ��popped����ջ
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		if(pushed.length == 0||popped.length == 0||popped.length != pushed.length) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int indexPush = 0;
		int indexPop = 0;
		while(indexPush<pushed.length) {
			//���ջ�ڲ�Ϊ�գ�����ջ��Ԫ�ص�����һ����ջԪ�أ���ֱ�ӵ�ջ������ָ������
			if(!stack.isEmpty()&&popped[indexPop] == stack.peek()) {
				stack.pop();
				indexPop++;
			}else if(popped[indexPop] == pushed[indexPush]) {//����һ����ջԪ���뼴����ջԪ����ȣ���ֱ������
				indexPush++;
				indexPop++;
			}else {
				stack.push(pushed[indexPush]);
				indexPush++;
			}
		}
		if(stack.isEmpty()) {//��ջΪ����˵�����ϸ�ѭ���Լ�������ɣ�˵��ȫ��ƥ�䣬����true
			return true;
		}else {//���򣬿�ʼ����ƥ��
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
