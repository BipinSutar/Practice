package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tokopedia_22Apr {
	static long[] powerof4;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		build();
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			sb.append(diskGame(br.readLine()) + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	public static String diskGame(String M) {
		long a = Long.parseLong(M);
		long count = 0L;
		boolean flag = false;// RK

		// a = a / 4L;
		long temp = a;
		for (int i = powerof4.length - 1; i >= 0; i--) {
			temp = a / powerof4[i];
			if (temp > 0) {
				a = temp;
				count = a % powerof4[i];
				flag = flip(flag);
				// break;
			} else
				break;
		}

		if (a % 2 == 1) {
			flag = flip(flag);
		}
		while (count > 0) {
			count--;
			flag = flip(flag);
		}
		String ans = flag ? "RK" : "Nakul";
		return ans;
	}

	static void build() {

		powerof4 = new long[27];
		for (int i = 0; i < 27; i++) {
			powerof4[i] = power(4, i);

		}

	}

	public static boolean flip(boolean a) {
		return !a;
	}

	static long power(int a, int b) {
		if (b == 0)
			return 1;
		if (b % 2 == 0) {
			long y = power(a, b / 2);
			return y * y;
		} else
			return a * power(a, b - 1);
	}
}
