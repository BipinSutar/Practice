package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyFour_LUCKFOUR {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			String s = br.readLine().trim();
			int count4 = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '4')
					count4++;
			}
			sb.append(count4 + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
