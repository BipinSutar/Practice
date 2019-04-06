package com.bipin.practice.hackarrank.morgan_stanley_11_nov.test;

public class Interview08Mar2019 {
	public static void main(String[] args) {
		int arr[] = new int[]{1, 2, 3, 4};
		int k = 4;
		int sum = 0;
		System.out.println(isOperatorMath(arr, 0, sum, k));
	}
	public static boolean isOperatorMath(int arr[], int pos, int existingSum,
			int targetSum) {
		if (pos == arr.length || pos < 0) {
			return false;
		}
		if (pos == arr.length - 1 && (arr[pos] + existingSum == targetSum
				|| existingSum - arr[pos] == targetSum)) {
			return true;
		} else if (arr[pos] + existingSum > targetSum) {
			return isOperatorMath(arr, pos + 1, arr[pos] + existingSum,
					targetSum);
		} else {
			return isOperatorMath(arr, pos - 1, existingSum - arr[pos],
					targetSum);
		}
	}
}
