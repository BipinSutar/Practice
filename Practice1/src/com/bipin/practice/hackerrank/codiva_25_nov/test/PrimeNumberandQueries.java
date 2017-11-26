package com.bipin.practice.hackerrank.codiva_25_nov.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimeNumberandQueries {
	private static int[] primeno = new int[78498];// 78498

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
		int q = fs.nextInt();
		long o = System.currentTimeMillis();
		calprimeno();
		while (q-- > 0) {
			int start_val = fs.nextInt();
			int end_val = fs.nextInt();
			int start_prime = 0;
			int end_prime = 0;
			boolean flag1 = false, flag2 = false;
			int ans = 0;
			if (start_val >= end_val) {
				flag1 = true;
				flag2 = true;
			}
			// for (int i = 0, j = primeno.length - 1; i < primeno.length; i++) {
			// if (primeno[i] >= start_val && !flag1) {
			// start_prime = primeno[i];
			// flag1 = true;
			// }
			// if (primeno[j] <= end_val && !flag2) {
			// end_prime = primeno[j];
			// flag2 = true;
			// } else
			// j--;
			// if (flag1 && flag2)
			// break;
			// }
			int pos = Arrays.binarySearch(primeno, start_val);
			if (pos < 0) {
				pos = (pos * -1) - 1;
				while (primeno[pos] < start_val)
					pos++;
			}
			start_prime = primeno[pos];
			pos = Arrays.binarySearch(primeno, end_val);
			if (pos < 0) {
				pos = (pos * -1) - 1;
				while (primeno[pos] > end_val)
					pos--;

			}
			end_prime = primeno[pos];
			System.out.println(" start_prime= " + start_prime + " end_prime= " + end_prime);
			ans = end_prime - start_prime;
			System.out.println((ans < 0) ? 0 : ans);
		}

	}

	private static void calprimeno() {
		int k = 0;
		for (int i = 2; i < 1000001; i++) {
			boolean flag = true;
			int var = (int) Math.sqrt(i);
			for (int j = 2; j <= var; j = j + 1) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				primeno[k] = i;
				k++;
			}
		}

	}

}
