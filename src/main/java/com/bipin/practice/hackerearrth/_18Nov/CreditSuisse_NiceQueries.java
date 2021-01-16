package com.bipin.practice.hackerearrth._18Nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CreditSuisse_NiceQueries {
	public static ArrayList<Integer> al = new ArrayList<Integer>();
	public static int[] al_d = new int[0];
	public static int max = Integer.MIN_VALUE;

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
		int n = fs.nextInt() / 100;
		int data[] = new int[n];
		int q = fs.nextInt();
		for (int i = 0; i < q; i++) {
			int q_type = fs.nextInt();
			int k = fs.nextInt();
			if (q_type == 1) {
				// solveQ_Type1_v1(k);
				solveQ_Type1_v2(k);
			} else {
				// System.out.println(getIndexForQ2(data, k - 1));
				// getIndexForQ2(data, k - 1);
				// System.out.println(binarySearchFirst(data, -1, k - 1, data.length));
				// binarySearchFirst(data, -1, k - 1, data.length - 1);
				System.out.println(solveQ_Type2_v1(k));
			}
		}

	}

	public static int getIndexForQ2(int[] data, int index) {

		for (int i = index; i < data.length; i++) {
			if (data[i] == -1) {
				return i + 1;
			}
		}

		return -1;
	}

	public static int binarySearchFirst(int A[], int v, int lo, int hi) {
		int mid = (lo + hi) / 2;
		if ((A[mid] == v) && (mid == 0 | A[mid - 1] == 0))
			return mid + 1;
		if (lo >= hi) {
			return -1;
		}
		if (A[mid] > v)
			return binarySearchFirst(A, v, lo, mid - 1);
		else
			return binarySearchFirst(A, v, mid + 1, hi);
	}

	public static void solveQ_Type1_v1(int k) {
		if (k > max) {
			max = k;
		}
		int pos = Collections.binarySearch(al, k);
		if (pos < 0) {
			// System.out.println(-pos - 1);
			al.add(-pos - 1, k);
		}
	}

	public static void solveQ_Type1_v2(int k) {
		if (k > max) {
			max = k;
		}
		int pos = Collections.binarySearch(al, k);

		if (pos < 0) {
			al.add(-pos - 1, k);
			int al_d1[] = new int[al_d.length + 1];
			pos *= -1;
			//System.out.println("pos -1 = " + (pos - 1) + " pos=" + pos);
			if (al_d1.length == 1) {
				al_d1[0] = k;
			} else if (al_d1.length == 2) {
				if (pos - 1 == 1) {
					al_d1[0] = al_d[0];
					al_d1[1] = k;
				} else {
					al_d1[1] = al_d[0];
					al_d1[0] = k;
				}
			} else {
				arraycopy(0, pos - 1, al_d1);
				al_d1[pos - 1] = k;
				arraycopy1(pos, al_d1.length - 1, al_d1);

			}
			// for (int i : al_d1) {
			// System.err.print(i + " ");
			// }
			// System.err.println();
			al_d = al_d1;
		}
	}

	private static void arraycopy(int start, int end, int[] al_d1) {
		for (int i = start; i < end; i++) {
			al_d1[i] = al_d[i];
		}
	}

	private static void arraycopy1(int start, int end, int[] al_d1) {
		for (int i = start; i <= end; i++) {
			al_d1[i] = al_d[i - 1];
		}
	}

	public static int solveQ_Type2_v1(int k) {
		if (k > max)
			return -1;
		else if (k == max)
			return max;

		int pos = Collections.binarySearch(al, k);
		if (pos < 0) {
			// System.out.println(pos);
			// return al.get(((pos) * -1) - 1);

			// return al.get((-pos - 1));
			return al_d[-pos - 1];
		} else {
			// return al.get(pos);
			return al_d[pos];
		}
	}
}
