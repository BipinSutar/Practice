package com.bipin.practice.codestudio;

import java.util.Arrays;

public class LongestPalindromicSubsequence_5 {
    public static void main(String args[]) {
        LongestPalindromicSubsequence_5 o = new LongestPalindromicSubsequence_5();
        System.out.println(o.longestCommonSubsequenceRecursiveshiftIndex("11arora22", "33arora44"));
    }

    public String longestCommonSubsequenceRecursiveshiftIndex(String s1, String s2) {
        String lcs = null;
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int lcslength = longestCommonSubsequenceRecursiveshiftIndex(s1, s2, n, m, dp);
        print2DArray(dp);
        int i = n;
        int j = m;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs = sb.reverse().toString();

    }

    public int longestCommonSubsequenceRecursiveshiftIndex(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 1 || j < 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = 1 + longestCommonSubsequenceRecursiveshiftIndex(s1, s2, i - 1, j - 1, dp);
        }
        return dp[i][j] = Math.max(
                longestCommonSubsequenceRecursiveshiftIndex(s1, s2, i, j - 1, dp),
                longestCommonSubsequenceRecursiveshiftIndex(s1, s2, i - 1, j, dp));
    }

    public void print2DArray(int[][] dp) {
        boolean oneline = false;
        if (oneline) {
            System.out.println(Arrays.deepToString(dp));
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    sb.append(dp[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }

    }

}
