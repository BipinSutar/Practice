package com.bipin.practice.codestudio;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        LongestCommonSubstring o = new LongestCommonSubstring();
        System.out.println(o.longestCommonSubstringIterative("abxd", "abzd"));
        System.out.println(o.longestCommonSubstringIterative("wasdijkl", "wsdjkl"));

    }

    public int longestCommonSubstringIterative(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 0; i <= n ; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= m ; j++){
            dp[j][0] = 0;
        }

        int longestLcsLength = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    longestLcsLength = Math.max(longestLcsLength, dp[i][j]);
                } else {
                    // dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    dp[i][j] = 0;
                }
            }
        }
        print2DArray(dp);
        return longestLcsLength;
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
