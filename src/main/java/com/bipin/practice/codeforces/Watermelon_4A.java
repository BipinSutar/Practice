package com.bipin.practice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Watermelon_4A {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(br.readLine());
		if (((w & 1) == 0) && w > 2) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		br.close();
	}
}