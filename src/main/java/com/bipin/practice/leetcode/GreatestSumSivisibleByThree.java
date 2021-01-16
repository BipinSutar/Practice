package com.bipin.practice.leetcode;

import java.util.Arrays;

public class GreatestSumSivisibleByThree {

	public static void main(String[] args) {
		int arr[] = new int[]{2, 3, 36, 8, 32, 38, 3, 30, 13, 40};
		new GreatestSumSivisibleByThree().maxSumDivThree(arr);
	}
	public int maxSumDivThree(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (divByThree(sum)) {
			return sum;
		}
		int tree[] = new int[2 * nextPowerOf2(nums.length)];
		Arrays.sort(nums);
		buildtree(nums, tree, 0, nums.length - 1, 1);
		Arrays.sort(tree);
		for (int i = 0; i < tree.length; i++) {
			int diff = sum - tree[i];
			if (divByThree(diff)) {
				int p = Arrays.binarySearch(tree, 3);
				if (p > 0 && i > p) {
					return diff + 3;
				}
				return diff;
			}
		}
		return 0;
	}
	public void buildtree(int arr[], int tree[], int start, int end,
			int treeNode) {

		if (start == end) {
			tree[treeNode] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		buildtree(arr, tree, start, mid, 2 * treeNode);
		buildtree(arr, tree, mid + 1, end, 2 * treeNode + 1);
		tree[treeNode] = tree[2 * treeNode] + tree[2 * treeNode + 1];
	}

	boolean divByThree(int num) {
		int digitsum = 0;
		while (num > 0) {
			digitsum += num % 10;
			num /= 10;

		}
		return digitsum % 3 == 0;

	}
	public int nextPowerOf2(int num) {
		if (num == 0) {
			return 1;
		}
		if (num > 0 && (num & (num - 1)) == 0) {
			return num;
		}
		while ((num & (num - 1)) > 0) {
			num = num & (num - 1);
		}
		return num << 1;
	}
}
