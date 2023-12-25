package com.bipin.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CreateCloneBinaryTreeUtil {
	static class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return printLevelOrderIterative(this);
		}
	}

	public static String printLevelOrderIterative(BinaryTreeNode root) {
		StringBuilder str = new StringBuilder();
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryTreeNode curr = q.remove();
			str.append(curr.val);
			if (curr.left != null) {
				q.add(curr.left);
				str.append(" -> L: ").append(curr.left.val);
			} else {
				str.append(" -> L: ").append(" null ");
			}
			if (curr.right != null) {
				q.add(curr.right);
				str.append(" ; R: ").append(curr.right.val);
			} else {
				str.append(" ; R: ").append(" null ");
			}
			str.append("\n");
		}
		return str.toString();
	}

	public static boolean checkIsMirrorTree(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		return root1.val == root2.val && checkIsMirrorTree(root1.left, root2.right)
				&& checkIsMirrorTree(root1.right, root2.left);
	}

	public static boolean checkIsEqualTree(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		return root1.val == root2.val && checkIsEqualTree(root1.left, root2.left)
				&& checkIsEqualTree(root1.right, root2.right);
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		System.out.println(root);
		BinaryTreeNode clonedRoot = createCloneOfTree(root);
		BinaryTreeNode clonedMirroedRoot = createClonedMirrorOfTree(root);
		System.out.println(clonedRoot);
		System.out.println(clonedMirroedRoot);
		System.out.println(checkIsEqualTree(root, clonedRoot));
		System.out.println(checkIsMirrorTree(root, clonedMirroedRoot));
	}

	public static BinaryTreeNode createCloneOfTree(BinaryTreeNode root) {
		if (root == null) {
			return null;
		}
		BinaryTreeNode curr = new BinaryTreeNode(root.val);
		curr.left = createCloneOfTree(root.left);
		curr.right = createCloneOfTree(root.right);
		return curr;
	}

	public static BinaryTreeNode createClonedMirrorOfTree(BinaryTreeNode root) {
		if (root == null) {
			return null;
		}
		BinaryTreeNode curr = new BinaryTreeNode(root.val);
		curr.right = createClonedMirrorOfTree(root.left);
		curr.left = createClonedMirrorOfTree(root.right);
		return curr;
	}

}
