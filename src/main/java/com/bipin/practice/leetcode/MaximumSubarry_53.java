package com.bipin.practice.leetcode;

public class MaximumSubarry_53 {
	
	private final static boolean DEBUG_ENABLED = false;

	public static void main(String[] args) {
		MaximumSubarry_53 o = new MaximumSubarry_53();
		int arr[] = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(o.maxSubarraySum(arr));
		System.out.println(o.maxSubArrayGS(arr));

		arr = new int[] { -8, -3, -6, 2, -5, -4 };
		System.out.println(o.maxSubarraySum(arr));
		System.out.println(o.maxSubArrayGS(arr));

	}

	public void debug(String msg) {
		if (DEBUG_ENABLED) {
			System.out.println(msg);
		}
	}

	public int maxSubarraySum(int arr[]) {
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			maxSum = max(maxSum, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;

	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public int maxSubArrayGS(int arr[]) {
		int contSum = Integer.MIN_VALUE;
		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {

			currSum = currSum + arr[i];
			currSum = max(currSum, arr[i]);
			contSum = max(contSum, currSum);
			debug(arr[i] + " , " + currSum + " , " + contSum);

		}

		return contSum;
	}
}
