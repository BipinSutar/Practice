package com.bipin.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Shift2dArray {

	public static void main(String[] args) {
		int mat[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int k = 2;
		new Shift2dArray().shiftGrid(mat, k);
	}
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		List<List<Integer>> l = new ArrayList<>();
		int[] arr = new int[grid.length * grid[0].length];
		int count = grid.length * grid[0].length;
		k = k % count;
		int arr_k = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				arr[arr_k] = grid[i][j];
				arr_k++;
			}
		}
		rightRotate(arr, k, arr.length);

		arr_k = 0;
		for (int i = 0; i < grid.length; i++) {
			List<Integer> ll = new ArrayList<>();
			for (int j = 0; j < grid[i].length; j++) {
				ll.add(arr[arr_k]);
				arr_k++;
			}
			l.add(ll);
		}
		return l;
	}
	void reverseArray(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	// Function to right rotate
	// arr[] of size n by d
	void rightRotate(int arr[], int d, int n) {
		reverseArray(arr, 0, n - 1);
		reverseArray(arr, 0, d - 1);
		reverseArray(arr, d, n - 1);
	}

}
