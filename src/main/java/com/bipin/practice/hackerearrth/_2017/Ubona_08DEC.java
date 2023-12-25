package com.bipin.practice.hackerearrth._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ubona_08DEC {
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

		public long nextLong() {
			return Long.parseLong(next());
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

	public static void main(String[] args) {// mainCanYouCount
		FastReader sc = new FastReader();
		int t = Integer.parseInt(sc.nextLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			sb.append(getCanYouCountAns(sc.nextLine()) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static long getCanYouCountAns(String in) {
		long ans_count = 1L;
		int len = in.length();
		int v_count = 0;
		boolean flagA = true, flagE = true, flagI = true, flagO = true, flagU = true;
		for (int i = 0; i < len; i++) {

			char ch = in.charAt(i);

			if (ch == 'a' && flagA) {
				v_count++;
				flagA = false;
			} else if (ch == 'e' && flagE) {
				v_count++;
				flagE = false;
			} else if (ch == 'i' && flagI) {
				v_count++;
				flagI = false;
			} else if (ch == 'o' && flagO) {
				v_count++;
				flagO = false;
			} else if (ch == 'u' && flagU) {
				v_count++;
				flagU = false;
			} else if (ch == '_') {
				ans_count *= (v_count == 0 ? 1 : v_count);
			}
		}
		return ans_count;
	}

	public static void mainAccommodation(String[] args) { // mainAccommodation

		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int data[] = new int[n];
		for (int i = 0; i < n; i++) {

			data[i] = sc.nextInt();
		}
		System.out.println(count(m, data));

	}

	public static long count(int n, int data[]) {

		int m = 1000000007;
		long table[] = new long[n + 1];
		for (int i = 0; i < table.length; i++) {
			table[i] = 0;
		}
		table[0] = 1;
		for (int j = 0; j < data.length; j++) {
			for (int i = data[j]; i <= n; i++) {

				table[i] = (table[i] + table[i - data[j]]) % m;
			}
		}
		return table[n] % m;
	}

}
