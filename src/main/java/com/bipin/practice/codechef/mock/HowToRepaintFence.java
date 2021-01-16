package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HowToRepaintFence {
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

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println(2 & -2);
		FastReader br = new FastReader();
		int t = br.nextInt();
		for (int i = 0; i < t; i++) {
			String first_line_split[] = br.nextLine().split(" ");

			System.out.println(getHowToRepaintFence(br.nextLine(), Integer.parseInt(first_line_split[0]),
					Integer.parseInt(first_line_split[1])));
		}

	}

	public static int getHowToRepaintFence(String s, int n, int k) {
		char color[] = s.toCharArray();
		int miniuts = 0;
		for (int i = 0; i < color.length; i++) {
			if (color[i] == 'R') {
				int minIndex = Math.min(color.length - 1, (i + k) - 1);
				for (int j = i; j <= minIndex; j++) {
					color[j] = flip(color[j]);
				}
				miniuts++;
			}
		}
		return miniuts;
	}

	public static char flip(char ch) {
		return (ch == 'R') ? 'G' : 'R';
	}
}
