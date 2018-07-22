package com.vigorsky.base.dsa.sample;

import com.vigorsky.base.dsa.QuickSort;

public class Main4 {

	public static void main(String[] args) {
		int max = 30;
		int[] d = new int[max];
		for (int i = 0; i < max; i++) {
			d[i] = (int) (Math.random() * 100);
		}
		show(d);
		QuickSort s1 = new QuickSort();
//		BubbleSort s2 = new BubbleSort();
		s1.sort(d);
		show(d);
	}

	static void show(int[] d) {
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
		System.out.println();
	}
}
