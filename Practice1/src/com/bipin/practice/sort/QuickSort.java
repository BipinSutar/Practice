package com.bipin.practice.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) throws NullPointerException {

		int len = 600000;

		int data[] = new int[len];
		long start = System.currentTimeMillis();
		for (int i = 0; i < len; i++) {
			data[i] = (int) (Math.random() * 50);
			// System.out.print(data[i] + " , ");
		}
		// System.out.println();
		// data = quicksort(data, 0, data.length - 1);
		// for (int i : data) {
		// System.out.print(i + " , ");
		// }
		int bdata[] = Arrays.copyOf(data, len);
		long endquick = System.currentTimeMillis();
		int qdata[] = quicksort(data, 0, data.length - 1);
		endquick = System.currentTimeMillis();
		System.out.println("Quick sort " + (endquick - start) / 1000.0);

		Arrays.sort(bdata);
		long endquick_system = System.currentTimeMillis();
		System.out.println("Quick sort frm  system " + (endquick_system - endquick) / 1000.0);
		for (int i = 0; i < len; i++) {
			if (qdata[i] != bdata[i]) {
				System.out.println("fail");
				break;
			}
		}
		System.out.println("success");
	}

	public static int[] quicksort(int[] a, int start, int end) {
		if (start < end) {
			int pIndex = partitionArrayForQuickSort(a, start, end);
			quicksort(a, start, pIndex - 1);
			quicksort(a, pIndex + 1, end);
		}

		return a;
	}

	public static int partitionArrayForQuickSort(int a[], int start, int end) {
		int pivot = a[end];
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (a[i] <= pivot) {
				int temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		int temp = a[end];
		a[end] = a[pIndex];
		a[pIndex] = temp;

		return pIndex;
	}

	public static void swap(int first, int second) {
		second = first + second;
		first = second - first;
		second = second - first;
	}

	public static int[] bubbleSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] < a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}
}
