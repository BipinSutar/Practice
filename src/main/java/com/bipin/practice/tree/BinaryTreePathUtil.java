package com.bipin.practice.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BinaryTreePathUtil {
	static int maxPath = 0;

	static class BinaryTree {
		int val;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int val) {
			this.val = val;
			this.left = null;
			this.right = null;

		}

		@Override
		public String toString() {
			return printBinaryTreeLevelOrderIterative(this);
		}

	}

	public static String printBinaryTreeLevelOrderIterative(BinaryTree root) {
		StringBuilder sb = new StringBuilder();
		Queue<BinaryTree> queue = new LinkedList<>();
		if (root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();
			sb.append(node.val);
			if (node.left != null) {
				sb.append(" -> L: ").append(node.left.val);
				queue.add(node.left);
			} else {
				sb.append(" -> L: ").append(" null ");
			}
			if (node.right != null) {
				sb.append(" ; R: ").append(node.right.val);
				queue.add(node.right);
			} else {
				sb.append(" ; R: ").append(" null ");
			}
			sb.append("\n");

		}
		return sb.toString();
	}

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
//		arr = new int[] { 1, 2, 3, 4, 5, 6 };
		root = buildBinaryTreeUsingArray(arr, root, 0);
		System.out.println(root);
		Set<Integer> excludedNodes = new HashSet<Integer>();
		System.out.println(binaryTreePath(root, 0));
		excludedNodes.add(2);
		System.out.println(binaryTreePathWithoutExcludedNodes(root, 0, excludedNodes));
		System.out.println(maxPath);
	}

	public static BinaryTree buildBinaryTreeUsingArray(int arr[], BinaryTree root, int i) {
		if (i < arr.length) {
			if (arr[i] == -1) {
				return root;
			}
			BinaryTree temp = new BinaryTree(arr[i]);
			root = temp;
			root.left = buildBinaryTreeUsingArray(arr, root.left, 2 * i + 1);
			root.right = buildBinaryTreeUsingArray(arr, root.right, 2 * i + 2);

		}
		return root;
	}

	public static int binaryTreePath(BinaryTree root, int level) {
		if (root == null) {
			return 0;
		}
		return 1 + binaryTreePath(root.left, level + 1) + binaryTreePath(root.right, level + 1);
	}

	public static int binaryTreePathWithoutExcludedNodes(BinaryTree root, int level, Set<Integer> excludedNodes) {
		if (root == null) {
			return 0;
		}
		int leftCount = binaryTreePathWithoutExcludedNodes(root.left, level + 1, excludedNodes);
		int rightCount = binaryTreePathWithoutExcludedNodes(root.right, level + 1, excludedNodes);
		if (excludedNodes.contains(root.val)) {
			maxPath = max(maxPath, leftCount);
			maxPath = max(maxPath, rightCount);
			return maxPath;
		} else {
			maxPath = max(maxPath, 1 + leftCount + rightCount);
			return 1 + leftCount + rightCount;
		}
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}
}
