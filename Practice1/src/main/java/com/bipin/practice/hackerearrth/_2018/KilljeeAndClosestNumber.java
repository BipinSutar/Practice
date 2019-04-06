package com.bipin.practice.hackerearrth._2018;

import java.util.Scanner;

public class KilljeeAndClosestNumber {
	int segmentTree[];

	KilljeeAndClosestNumber(int arr[]) {
		int x = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));

		int size = 2 * (int) Math.pow(2, x) - 1;
		segmentTree = new int[size];
		contructTree(arr, segmentTree, 0, arr.length - 1, 0);
	}

	int maxVal(int x, int y) {
		return (x > y) ? x : y;
	}

	int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

	public void contructTree(int input[], int segmentTree[], int low, int high, int pos) {
		if (low == high) {
			segmentTree[pos] = input[low];
			return;
		}
		int mid = getMid(low, high);
		contructTree(input, segmentTree, low, mid, 2 * pos + 1);
		contructTree(input, segmentTree, mid + 1, high, 2 * pos + 2);
		segmentTree[pos] = maxVal(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
	}

	void updateValue(int input[], int n, int pos, int new_val) {
		
		// Update the value in array
		input[pos] = new_val;

		// Update the values of nodes in segment tree
		updateValueUtil(0, n - 1, pos, /* diff */new_val, 0);
	}

	void updateValueUtil(int low, int high, int pos, int new_val, int si) {
		// Base Case: If the input index lies outside the range of
		// this segment
		if (pos < low || pos > high)
			return;

		// If the input index is in range of this node, then update the
		// value of the node and its children
		segmentTree[si] = new_val;
		if (high != low) {
			int mid = getMid(low, high);
			updateValueUtil(low, mid, pos, new_val, 2 * si + 1);
			updateValueUtil(mid + 1, high, pos, new_val, 2 * si + 2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		KilljeeAndClosestNumber obj = new KilljeeAndClosestNumber(input);
		int q = sc.nextInt();
		while (q-- > 0) {
			int type = sc.nextInt();
			if (type == 1) {
				int pos = sc.nextInt();
				int new_val = sc.nextInt();
				obj.updateValue(input, n, pos, new_val);
			} else {
				int L = sc.nextInt();
				int R = sc.nextInt();
				int P = sc.nextInt();
				
			}
		}
	}

}
