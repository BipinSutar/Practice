package com.bipin.practice.hackerearrth._18Nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BuyHatkeArchitectsDilemma {
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
	}

	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int n = fs.nextInt();
		int w = fs.nextInt();
		int[] work = new int[n];
		for (int i = 0; i < n; i++) {
			work[i] = fs.nextInt();
		}
		System.out.println(solve(work, w, n));
	}

	private static int solve(int[] data, int w, int n) {
		int count = 0;
		// int data[] = work;
		Arrays.sort(data);
		int max = data[n - 1];
		int first_pos_of_max = binarySearchFirst(data, max, 0, n - 1);
		int last_pos_of_max = n - 1;
		count = count + last_pos_of_max - first_pos_of_max + 1;
		System.out.println("count= " + count + " first_pos_of_max " + first_pos_of_max);
		for (int i = first_pos_of_max - 1; i > -1; i--) {
			// w=w-data[i];
			int need = max - data[i];
			System.out.println("have=" + w + " need=" + need);
			if (w >= need) {
				w = w - need;
				count++;
			} else
				break;
			// } else if (w < need) {
			// break;
			// }
		}
		return count;
	}

	public static int binarySearchFirst(int A[], int v, int lo, int hi) {
		int mid = (lo + hi) / 2;
		if (mid == 1 && A[0] == v)
			return 0;
		if ((A[mid] == v) && (mid == 0 | A[mid - 1] < v))
			return mid;
		if (lo >= hi)
			return -1;
		if (A[mid] > v)
			return binarySearchFirst(A, v, lo, mid - 1);
		else
			return binarySearchFirst(A, v, mid + 1, hi);
	}

	public static int binarySearchLast(int[] A, int v, int lo, int hi) {
		int mid = (lo + hi) / 2;
		if ((A[mid] == v) && (mid == A.length - 1 || A[mid + 1] > v))
			return mid;
		if (lo >= hi)
			return -1;
		if (A[mid] > v)
			return binarySearchLast(A, v, lo, mid - 1);
		else
			return binarySearchLast(A, v, mid + 1, hi);
	}
}
