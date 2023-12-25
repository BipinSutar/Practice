package com.bipin.practice.leetcode;

public class FirstMissingPositive_41 {

    public static void main(String[] args) {
//		System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
//		System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{2, 3, 2, 1}));

    }

    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0
                    && arr[i] <= n
                    && arr[i] != arr[arr[i] - 1]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;

            }

        }

        return n + 1;
    }
}
