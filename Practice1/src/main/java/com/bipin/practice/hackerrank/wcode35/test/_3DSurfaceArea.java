package com.bipin.practice.hackerrank.wcode35.test;

import java.util.Scanner;

public class _3DSurfaceArea {

	static int surfaceArea(int[][] a) {
		// 1
		int count1 = 0;
		int count2 = 0;
		int count3 = a.length * a[0].length * 2;
		for (int i = 0; i < a.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < a[0].length; j++) {
				if (a[j][i] > max)
					max = a[j][i];
			}
			count1 += max;
		}
		count1 = count1 * 2;
		for (int i = 0; i < a.length; i++) {
			count2 += a[i][a.length - 1];
		}
		count2 *= 2;

		return count1 + count2 + count3;
	}

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int H = in.nextInt();
		int W = in.nextInt();
		int[][] A = new int[H][W];
		for (int A_i = 0; A_i < H; A_i++) {
			for (int A_j = 0; A_j < W; A_j++) {
				A[A_i][A_j] = in.nextInt();
			}
		}
		int result = surfaceArea(A);
		System.out.println(result);
		in.close();
	}

}
