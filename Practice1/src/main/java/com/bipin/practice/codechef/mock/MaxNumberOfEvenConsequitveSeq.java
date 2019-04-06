package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxNumberOfEvenConsequitveSeq {
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
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
		int data[] = new int[n];
		int count = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			data[i] = fs.nextInt();
			if (isEven(data[i]))
				count++;
			else {
				ans = max(ans, count);
				count = 0;
			}
		}
		System.out.println(max(ans, count));

	}

	public static boolean isEven(int x) {
		return x % 2 == 0 ? true : false;
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
