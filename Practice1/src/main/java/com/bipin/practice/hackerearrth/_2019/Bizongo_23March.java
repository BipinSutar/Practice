package com.bipin.practice.hackerearrth._2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bizongo_23March {

	public static void mainLCS(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		if (s.length() < t.length()) {
			String temp = s;
			s = t;
			t = temp;
		}
		System.out.println(getLongestCommonSubstring(s, t));
		br.close();
	}

	public static int getLongestCommonSubstring(String a, String b) {
		int m = a.length();
		int n = b.length();

		int max = 0;

		int[] dp = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					if (i == 0 || j == 0) {
						dp[j] = 1;
					} else {
						dp[j] = dp[j - 1] + 1;
					}

					if (max < dp[j])
						max = dp[j];
				}

			}
		}

		return max;
	}
	public static int getLCS(String a, String b) {
		int ans = 0;
		int count = 0;
		for (int i = 0; i < b.length(); i++) {

			if (a.charAt(i) == b.charAt(i)) {
				count++;
			} else {
				ans = Integer.max(ans, count);
				count = 0;
			}
		}
		return ans;

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String line[] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		String arr[] = new String[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}
		System.out.println(getCount(arr, n, m));
		br.close();

	}
	public static int getCount(String arr[], int n, int m) {
		int ans = 0;

		for (int col = 0; col < m; col++) {
			for (int row = 0; row < arr.length - 1; row++) {
				// if (arr[row].length() <= arr[row + 1].length()) {
				if (arr[row].charAt(col) > arr[row + 1].charAt(col)) {
					ans++;
					break;
				}
				// }
			}
		}
		return ans;
	}
}
