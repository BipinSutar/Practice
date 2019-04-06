package com.bipin.practice.algo;

class Node {

	int key;
	Node left, right;

	public Node(int key) {
		this.key = key;
		left = right = null;
	}

	@Override
	public String toString() {
		return "Leafkey = " + key + " left => " + key + left + " right =>" + key + right;
	}
}

public class BinarySearchTree {

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	private BinarySearchTree() {
		setRoot(root);
	}

	public void insert(int key) {
		this.root = insertRec(this.root, key);
	}

	private Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.key) {
			root.left = insertRec(root.left, key);
		} else if (key > root.key) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	void printPostorder() {
		postorderRec(root);
	}

	void printInorder() {
		inorderRec(root);
	}

	String printPreorder() {
		return preorderRec(root);
	}

	private void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " , ");
			inorderRec(root.right);

		}
	}

	private String preorderRec(Node root) {
		String s = "";
		if (root != null) {

			s += root.key + " , ";
			s += preorderRec(root.left);
			s += preorderRec(root.right);
		}
		return s;
	}

	private void postorderRec(Node root) {
		if (root != null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.key + " , ");
		}
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println("Inorder");
		tree.printInorder();
		System.out.println("\nPreorder");
		System.out.println(tree.printPreorder().substring(-1));
		System.out.println("\nPostorder");
		tree.printPostorder();
		// System.out.println(tree.getRoot().toString());
		// while (tree.getRoot() != null) {
		// System.out.println(tree.getRoot().key);
		// if (tree.getRoot().left != null) {
		// tree.setRoot(tree.getRoot().left);
		// }
		// if (tree.getRoot().right != null) {
		// tree.setRoot(tree.getRoot().right);
		// }
		// }
	}

}
