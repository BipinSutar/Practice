package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CountSubArrays {
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			return st.nextToken();
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

	public static void main(String[] args) {
		FastReader r = new FastReader();
		int t = r.nextInt();
		for (int i = 0; i < t; i++) {
			int n = r.nextInt();
			long data[] = new long[n];
			for (int j = 0; j < n; j++) {
				data[j] = r.nextLong();
			}
			getCountSubArrays(data, n);
		}
	}

	public static void getCountSubArrays(long arr[], int n) {
		long lis[] = new long[n];
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}
		// long max = Long.MIN_VALUE;
		// for (int i = 0; i < n; i++) {
		// if (lis[i] > max)
		// max = lis[i];
		// }
		long sum = 0;
		Set<Long> set = new HashSet<Long>();
		Arrays.sort(lis);
		for (int i = 0; i < n; i++) {

			if (!set.contains(new Long(lis[i]))) {
				// if(Collections.binarySearch(set, lis[i])>-1)
				// System.out.println("lis[i] " + lis[i] + set.contains(lis[i]));
				sum += lis[i];
				set.add(new Long(lis[i]));
			}

		}
		System.out.println(sum);
	}

}
