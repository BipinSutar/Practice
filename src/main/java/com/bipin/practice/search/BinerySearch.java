package com.bipin.practice.search;

import java.util.ArrayList;
import java.util.Arrays;

public class BinerySearch {

	public static void main(String[] args) {
		int A[] = {34, 22, 66, 41, 87, 97, 12, 64, 38};
		// int A[] = { 1, 2, 3 };
		Arrays.sort(A);
		new ArrayList<>(Arrays.asList(A))
				.forEach(num -> System.out.print(num + " , "));
		System.out.println();
		System.out.println(binarySearchRecursive(A, 66, 0, A.length - 1));
		System.out.println(binarySearch(A, 68));

		int arr[] = {1, 1, 2, 2, 3, 3, 3, 4};

		// Element to be counted in arr[]
		int x = 1;
		System.out.println(binarySearchFirst(arr, x, 0, arr.length - 1));
		System.out.println(binarySearchLast(arr, x, 0, arr.length - 1));

	}

	public static int binarySearchRecursive(int A[], int v, int low, int high) {
		int mid = (low + high) / 2;
		if (A[mid] == v) {
			return mid;
		}
		if (low >= high) {
			return -1;
		}
		if (A[mid] > v)
			return binarySearchRecursive(A, v, low, mid - 1);
		else
			return binarySearchRecursive(A, v, mid + 1, high);
	}

	public static int binarySearch(int A[], int v) {
		int lo = 0;
		int hi = A.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (A[mid] == v)
				return mid;
			if (A[mid] > v)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return -(lo + 1);

	}

	public static int binarySearchFirst(int A[], int v, int lo, int hi) {
		int mid = (lo + hi) / 2;
		if (mid == 1 && A[0] == v)
			return 0;
		if ((A[mid] == v) && (mid == 0 || A[mid - 1] < v))
			return mid;
		if (lo >= hi)
			return -1;
		if (A[mid] > v)
			return binarySearchFirst(A, v, lo, mid - 1);
		else
			return binarySearchFirst(A, v, mid + 1, hi);
	}

	public static int binarySearchLast(int[] A, int v, int lo, int hi) {
		int mid = (lo + hi) / 2;
		if ((A[mid] == v) && (mid == A.length - 1 || A[mid + 1] > v))
			return mid;
		if (lo >= hi)
			return -1;
		if (A[mid] > v)
			return binarySearchLast(A, v, lo, mid - 1);
		else
			return binarySearchLast(A, v, mid + 1, hi);
	}
}