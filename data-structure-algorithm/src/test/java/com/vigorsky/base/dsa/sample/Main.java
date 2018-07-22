package com.vigorsky.base.dsa.sample;

import com.vigorsky.base.dsa.linear.List;
import com.vigorsky.base.dsa.linear.Queue;

public class Main {
	public static void main(String[] args) {
		List l = new List();
		l.add(0, 0);
		l.add(1, 1);
		l.add(2, 2);
		l.add(3, 1);
		l.add(5, 0);
		System.out.println(l.remove(0));
		
		Queue q=new Queue();
		
		for(int i=0;i<102;i++) {
			q.push(i);
		}
		System.out.println(q.length());
		for(int i=0;i<30;i++) {
			q.pop();
		}
		System.out.println(q.length());
		for(int i=900;i<1002;i++) {
			q.push(i);
		}
		System.out.println(q.length());
		for(int i=0;i<80;i++) {
			System.out.println(q.pop());
		}
	}
}
