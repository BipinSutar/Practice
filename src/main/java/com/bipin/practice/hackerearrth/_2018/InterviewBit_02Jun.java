package com.bipin.practice.hackerearrth._2018;

public class InterviewBit_02Jun {
	public int[] solve1(int A, int B, int[] c, int[] d) {
		int bits[] = new int[c.length];
		for (int i = 0; i < c.length; i++) {
			bits[i] = getSetBits(c[i]);
		}

		int a[] = new int[d.length];
		for (int i_b = 0; i_b < B; i_b++) {
			int len = Integer.MAX_VALUE;
			long sum = 0;
			int p = 0;
			int k = d[i_b];
			for (int i = 0; i < c.length; i++) {

				if (sum >= k) {
					len = min(len, p);
					p = 0;
					sum = 0;

				} else {
					sum = (sum + bits[i]);
					p++;
				}
			}
			if (sum >= k) {
				len = min(len, p);
				if (p == 0)
					len = 1;
			}
			if (len == Integer.MAX_VALUE) {
				a[i_b] = -1;
			} else
				a[i_b] = len;
		}
		return a;

	}

	public int[] solve(int A, int B, int[] c, int[] d) {
		int bits[] = new int[c.length];
		for (int i = 0; i < c.length; i++) {
			bits[i] = getSetBits(c[i]);
		}

		int a[] = new int[d.length];
		for (int i_b = 0; i_b < B; i_b++) {
			int len = Integer.MAX_VALUE;
			long sum = 0;
			int p = 0;
			int k = d[i_b];
			for (int i = 0; i < c.length; i++) {
				sum = 0;
				for (int j = i; j < c.length; j++) {
					sum = sum + bits[j];
					if (sum >= k) {
						len = min(len, j - i+1);
						len = len == 0 ? 1 : len;
						break;
					}
				}
			}

			if (len == Integer.MAX_VALUE) {
				a[i_b] = -1;
			} else
				a[i_b] = len;
		}
		return a;

	}

	public int getSetBits(int n) {
		int c = 0;
		while (n > 0) {
			c += n & 1;
			n >>= 1;
		}
		return c;
	}

	public int min(int a, int b) {
		return a > b ? b : a;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		int c[] = { 1, 2, 4, 8 };
		int d[] = { 1, 2, 3 };
		int a[] = new InterviewBit_02Jun().solve(4, 3, c, d);
		for (int i : a) {
			System.out.print(i + " , ");
		}
	}
}
