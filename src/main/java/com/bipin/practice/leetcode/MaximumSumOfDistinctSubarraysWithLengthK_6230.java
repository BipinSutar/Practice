package com.bipin.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfDistinctSubarraysWithLengthK_6230 {
    public static void main(String[] args) {
//		System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
//		System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
        MaximumSumOfDistinctSubarraysWithLengthK_6230 obj = new MaximumSumOfDistinctSubarraysWithLengthK_6230();
        System.out.println(obj.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println(obj.maximumSubarraySum(new int[]{4, 4, 4}, 3));
        System.out.println(obj.maximumSubarraySum(new int[]{9, 9, 9, 1, 2, 3}, 3));

    }

    public long maximumSubarraySum(int[] nums, int k) {
        int maxSum = 0;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i >= k - 1) {
                if (map.size() == k) {
                    maxSum = max(maxSum, currSum);
                }
                int startOfNewWindow = nums[i - k + 1];
                currSum -= startOfNewWindow;
                map.put(startOfNewWindow, map.get(startOfNewWindow) - 1);
                if (map.get(startOfNewWindow) == 0) {
                    map.remove(startOfNewWindow);
                }


            }
        }
        return maxSum;

    }

    public long maximumSubarraySumN2(int[] nums, int k) {
        int max_sum = 0;
        for (int i = 0; i < nums.length; i++) {

            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            for (int j = i; j < min(nums.length, i + k); j++) {
                if (i + k > nums.length) {
                    break;
                }
                sum += nums[j];
                if (map.containsKey(nums[j])) {
                    map.put(nums[j], map.get(nums[j]) + 1);
                } else {
                    map.put(nums[j], 1);

                }
            }

            for (Integer key : map.keySet()) {
                if (map.get(key) > 1) {
                    sum = 0;
                    break;
                }
            }

            max_sum = max(max_sum, sum);
        }
        return max_sum;

    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }
}
