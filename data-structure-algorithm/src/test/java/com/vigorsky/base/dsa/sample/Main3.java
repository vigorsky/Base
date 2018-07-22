package com.vigorsky.base.dsa.sample;

import com.vigorsky.base.dsa.BubbleSort;

public class Main3 {

	public static void main(String[] args) {
		int[] d = new int[100];
		for (int i = 0; i < 100; i++) {
			d[i] = 100-i;
		}
		show(d);
		BubbleSort s = new BubbleSort();
		s.sort(d);
		show(d);

	}
	
	static void show(int[] d) {
		for(int i=0;i<d.length;i++) {
			System.out.print(d[i]+" ");
		}
		System.out.println();
	}

}
