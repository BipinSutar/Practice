package com.bipin.practice.hackerearrth._18Nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sapinet_08Dec {

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
	}

	public static void main(String[] args) {// mainGameOfNumbers

		FastReader fs = new FastReader();
		long n = fs.nextLong();
		long A[] = new long[(int) n];
		for (int i = 0; i < n; i++) {
			A[i] = fs.nextLong();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			long nextGreater = A[i];
			int nextGreater_i = i;
			for (int j = i; j < n; j++) {
				if (A[j] > nextGreater) {
					nextGreater = A[j];
					nextGreater_i = j;
					break;
				}
			}
			if (nextGreater_i == i) {
				sb.append("-1 ");
				continue;
			}
			// treat nextGreater as nextSmalller
			// nextGreater_i = i;
			for (int j = nextGreater_i + 1; j < n; j++) {
				if (A[j] < nextGreater) {
					nextGreater = A[j];
					nextGreater_i = j;
					break;
				}
			}
			if (nextGreater_i == i + 1) {
				sb.append("-1 ");
				continue;
			} else
				sb.append(nextGreater + " ");
		}
		System.out.println(sb.toString().substring(0, sb.length() - 1));
	}

	public static void mainSpecialNumbers(String[] args) { // mainSpecialNumbers
		int[] primeno = new int[78498];
		ArrayList<Integer> primelist = new ArrayList<>();
		ArrayList<Integer> nonprimelist = new ArrayList<>();
		Scanner fs = new Scanner(System.in);
		int n = fs.nextInt();
		calprimeno(primeno);
		for (int i = 0; i < n; i++) {
			int in = fs.nextInt();
			if (isPrime(primeno, in)) {
				int pos = Collections.binarySearch(primelist, in);
				if (pos < 0)
					primelist.add(-pos - 1, in);
				else
					primelist.add(pos + 1, in);
			} else {
				int pos = Collections.binarySearch(nonprimelist, in);
				if (pos < 0)
					nonprimelist.add(-pos - 1, in);
				else
					nonprimelist.add(pos + 1, in);
			}
		}
		StringBuilder ans = new StringBuilder();
		int size = primelist.size();
		for (int i = 0; i < size; i++) {
			ans.append(primelist.get(i) + " ");
		}
		size = nonprimelist.size();
		for (int i = size - 1; i > -1; i--) {
			ans.append(nonprimelist.get(i) + " ");
		}
		ans.append("\n");
		System.out.println(ans.toString());
	}

	private static void calprimeno(int primeno[]) {
		int k = 3;
		primeno[0] = 2;
		primeno[1] = 3;
		primeno[2] = 5;
		for (int i = 6; i < 1000001; i++) {
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

	private static boolean isPrime(int a[], int n) {
		int pos = Arrays.binarySearch(a, n);
		return pos < 0 ? false : true;
	}

}
