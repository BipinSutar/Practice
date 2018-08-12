package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Split_Stones_SPLST {
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

	public static void main(String[] args) throws IOException {
		FastReader fs = new FastReader();
		int t = fs.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			boolean ans = getSplitStones(fs.nextInt(), fs.nextInt(), fs.nextInt(), fs.nextInt(), fs.nextInt());
			sb.append(ans ? "YES" : "NO");
			sb.append("\n");
		}
		System.out.print(sb);

	}

	public static boolean getSplitStones(int a, int b, int c, int x, int y) {
		// try 1
		int k = x - a;
		int s_k = y - c;
		if ((k > -1 && s_k > -1) && (k + s_k) == b & (b - k) == y - c) {
			return true;
		}

		k = x - c;
		s_k = y - a;
		if ((k > -1 && s_k > -1) && (k + s_k) == b & (b - k) == y - a) {
			return true;
		}
		// try 2

		k = x - b;
		s_k = y - c;
		if ((k > -1 && s_k > -1) && (k + s_k) == a & (a - k) == y - c) {
			return true;
		}

		k = x - c;
		s_k = y - b;
		if ((k > -1 && s_k > -1) && (k + s_k) == a & (a - k) == y - b) {
			return true;
		}
		// try 3
		k = x - a;
		s_k = y - b;
		if ((k > -1 && s_k > -1) && (k + s_k) == c & (c - k) == y - b) {
			return true;
		}
		k = x - b;
		s_k = y - a;
		if ((k > -1 && s_k > -1) && (k + s_k) == c & (c - k) == y - a) {
			return true;
		}
		return false;
	}

	public static boolean getSplitStones1(int a, int b, int c, int x, int y) {
		for (int i = 0; i <= b; i++) {
			int b_i = b - i;
			if ((((b_i + a) == x) & (b - b_i + c) == y) || (((b_i + c) == x) & (b - b_i + a) == y)) {
				return true;
			}
		}

		for (int i = 0; i <= a; i++) {
			int a_i = a - i;
			if ((((a_i + b) == x) & (a - a_i + c) == y) || (((a_i + c) == x) & (a - a_i + b) == y)) {
				return true;
			}
		}

		for (int i = 0; i <= c; i++) {
			int c_i = c - i;
			if ((((c_i + a) == x) & (c - c_i + b) == y) || (((c_i + b) == x) & (c - c_i + a) == y)) {
				return true;
			}
		}

		return false;
	}

}
