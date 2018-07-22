package com.vigorsky.base.dsa.sample;

import com.vigorsky.base.dsa.tree.BinarySortTree;

public class Main2 {

	public static void main(String[] args) {
		BinarySortTree t = new BinarySortTree();

		for (int i = 0; i < 100; i += 2) {
			t.insert(i, i);
		}

		for (int i = 1; i < 100; i += 2) {
			t.insert(i, i);
		}

		System.out.println(t.search(51));
		System.out.println(t.search(52));
		System.out.println(t.search(73));
	}

}
