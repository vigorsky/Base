package com.vigorsky.base.dsa;

public class QuickSort {

	public void sort(int[] data) {
		recursionSort(data, 0, data.length - 1);
	}

	private void recursionSort(int[] data, int start, int end) {
		if (start >= end) {
			return;
		} else if (start + 1 == end) {
			if (data[start] > data[end]) {
				swap(data, start, end);
			}
			return;
		}

		int i = start;
		int j = end;
		int base = data[start];
		while (i < j) {
			while (data[j] >= base && i < j) {
				j--;
			}
			if (i < j) {
				swap(data, i, j);
			} else {
				break;
			}

			while (data[i] <= base && i < j) {
				i++;
			}
			if (i < j) {
				swap(data, i, j);
			} else {
				break;
			}
		}
		recursionSort(data, start, i - 1);
		recursionSort(data, i + 1, end);
	}

	private void swap(int[] data, int a, int b) {
		int t = data[a];
		data[a] = data[b];
		data[b] = t;
	}
}
