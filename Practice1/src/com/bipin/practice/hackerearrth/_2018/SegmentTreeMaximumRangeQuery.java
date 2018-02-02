package com.bipin.practice.hackerearrth._2018;

import java.util.Scanner;

public class SegmentTreeMaximumRangeQuery {
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

	/**
	 * Creates a new segment tree based off input array.
	 */
	public int[] createSegmentTree(int input[]) {
		int nextPowOfTwo = nextPowerOf2(input.length);
		int segmentTree[] = new int[nextPowOfTwo * 2 - 1];

		for (int i = 0; i < segmentTree.length; i++) {
			segmentTree[i] = Integer.MAX_VALUE;
		}
		constructMinSegmentTree(segmentTree, input, 0, input.length - 1, 0);
		return segmentTree;

	}

	private void constructMinSegmentTree(int segmentTree[], int input[], int low, int high, int pos) {
		if (low == high) {
			segmentTree[pos] = input[low];
			return;
		}
		int mid = (low + high) / 2;
		constructMinSegmentTree(segmentTree, input, low, mid, 2 * pos + 1);
		constructMinSegmentTree(segmentTree, input, mid + 1, high, 2 * pos + 2);
		segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
	}

	/**
	 * Queries given range for minimum value.
	 */
	public int rangeMinimumQuery(int[] segmentTree, int qlow, int qhigh, int len, int P) {
		return rangeMinimumQuery(segmentTree, 0, len - 1, qlow, qhigh, 0, P);
	}

	private int rangeMinimumQuery(int segmentTree[], int low, int high, int qlow, int qhigh, int pos, int P) {
		if (segmentTree[pos] < P)
			return -1;
		if (qlow <= low && qhigh >= high) {
			return segmentTree[pos];
		}
		if (qlow > high || qhigh < low) {
			return Integer.MAX_VALUE;
		}

		int mid = (low + high) / 2;
		return Math.min(rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1, P),
				rangeMinimumQuery(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2, P));
	}

	public void updateSegmentTree(int input[], int segmentTree[], int index, int delta) {
		input[index] += delta;
		updateSegmentTree(segmentTree, index, delta, 0, input.length - 1, 0);
	}

	private void updateSegmentTree(int segmentTree[], int index, int delta, int low, int high, int pos) {

		// if index to be updated is less than low or higher than high just return.
		if (index < low || index > high) {
			return;
		}

		// if low and high become equal, then index will be also equal to them and
		// update
		// that value in segment tree at pos
		if (low == high) {
			segmentTree[pos] += delta;
			return;
		}
		// otherwise keep going left and right to find index to be updated
		// and then update current tree position if min of left or right has
		// changed.
		int mid = (low + high) / 2;
		updateSegmentTree(segmentTree, index, delta, low, mid, 2 * pos + 1);
		updateSegmentTree(segmentTree, index, delta, mid + 1, high, 2 * pos + 2);
		segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
	}

	public static void main(String args[]) {
		SegmentTreeMaximumRangeQuery st = new SegmentTreeMaximumRangeQuery();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		int segTree[] = st.createSegmentTree(input);
		int q = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			int type = sc.nextInt();
			if (type == 1) {
				int pos = sc.nextInt() - 1;
				int new_val = sc.nextInt();
				st.updateSegmentTree(input, segTree, pos, new_val);
			} else {
				int L = sc.nextInt() - 1;
				int R = sc.nextInt() - 1;
				int P = sc.nextInt();
				int min = st.rangeMinimumQuery(segTree, L, R, input.length, P);
				System.out.println("dbg " + min);
				if (P < min) {
					sb.append(min + "\n");
				} else
					sb.append("-1\n");
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
