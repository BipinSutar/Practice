package com.bipin.practice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WayTooLongWords_A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			sb.append(convertToShortString(input)).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	public static String convertToShortString(String input) {
		int length = input.length();
		if (length <= 10) {
			return input;
		}
		return input.charAt(0) + "" + (length - 2) + "" + input.charAt(length - 1) + "";

	}

}
