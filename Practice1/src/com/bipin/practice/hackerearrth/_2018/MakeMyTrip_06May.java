package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeMyTrip_06May {

	public static void mainPoisonusGas(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int data[] = new int[n];
			String line[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				data[i] = Integer.parseInt(line[i]);
			}
			long sum = 0;
			int negMax = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				if (data[i] < 0) {
					negMax = max(negMax, data[i]);
				} else {
					sum += data[i];
				}
			}
			if (sum == 0) {
				sum = negMax;
			}
			sb.append(isPower2(sum) ? "Yes" : "No").append("\n");

		}
		System.out.println(sb.toString());
	}

	private static boolean isPower2(long n) {
		if (n < 0)
			return false;
		while (n != 1) {
			if ((n & 1) == 1)
				return false;// odd num
			n = n / 2;
		}
		return true;
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line[] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int q = Integer.parseInt(line[1]);
		long data[] = new long[n];
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			line = br.readLine().trim().split(" ");
			int type = Integer.parseInt(line[0]);
			switch (type) {
			case 1:
				int pos = Integer.parseInt(line[1]) - 1;
				data[pos] = 2 * data[pos] + 1L;
				break;
			case 2:
				pos = Integer.parseInt(line[1]) - 1;
				data[pos] = (int) Math.floor(data[pos] / 2);
				break;

			case 3:
				int x = Integer.parseInt(line[1]) - 1;
				int y = Integer.parseInt(line[2]) - 1;
				sb.append(getnoOne(x, y, data)).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}

	public static int getnoOne(int start, int end, long data[]) {
		int count = 0;
		if (end == data.length) {
			end = data.length - 1;
		}
		for (int i = start; i <= end; i++) {
			count = count + count_1s_in_Num(data[i]);
		}

		return count;

	}

	static int count_1s_in_Num(long num) {
		// int count = 0;
		// while (num != 0) {
		// num = num & (num - 1);
		// count++;
		// }
		// return count;
		int oneCount = ((num & 1) == 1) ? 1 : 0;
		while (num != 0) {
			if ((num & 1) == 1)
				++oneCount;
			num = num >> 1;
		}
		return oneCount / 2;
	}
}
