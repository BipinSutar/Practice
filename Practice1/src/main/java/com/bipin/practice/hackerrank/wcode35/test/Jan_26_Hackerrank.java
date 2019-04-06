package com.bipin.practice.hackerrank.wcode35.test;

import java.util.Scanner;

public class Jan_26_Hackerrank {

	static int arrayAndQueries(int[] A, int[][] queries) {
		int count = 0;
		int mod = 1000000007;
		for (int i = 0; i < queries.length; i++) {

		}
		return 0;
	}

	static int getSubsequences(int[] A) {
		int seq_count = 1;
		for (int i = 1; i < A.length; i++) {
			int diff = getMod(A[i] - A[i - 1]);
			if (diff == 1) {

			} else {
				seq_count++;
			}
		}
		return seq_count;
	}

	static int getMod(int n) {
		return (n < 0) ? -n : n;
	}

	public static void main1(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}
		int q = in.nextInt();
		int[][] queries = new int[q][2];
		for (int queries_i = 0; queries_i < q; queries_i++) {
			for (int queries_j = 0; queries_j < 2; queries_j++) {
				queries[queries_i][queries_j] = in.nextInt();
			}
		}
		int result = arrayAndQueries(A, queries);
		System.out.println(result);
		in.close();
	}

	public static void main(String[] args) {
		int A[] = {1,2,3,4,3,5};
		System.out.println(getSubsequences(A));
	}
}
