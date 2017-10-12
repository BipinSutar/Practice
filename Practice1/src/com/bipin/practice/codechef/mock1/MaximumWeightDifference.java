package com.bipin.practice.codechef.mock1;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumWeightDifference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int data[];
		for (int i = 0; i < T; i++) {
			data = new int[sc.nextInt()];
			int k = sc.nextInt();
			for (int j = 0; j < data.length; j++) {
				data[j] = sc.nextInt();
			}
			int ans = getMaxDiff(data, data.length, k);
			System.out.println(ans);
		}

	}

	private static int getMaxDiff(int[] data, int length, int k) {
		Arrays.sort(data);
		int sum = 0;
		
		for (int i = 0; i < k; i++) {
			sum += data[i];
		}
		for (int i = k; i < length; i++) {
			sum -= data[i];
		}
		return Math.abs(sum);
	}
}