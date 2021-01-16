package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ForcedParticles_FRCPRT {
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

	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int t = fs.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = fs.nextInt();
			int m = fs.nextInt();
			String s[] = new String[n];
			for (int i = 0; i < n; i++) {
				s[i] = fs.nextLine();
			}
			String com = fs.nextLine();
			sb.append(getForcedParticle(s, com));

		}
		System.out.println(sb);

	}

	public static StringBuilder getForcedParticle(String arr[], String com) {
		char data[][] = new char[arr.length][arr[0].length()];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i].toCharArray();
		}
		for (int c = 0; c < com.length(); c++) {
			switch (com.charAt(c)) {
			case 'R': {
				for (int i = 0; i < data.length; i++) {
					int count = 0;
					for (int j = 0; j < data[0].length; j++) {
						if (data[i][j] == '1') {
							count++;
						}
					}
					count = data[0].length - count;
					for (int j = 0; j < data[0].length; j++) {
						if (count > 0) {
							data[i][j] = '0';
							count--;
						} else {
							data[i][j] = '1';
						}

					}
				}
				break;
			}
			case 'L': {
				for (int i = 0; i < data.length; i++) {
					int count = 0;
					for (int j = 0; j < data[0].length; j++) {
						if (data[i][j] == '1') {
							count++;
						}
					}
					for (int j = 0; j < data[0].length; j++) {
						if (count > 0) {
							data[i][j] = '1';
							count--;
						} else {
							data[i][j] = '0';
						}

					}
				}
				break;
			}
			case 'D': {
				for (int i = 0; i < data[0].length; i++) {
					int count = 0;
					for (int j = 0; j < data.length; j++) {
						if (data[j][i] == '1') {
							count++;
						}
					}
					count = data.length - count;
					for (int j = 0; j < data.length; j++) {
						if (count > 0) {
							data[j][i] = '0';
							count--;
						} else {
							data[j][i] = '1';
						}

					}
				}
				break;
			}
			case 'U': {
				for (int i = 0; i < data[0].length; i++) {
					int count = 0;
					for (int j = 0; j < data.length; j++) {
						if (data[j][i] == '1') {
							count++;
						}
					}

					for (int j = 0; j < data.length; j++) {
						if (count > 0) {
							data[j][i] = '1';
							count--;
						} else {
							data[j][i] = '0';
						}

					}
				}
				break;
			}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				sb.append(data[i][j]);
			}
			sb.append("\n");
		}
		return sb;
	}
}
