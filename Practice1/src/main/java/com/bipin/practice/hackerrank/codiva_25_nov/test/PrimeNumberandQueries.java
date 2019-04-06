package com.bipin.practice.hackerrank.codiva_25_nov.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class PrimeNumberandQueries {
	private static ArrayList<Integer> primeno = new ArrayList<>();

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

	public static void main(String[] args) throws Exception {
		FastReader fs = new FastReader();
		int q = fs.nextInt();
		long o = System.currentTimeMillis();
		calprimeno();
		long o1 = System.currentTimeMillis();
		System.out.println(o1 - o);
		int qt = 0;
		for (int i = 0; i < primeno.size(); i++) {
			qt++;
		}
		System.out.println(qt);
		while (q-- > 0) {
			int start_val = fs.nextInt();
			int end_val = fs.nextInt();
			int start_prime = 0;
			int end_prime = 0;
			int start_prime_pos = 0, end_prime_pos = 0;
			int ans = 0;

			int pos = Collections.binarySearch(primeno, start_val);
			if (pos < 0) {
				pos = (pos * -1) - 1;
				while (primeno.get(pos) < start_val)
					pos++;
			}
			start_prime = primeno.get(pos);
			start_prime_pos = pos;
			pos = Collections.binarySearch(primeno, end_val);
			if (pos < 0) {
				pos = (pos * -1) - 1;
				while (primeno.get(pos) > end_val)
					pos--;

			}
			end_prime = primeno.get(pos);
			end_prime_pos = pos;
			// System.out.println(" start_prime= " + start_prime + " end_prime= " +
			// end_prime);
			ans = end_prime - start_prime;
			// System.out.println((ans < 0) ? 0 : ans);
			StringBuilder sb = new StringBuilder();
			for (int i = start_prime_pos; i <= end_prime_pos; i++) {
				sb.append(primeno.get(pos) + "\n");
			}
			System.out.println(sb.toString());
		}

	}

	private static void calprimeno() {
		int k = 0;
		primeno.add(2);
		primeno.add(3);
		for (int i = 4; i < 1000000001; i++) {
			boolean flag = true;
			if (i % 2 == 0)
				continue;
			int var = (int) Math.sqrt(i);
			for (int j = 2; j <= var; j = j + 1) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				// primeno.add(k, i);
				primeno.add(i);
				k++;
			}
		}

	}

}
