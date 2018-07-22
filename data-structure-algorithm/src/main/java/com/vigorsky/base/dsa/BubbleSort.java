package com.vigorsky.base.dsa;

public class BubbleSort {

	public void sort(int[] data) {
		int n = data.length - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (data[j] > data[j + 1]) {
					int t = data[j];
					data[j] = data[j + 1];
					data[j + 1] = t;
				}
			}
		}
	}

}
