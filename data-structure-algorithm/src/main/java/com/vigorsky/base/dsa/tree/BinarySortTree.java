package com.vigorsky.base.dsa.tree;

public class BinarySortTree {
	Node root;

	public void insert(int key, Object data) {
		Node n = new Node(key, data);
		if (root == null) {
			root = n;
		} else {
			root.insert(n);
		}
	}

	public void delete(int key) {
		if (root != null) {
			root = root.delete(key);
		}
	}

	public Object search(int key) {
		if (root == null) {
			return null;
		} else {
			Node n = root.search(key);
			return n == null ? null : n.getData();
		}
	}

	class Node {
		int key;
		Object data;
		Node left;
		Node right;

		public Node(int key, Object data) {
			this.key = key;
			this.data = data;
		}
		
		public Object getData() {
			return data;
		}

		public Node search(int key) {
			if (key < this.key) {
				if (left != null) {
					return left.search(key);
				} else {
					return null;
				}
			} else if (key > this.key) {
				if (right != null) {
					return right.search(key);
				} else {
					return null;
				}
			} else {
				return this;
			}
		}

		public void insert(Node n) {
			if (n.key < key) {
				if (left == null) {
					left = n;
				} else {
					left.insert(n);
				}
			} else if (n.key > key) {
				if (right == null) {
					right = n;
				} else {
					right.insert(n);
				}
			} else {
				data = n.data;
			}
		}

		public Node delete(int key) {
			if (key == this.key) {
				if (left == null && right == null) {
					return null;
				} else if (left == null) {
					return right;
				} else if (right == null) {
					return left;
				} else {
					Node successor = removeMinFromRight();
					successor.left = left;
					successor.right = right;
					return successor;
				}
			} else if (key < this.key) {
				if (left != null) {
					left = left.delete(key);
				}
			} else {
				if (right != null) {
					right = right.delete(key);
				}
			}
			return this;
		}

		private Node removeMinFromRight() {
			if (right == null) {
				return null;
			}
			Node p = right;
			if (p.left == null) {
				right = p.right;
				return p;
			} else {
				Node pre = p;
				p = p.left;
				while (p.left != null) {
					pre = p;
					p = p.left;
				}
				pre.left = null;
				return p;
			}
		}

	}

}
