package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Interval {
	int buy, sell;
}

public class _11_March_NinjaKart {

	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int data[] = new int[n];
		String line[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(line[i]);
		}
		System.out.println(maxProfit(data, n, 1));
		br.close();
	}

	public static int maxProfit(int price[], int n, int k) {
		// table to store results of subproblems
		// profit[t][i] stores maximum profit using atmost
		// t transactions up to day i (including day i)

		int profit[][] = new int[k + 1][n + 1];

		// For day 0, you can't earn money
		// irrespective of how many times you trade
		for (int i = 0; i <= k; i++)
			profit[i][0] = 0;

		// profit is 0 if we don't do any transation
		// (i.e. k =0)
		for (int j = 0; j <= n; j++)
			profit[0][j] = 0;

		// fill the table in bottom-up fashion
		for (int i = 1; i <= k; i++) {
			int prevDiff = Integer.MIN_VALUE;
			for (int j = 1; j < n; j++) {
				if (price[j - 1] > -1) {
					prevDiff = max(prevDiff, profit[i - 1][j - 1] - price[j - 1]);
					profit[i][j] = max(profit[i][j - 1], price[j] + prevDiff);
				}
			}
		}

		return profit[k][n - 1];
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String line[] = br.readLine().split(" ");
			int p = Integer.parseInt(line[0]);
			int w = Integer.parseInt(line[1]);
			int empAtFloor[] = new int[n];
			line = br.readLine().split(" ");
			for (int i = 0; i < line.length; i++) {
				empAtFloor[i] = Integer.parseInt(line[i]);
			}
			int q = 2 * (n - 1);
			while (q-- > 0) {

			}
		}
		br.close();
	}
}
