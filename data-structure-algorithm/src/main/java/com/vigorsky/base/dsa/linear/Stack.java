package com.vigorsky.base.dsa.linear;

public class Stack {
	int maxDeep = 100;
	int top = 0;
	Object[] array = new Object[maxDeep];

	public void push(Object data) {
		if (top >= maxDeep) {
			return;
		}
		array[top] = data;
		top++;
	}

	public Object pop() {
		if (top <= 0) {
			return null;
		}
		top--;
		Object data = array[top];
		array[top] = null;// GC
		return data;
	}
}
