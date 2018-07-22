package com.vigorsky.base.dsa.tree;

public class BalancedBinaryTree {
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
		int bf;
		Object data;
		Node parent;
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
					n.parent = this;
					insertBalance(1);
				} else {
					left.insert(n);
				}
			} else if (n.key > key) {
				if (right == null) {
					right = n;
					n.parent = this;
					insertBalance(-1);
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
					if (parent.left == this) {
						parent.left = null;
						return parent.deleteBalance(-1);
					} else {
						parent.right = null;
						return parent.deleteBalance(1);
					}
				} else if (left == null) {
					if (parent.left == this) {
						parent.left = right;
						right.parent = parent;
						return parent.deleteBalance(-1);
					} else {
						parent.right = right;
						right.parent = parent;
						return parent.deleteBalance(1);
					}
				} else if (right == null) {
					if (parent.left == this) {
						parent.left = left;
						left.parent = parent;
						return parent.deleteBalance(-1);
					} else {
						parent.right = left;
						left.parent = parent;
						return parent.deleteBalance(1);
					}
				} else {
					Node successor = removeMinFromRight();
					successor.left = left;
					successor.right = right;
					successor.bf = bf;
					successor.left.parent = successor;
					successor.right.parent = successor;
					int bfPre = successor.bf;
					successor.bf++;//
					if (isShorterAbs(successor.bf, bfPre)) {
						if (parent.left == successor) {
							return parent.deleteBalance(-1);
						} else {
							return parent.deleteBalance(1);
						}
					}
				}
			} else if (key < this.key) {
				if (left != null) {
					return left.delete(key);
				}
			} else {
				if (right != null) {
					return right.delete(key);
				}
			}
			return this;
		}

		private void rightRotate() {
			Node newTop = left;
			left = newTop.right;
			newTop.right = this;
			if (parent != null) {
				if (this == parent.left) {
					parent.left = newTop;
				} else {
					parent.right = newTop;
				}
				newTop.parent = parent;
				parent = newTop;
			}
		}

		private void leftRotate() {
			Node newTop = right;
			right = newTop.left;
			newTop.left = this;
			if (parent != null) {
				if (this == parent.left) {
					parent.left = newTop;
				} else {
					parent.right = newTop;
				}
				newTop.parent = parent;
				parent = newTop;
			}
		}

		private void insertBalance(int bfIncrement) {
			int bfPre = bf;
			int bfCur = (bf += bfIncrement);
			if (isGreaterAbs(bfCur, bfPre)) {
				Node p = this;
				while (p.parent != null) {
					bfPre = p.parent.bf;
					if (p == p.parent.left) {
						bfCur = ++p.parent.bf;
					} else {
						bfCur = --p.parent.bf;
					}
					p = p.parent;

					if (isGreaterAbs(bfCur, bfPre)) {
						if (isGreaterAbs(p.bf, 1)) {
							if (this == p.left.left) {
								p.rightRotate();
							} else if (this == p.right.right) {
								p.leftRotate();
							} else if (this == p.left.right) {
								p.left.leftRotate();
								p.rightRotate();
							} else {
								p.right.rightRotate();
								p.leftRotate();
							}
							return;
						}
					} else {
						return;
					}
				}
			}
		}

		private Node deleteBalance(int bfIncrement) {
			int bfPre = bf;
			int bfCur = (bf += bfIncrement);
			if (isShorterAbs(bfCur, bfPre)) {
				if (bfCur > 1) {
					rightRotate();
					bfPre = bf;
					bfCur = --bf;
					if (parent != null && isShorterAbs(bfCur, bfPre)) {
						return parent.deleteBalance(-1);
					}
				} else if (bfCur < -1) {
					leftRotate();
					bfPre = bf;
					bfCur = ++bf;
					if (parent != null && isShorterAbs(bfCur, bfPre)) {
						return parent.deleteBalance(1);
					}
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
				if (right != null) {
					right.parent = this;
					parent.deleteBalance(1);//
				}
				return p;
			} else {
				Node pre = p;
				p = p.left;
				while (p.left != null) {
					pre = p;
					p = p.left;
				}
				pre.left = null;
				pre.deleteBalance(-1);//
				return p;
			}
		}

		private boolean isGreaterAbs(int bfCur, int bfPre) {
			return Math.abs(bfCur) > Math.abs(bfPre);
		}

		private boolean isShorterAbs(int bfCur, int bfPre) {
			return Math.abs(bfCur) < Math.abs(bfPre);
		}

	}
}
