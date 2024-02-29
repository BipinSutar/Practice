package com.bipin.practice.leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {

	public static void main(String[] args) {
		int nums[] = new int[] { -1, -2, 0, -3, 3 };
		System.out.println(Arrays.toString(new ProductOfArrayExceptSelf_238().productExceptSelf(nums)));
		System.out.println(Arrays.toString(new ProductOfArrayExceptSelf_238().productExceptSelf1(nums)));
		nums = new int[] { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(new ProductOfArrayExceptSelf_238().productExceptSelf(nums)));
		System.out.println(Arrays.toString(new ProductOfArrayExceptSelf_238().productExceptSelf1(nums)));
	}

	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int res[] = new int[n];
		int curr = 1;
		// init all res array to 1
		for (int i = 0; i < n; i++) {
			res[i] = 1;
		}
		// left prefix product
		for (int i = 0; i < n; i++) {
			res[i] *= curr;
			curr *= nums[i];
		}
		curr = 1;
		// right suffix product
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= curr;
			curr *= nums[i];
		}
		// now res will have product but it self
		return res;
	}

	public int[] productExceptSelf1(int[] nums) {
		int n = nums.length;
		int res[] = new int[n];
		int prefixProduct[] = new int[n];
		int suffixProduct[] = new int[n];
		prefixProduct[0] = 1;
		suffixProduct[n - 1] = 1;

		// left prefix product
		for (int i = 1; i < n; i++) {
			prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
		}
		// right suffix product
		for (int i = n - 2; i >= 0; i--) {
			suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
		}
		// now res will have product but it self
		for (int i = 0; i < n; i++) {
			res[i] = prefixProduct[i] * suffixProduct[i];
		}
		return res;
	}
}
