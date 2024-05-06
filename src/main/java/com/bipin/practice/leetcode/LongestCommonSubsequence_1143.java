package com.bipin.practice.leetcode;

import java.util.Arrays;

public class LongestCommonSubsequence_1143 {
    public static void main(String args[]) {
        LongestCommonSubsequence_1143 o = new LongestCommonSubsequence_1143();
        System.out.println(o.longestCommonSubsequence("abcde", "bdgek"));
        System.out.println(o.longestCommonSubsequenceIterative("abcde", "bdgek"));
    }

    public int longestCommonSubsequenceIterative(String s1, String s2) {
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
        return dp[n][m];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        f(text1, text2, n - 1, m - 1, dp);
        print2DArray(dp);
        return dp[n - 1][m - 1];
    }

    public int f(String s1, String s2, int i, int j, int dp[][]) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + f(s1, s2, i - 1, j - 1, dp);
        }
        return dp[i][j] = Math.max(f(s1, s2, i, j - 1, dp),
                f(s1, s2, i - 1, j, dp));
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
