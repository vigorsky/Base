package com.vigorsky.base.dsa.linear;

public class List {

	Node head;

	public void add(Object data, int index) {
		if (head == null) {
			if (index == 0) {
				head = new Node(data, null);
			} else {
				return;
			}
		} else {
			if (index == 0) {
				head = new Node(data, head);
			} else {
				Node pre = find(index - 1);
				if (pre != null) {
					pre.next = new Node(data, pre.next);
				}
			}
		}
	}

	public Object remove(int index) {
		if (head == null) {
			return null;
		} else {
			if (index == 0) {
				Node p = head;
				head = head.next;
				return p.data;
			} else {
				Node pre = find(index - 1);
				if (pre != null && pre.next != null) {
					Node p = pre.next;
					pre.next = p.next;
					return p.data;
				} else {
					return null;
				}
			}
		}
	}

	private Node find(int index) {
		if (head == null) {
			return null;
		} else {
			if (index < 0) {
				return null;
			}
			Node p = head;
			for (int i = 0; i < index; i++) {
				if (p.next != null) {
					p = p.next;
				} else {
					return null;
				}
			}
			return p;
		}
	}

	class Node {
		Object data;
		Node next;

		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
