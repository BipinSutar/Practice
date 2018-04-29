package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CielAndReceipt_CIELRCPT {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			System.out.println(intToMinimumdishes(Integer.parseInt(br.readLine().trim())));
		}

	}

	public static int intToMinimumdishes(int num) {

		int times = 0;

		int[] ints = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048 };
		for (int i = ints.length - 1; i >= 0; i--) {
			int div = num / ints[i];
			if (div > 0) {
				times += div;
				num %= ints[i];
			}
		}
		return times;
	}
}
