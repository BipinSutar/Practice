package com.bipin.practice.hackerearrth._2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Pramata_04May {

	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		String line[] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		char[][] A = new char[n][m];
		for (int i_A = 0; i_A < n; i_A++) {
			String[] arr_A = br.readLine().split(" ");
			for (int j_A = 0; j_A < arr_A.length; j_A++) {
				A[i_A][j_A] = arr_A[j_A].charAt(0);
			}
		}

		String out_ = getEasyMatrixPath(A);
		System.out.println(out_);

		wr.close();
		br.close();
	}
	public static String getEasyMatrixPath(char matrix[][]) {
		StringBuilder path1 = new StringBuilder();
		StringBuilder path2 = new StringBuilder();
		path1.append(matrix[0][0]);
		path2.append(matrix[0][0]);
		for (int row = 1; row < matrix.length; row++) {
			for (int col = 1; col < matrix[row].length; col++) {
				if (row == col) {
					path1.append(matrix[row - 1][col]);
					path1.append(matrix[row][col]);

				} else if (row == matrix.length - 1 && col > row) {
					path1.append(matrix[row][col]);
				} else if (col == matrix.length - 1 && row > col) {
					path1.append(matrix[row][col]);
				}
			}
		}
		for (int row = 1; row < matrix.length; row++) {
			for (int col = 1; col < matrix[row].length; col++) {
				if (row == col) {
					path2.append(matrix[row][col - 1]);
					path2.append(matrix[row][col]);
				} else if (row == matrix.length - 1 && col > row) {
					path2.append(matrix[row][col]);
				} else if (col == matrix.length - 1 && row > col) {
					path2.append(matrix[row][col]);
				}
			}
		}
		String p1 = sortString(path1);
		String p2 = sortString(path2);

		return p1.compareTo(p2) > 0 ? p2 : p1;
	}
	private static String sortString(StringBuilder sb) {
		char tempAr[] = new char[sb.length()];
		for (int i = 0; i < tempAr.length; i++) {
			tempAr[i] = sb.charAt(i);
		}
		Arrays.sort(tempAr);
		sb = new StringBuilder();
		for (int i = 0; i < tempAr.length; i++) {
			sb.append(tempAr[i]);
		}
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			int N = Integer.parseInt(br.readLine().trim());
			long K = Long.parseLong(br.readLine().trim());
			String[] arr_A = br.readLine().split(" ");
			long[] A = new long[N];
			for (int i_A = 0; i_A < arr_A.length; i_A++) {
				A[i_A] = Long.parseLong(arr_A[i_A]);
			}

			long out_ = fun(A, K);
			System.out.println(out_);
		}

		wr.close();
		br.close();
	}
	static long fun(long[] set, long k) {
		int n = set.length;
		long a = 0;
		long b = 0;
		long c = 0;
		int mod = 1000_000_007;
		for (int i = 0; i < (1 << n); i++) {
			long xor = 0;
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {

				if ((i & (1 << j)) > 0) {
					sb.append(set[j]).append(" ");
				}
			}
			if (sb.length() > 0) {
				String line[] = sb.toString().split(" ");
				xor = Long.parseLong(line[0]);
				for (int j = 1; j < line.length; j++) {
					xor = xor ^ Long.parseLong(line[j]);

				}
			}

			if (xor < k) {
				a++;
			} else if (xor == k) {
				b++;
			} else {
				c++;
			}
		}

		long sum = (a + b + c);
		sum = ((sum) % mod * (sum) % mod) % mod;
		return sum;

	}
}