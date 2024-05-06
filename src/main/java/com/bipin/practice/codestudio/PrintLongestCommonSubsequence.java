package com.bipin.practice.codestudio;

import java.util.Arrays;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        PrintLongestCommonSubsequence o = new PrintLongestCommonSubsequence();
        System.out.println(o.longestCommonSubsequenceRecursiveshiftIndex("abcde", "bdgek"));
        System.out.println(o.longestCommonSubsequenceIterative("abcde", "bdgek"));

    }

    public String longestCommonSubsequenceRecursiveshiftIndex(String s1, String s2) {
        String lcs = null;
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        longestCommonSubsequenceRecursiveshiftIndex(s1, s2, n, m, dp);
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
        if (i == 0 || j == 0) {
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

    public String longestCommonSubsequenceRecursive(String s1, String s2) {
        String lcs = null;
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        longestCommonSubsequenceRecursive(s1, s2, n - 1, m - 1, dp);
        print2DArray(dp);
        int i = n - 1, j = m - 1;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
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

    public int longestCommonSubsequenceRecursive(String s1, String s2, int i, int j, int dp[][]) {
        if (i < 0 | j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + longestCommonSubsequenceRecursive(s1, s2, i - 1, j - 1, dp);
        }
        return dp[i][j] = Math.max(
                longestCommonSubsequenceRecursive(s1, s2, i - 1, j, dp),
                longestCommonSubsequenceRecursive(s1, s2, i, j - 1, dp));

    }

    public String longestCommonSubsequenceIterative(String s1, String s2) {
        String lcs = null;
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
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
