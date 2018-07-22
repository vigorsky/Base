package com.vigorsky.base.dsa.linear;

public class Queue {
	int maxCount = 100;
	int start = 0;
	int end = 0;
	boolean empty = true;
	boolean full = false;
	Object[] array = new Object[maxCount];

	public void push(Object data) {
		if (full) {
			return;
		} else {
			array[end] = data;
			if (++end >= maxCount) {
				end = 0;
			}
			if (end == start) {
				full = true;
			}
			empty = false;
		}
	}

	public Object pop() {
		if (empty) {
			return null;
		} else {
			Object data = array[start];
			if (++start >= maxCount) {
				start = 0;
			}
			if (start == end) {
				empty = true;
			}
			full = false;
			return data;
		}
	}

	public int length() {
		if (end > start) {
			return end - start;
		} else if (end < start) {
			return maxCount - (start - end);
		} else {
			if (empty) {
				return 0;
			} else {
				return maxCount;
			}
		}
	}

}
