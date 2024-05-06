package com.bipin.practice.leetcode;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        ContainerWithMostWater_11 o = new ContainerWithMostWater_11();
        System.out.println(o.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    public int maxArea(int heights[]) {
        int n = heights.length;
        int start = 0;
        int end = n - 1;
        int maxArea = Integer.MIN_VALUE;

        while (start <= end) {
            int minHeight = min(heights[start], heights[end]);
            maxArea = max(
                    maxArea,
                    minHeight * (end - start));
            if (minHeight == start) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }

}
