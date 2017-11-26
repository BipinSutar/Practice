package com.bipin.practice.hackerrank.codiva_25_nov.test;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MiniMaxiQueries {
	private static int[] data;

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int buffer_pointer, bytesRead;

		Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			buffer_pointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte buf[] = new byte[64];
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		private byte read() throws IOException {
			if (buffer_pointer == bytesRead)
				fillBuffer();
			return buffer[buffer_pointer++];
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, buffer_pointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
	}

	public static void main1(String[] args) throws IOException {
		Reader fs = new Reader();
		int n = fs.nextInt();
		data = new int[n];
		int q = fs.nextInt();
		while (q-- > 0) {
			int query_type = fs.nextInt();
			int l = fs.nextInt() - 1;
			int r = fs.nextInt() - 1;
			if (query_type == 1)
				modify_data(l, r, n, fs.nextInt());
			else if (query_type == 2)
				System.out.println(getDistanceMin(l, r, n));
			else if (query_type == 3)
				System.out.println(getDistanceMax(l, r, n));
		}

	}

	public static void main(String[] args) {
		System.out.println(getDistanceMax(1, 6, 8));
		System.out.println(getDistanceMin(1, 6, 8));
	}

	private static int getDistanceMin(int l, int r, int n) {
		int ans = 0;
		int left_one_max = 0;
		int right_one_max = 0;
		boolean flag1 = false, flag2 = false;
		int data1[] = { 1, 2, 1, 1, 2, 1, 1, 0 };
		// for (int i : data) {
		// System.out.print(i + " ");
		// }
		// System.out.println();
		for (int i = l, j = r; i <= r; i++) {
			if (i != n && (j >= i)) {
				if (data1[i] == 1) {
					left_one_max = i;
				}
				if (data1[j] == 1) {// (n - 1 - i) <= r &&

					right_one_max = j;

				}
				j--;

			}

		}
		Arrays.sort(data);
		if (right_one_max == left_one_max)
			ans = -1;
		else if (right_one_max < left_one_max)
			ans = -1;
		else {
			ans = Math.abs(right_one_max - left_one_max);
		}
		// System.out.println("left_one_max " + left_one_max + " right_one_max " +
		// right_one_max);
		return ans;

	}

	private static int getDistanceMax(int l, int r, int n) {
		int ans = 0;
		int left_one_max = 0;
		int right_one_max = 0;
		boolean flag1 = false, flag2 = false;
		int data1[] = { 1, 2, 1, 1, 2, 1, 1, 0 };
		// for (int i : data) {
		// System.out.print(i + " ");
		// }
		// System.out.println();
		for (int i = l; i <= r; i++) {
			if (i != n) {
				if (data1[i] == 1 && !flag1) {
					left_one_max = i;
					flag1 = true;
				}
				if ((n - 1 - i) <= r && data1[n - 1 - i] == 1 && !flag2) {
					right_one_max = n - 1 - i;
					flag2 = true;
				}
				if (flag1 && flag2)
					break;

			}

		}
		if (right_one_max == left_one_max)
			ans = -1;
		else if (right_one_max < left_one_max)
			ans = -1;
		else {
			ans = Math.abs(right_one_max - left_one_max);
		}
		// System.out.println("left_one_max " + left_one_max + " right_one_max " +
		// right_one_max);
		return ans;
	}

	private static void modify_data(int l, int r, int n, int val) {
		for (int i = l; i <= r; i++) {
			if (i != n) {
				data[i] ^= val;
			}
		}
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
