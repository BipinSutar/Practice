package com.bipin.practice.leetcode;

public class MaximumProductSubarray_152 {

	public static void main(String[] args) {

		System.out.println(new MaximumProductSubarray_152().maxProductSubArray(new int[] { 2, 3, -2, 4 }));
		System.out.println(new MaximumProductSubarray_152().maxProductSubArray(new int[] { -2 }));
		System.out.println(new MaximumProductSubarray_152().maxProductSubArray(new int[] { -2, 3, -2, 4 }));
	}

	public int maxProductSubArray(int nums[]) {
		int ans = 0;
		int prefixProduct = 1;
		int suffixProduct = 1;
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}
		for (int i = 0; i < n; i++) {
			if (prefixProduct == 0) {
				prefixProduct = 1;
			}
			if (suffixProduct == 0) {
				suffixProduct = 1;
			}
			prefixProduct = prefixProduct * nums[i];
			suffixProduct = suffixProduct * nums[n - i - 1];
			ans = max(ans, max(prefixProduct, suffixProduct));
		}

		return ans;

	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

}
