package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SALARY {
	static class FastReader {
		BufferedReader br = null;
		StringTokenizer st = null;

		FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException r) {

				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
			int data[] = new int[n];
			// Arrays.sort(data,Collections.reverseOrder());
			Arrays.sort(data);
			int sum = 0;
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				data[i] = fs.nextInt();
				sum += data[i];
				min = Math.min(data[i], min);
			}
			sb.append((sum - (n * min)) + "\n");

		}
		System.out.println(sb);
	}

}
