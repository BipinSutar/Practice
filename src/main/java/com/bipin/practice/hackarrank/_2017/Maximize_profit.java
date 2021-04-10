package com.bipin.practice.hackarrank._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maximize_profit {
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}

	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int n = fs.nextInt();
		int m = fs.nextInt();
		int k = fs.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = fs.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = fs.nextInt();
		}
		System.out.println(calMaxProfit(n, m, k, a, b));
	}

	public static int calMaxProfit(int n, int m, int k, int a[], int b[]) {
		int maxProfit = m * k;
		for (int i = 0; i < n; i++) {
			int currprofit = m * a[i] * b[i];
			if (currprofit > maxProfit) {
				maxProfit = currprofit;
			}
		}

		return maxProfit;
	}

}
