package com.bipin.practice.leetcode;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray_3105 {

    public static void main(String[] args) {

        LongestStrictlyIncreasingOrStrictlyDecreasingSubarray_3105 o = new LongestStrictlyIncreasingOrStrictlyDecreasingSubarray_3105();
        System.out.println(o.longestMonotonicSubarray(new int[] { 3, 2, 1 }));
        System.out.println(o.longestMonotonicSubarray(new int[] { 1, 1, 5 }));
    }

    public int longestMonotonicSubarray(int[] nums) {
        int res = -1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        res = Math.max(res, count);
        count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        res = Math.max(res, count);
        return res;
    }
}
