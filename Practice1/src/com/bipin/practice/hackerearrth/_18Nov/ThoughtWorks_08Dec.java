package com.bipin.practice.hackerearrth._18Nov;

import java.util.Scanner;

public class ThoughtWorks_08Dec {
	public static void main(String[] args) {// mainsubstring
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		int q = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int in_len = in.length();
		while (q-- > 0) {
			long num = sc.nextLong();
			long maxper = (in_len * (in_len + 1)) / 2;
			if (num > maxper) {
				sb.append("-1" + "\n");
				continue;
			}

			sb.append(substring(in, in_len, num) + "\n");

		}
		// System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
		sc.close();

	}

	public static String substring(String in, int in_len, long num) {
		int mod = 0, div = 0;
		if (num % in_len == 0) {

		}
		System.out.print("div " + div + " mod " + mod);
		String ans = in.substring(div, mod);
		System.out.println("ans " + ans);
		return ans;
	}
}
