package com.bipin.practice.leetcode;

public class MaximumSubarry_53 {
	private final static boolean DEBUG_ENABLED = true;

	public static void main(String[] args) {
		int arr[] = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubarraySum(arr));
		System.out.println(maxSubarraySum1(arr));
		arr = new int[] { -8, -3, -6, -2, -5, -4 };
		System.out.println(maxSubarraySum(arr));
		System.out.println(maxSubarraySum1(arr));

	}

	public static void debug(String msg) {
		if (DEBUG_ENABLED) {
			System.out.println(msg);
		}
	}

	public static int maxSubarraySum(int arr[]) {
		int contSum = arr[0];
		int currSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			contSum = max(contSum, currSum);
			currSum = max(currSum, 0);
			currSum += arr[i];
			debug(arr[i] + " , " + currSum + " , " + contSum);
		}
		return max(contSum, currSum);

	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static int maxSubarraySum1(int arr[]) {
		int contSum = 0;
		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {

			currSum = currSum + arr[i];
			currSum = max(currSum, 0);
			contSum = max(contSum, currSum);
			debug(arr[i] + " , " + currSum + " , " + contSum);

		}

		return contSum;
	}

	public int maxSubArrayGS(int arr[]) {
		int contSum = Integer.MIN_VALUE;
		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {

			currSum = currSum + arr[i];
			currSum = max(currSum, arr[i]);
			contSum = max(contSum, currSum);
			// debug(arr[i] + " , " + currSum + " , " + contSum);

		}

		return contSum;
	}
}
