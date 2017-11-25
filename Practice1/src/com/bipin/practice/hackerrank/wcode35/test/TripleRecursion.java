package com.bipin.practice.hackerrank.wcode35.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TripleRecursion {
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
					// TODO Auto-generated catch block
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
		long a[][] = new long[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					a[i][j] = m;
				else if (i == j)
					a[i][j] = a[i - 1][j - 1] + k;
				else if (i > j)
					a[i][j] = a[i - 1][j] - 1;
				else if (i < j)
					a[i][j] = a[i][j - 1] - 1;
				dbg(a[i][j] + " ");
			}
			dbg("\n");
		}
	}

	public static void dbg(String s) {
		System.out.print(s);
	}

}
