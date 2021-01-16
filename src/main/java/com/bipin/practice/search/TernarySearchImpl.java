package com.bipin.practice.search;

import java.util.Arrays;

import com.bipin.practice.algo.BinarySearchTree;

public class TernarySearchImpl {

	public static void main(String[] args) {
		int A[] = { 34, 22, 66, 41, 87, 97, 12, 64, 38 };
		// int A[] = { 1, 2, 3 };
		Arrays.sort(A);
		int len = 999999;
		int max = 0;
		int data[] = new int[len];
		for (int i = 0; i < len; i++) {
			data[i] = (int) (Math.random() * 5000);
			max = (data[i] > max) ? data[i] : max;
		}
		System.out.println("max " + max);
		Arrays.sort(data);
		long t1 = System.currentTimeMillis();
		System.out.println(ternarySearch(0, data.length - 1, max, data));
		long t2 = System.currentTimeMillis();
		System.out.println(BinerySearch.binarySearch(data, max));
		long t3 = System.currentTimeMillis();
		System.out.println(BinerySearch.binarySearchRecursive(data, max, 0, data.length - 1));
		long t4 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		System.out.println(t3 - t2);
		System.out.println(t4 - t3);
		System.out.println(data[ternarySearch(0, data.length - 1, max, data)] + "   "
				+ data[BinerySearch.binarySearchRecursive(data, max, 0, data.length - 1)]);
	}

	public static int ternarySearch(int l, int r, int x, int[] a) {
		if (r >= l) {
			int mid1 = l + (r - l) / 3;
			int mid2 = r - (r - l) / 3;
			if (a[mid1] == x)
				return mid1;
			if (a[mid2] == x)
				return mid2;
			if (x < a[mid1])
				return ternarySearch(l, mid1 - 1, x, a);
			else if (x > a[mid2])
				return ternarySearch(mid2 + 1, r, x, a);
			else
				return ternarySearch(mid1 + 1, mid2 - 1, x, a);

		}
		return -1;
	}

}
