package com.bipin.practice.sort;

public class MergeSort {

	public static void main(String[] args) {
		int len = 10;
		int data[] = new int[len];
		long start = System.currentTimeMillis();
		for (int i = 0; i < len; i++) {
			data[i] = (int) (Math.random() * 50);
			 System.out.print(data[i] + " , ");
		}

		int qdata[] = new QuickSort().quicksort1(data, 0, data.length - 1);

		long endquick = System.currentTimeMillis();
		System.out.println("Quick sort " + (endquick - start) / 1000.0);
		int mdata[] = mergeeSort(data);

		endquick = System.currentTimeMillis();
		System.out.println("Merge sort " + (endquick - start) / 1000.0);
		for (int i : mdata)
			System.out.print(i + " , ");
		{

		}
		for (int i = 0; i < len; i++) {
			if (qdata[i] != mdata[i]) {
				System.out.println("fail");
				break;
			}
		}
		System.out.println("success");
	}

	public static int[] mergeeSort(int[] A) {
		int n = A.length;
		if (n < 2)
			return A;
		int middle = n / 2;
		int left[] = new int[middle];
		int right[] = new int[n - middle];
		for (int i = 0; i < middle; i++) {
			left[i] = A[i];
		}
		for (int i = middle; i < n; i++) {
			right[i - middle] = A[i];
		}
		left = mergeeSort(left);
		right = mergeeSort(right);
		A = merge(left, right, A);
		return A;
	}

	public static int[] merge(int[] left, int[] right, int[] A) {
		int nL = left.length;
		int nR = right.length;
		int i = 0, j = 0, k = 0;
		while (i < nL & j < nR) {
			if (left[i] <= right[j]) {
				A[k] = left[i];
				i++;
			} else {
				A[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < nL) {
			A[k] = left[i];
			i++;
			k++;
		}
		while (j < nR) {
			A[k] = right[j];
			j++;
			k++;
		}
		return A;
	}

}
