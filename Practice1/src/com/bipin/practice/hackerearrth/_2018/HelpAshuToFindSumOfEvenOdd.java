package com.bipin.practice.hackerearrth._2018;

import java.util.Date;
import java.util.Scanner;

public class HelpAshuToFindSumOfEvenOdd {

	public static void main(String args[]) {
		System.exit(0);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int bit[] = new int[n + 2];
		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			long k = sc.nextLong();
			if (k % 2 == 0) {
				update(i, 1, n, bit);
			}
			arr[i] = k;
		}

		int q = sc.nextInt();
		while (q-- > 0) {
			int p = sc.nextInt();
			int y = sc.nextInt();
			long z = sc.nextInt();

			if (p == 0) {
				y -= 1;
				if (z % 2 == 0 && arr[y] % 2 != 0)
					update(y, 1, n, bit);
				else if (z % 2 != 0 && arr[y] % 2 == 0)
					update(y, -1, n, bit);
				arr[y] = z;

			} else if (p == 1) {
				z -= 1;
				y -= 1;
				System.out.println(sum((int) z, n, bit) - sum(y - 1, n, bit));
			} else {
				z -= 1;
				y -= 1;
				int w = sum((int) z, n, bit) - sum(y - 1, n, bit);
				System.out.println((z - y + 1) - w);
			}

		}
		sc.close();

	}

	public static void update(int index, int val, int n, int bit[]) {

		index += 1;
		while (index <= n) {
			bit[index] += val;
			index += index & (-index);
		}
	}

	public static int sum(int index, int n, int bit[]) {

		int s = 0;
		index += 1;
		while (index > 0) {
			s += bit[index];
			index -= index & (-index);

		}
		return s;
	}

}