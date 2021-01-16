package com.bipin.practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumAddtoMakeParenthesesValid {
	private static Character PARANTHESIS_TYPE = '{';

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			String s = br.readLine();
			// sb.append(minAddToMakeValid(s) + "\n");
			sb.append(minAddToMakeValidForDoubleRightParanthesis(s) + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	public static int minAddToMakeValid(String S) {
		int ans = 0, bal = 0;
		for (int i = 0; i < S.length(); ++i) {
			char c = S.charAt(i);
			bal += c == PARANTHESIS_TYPE ? 1 : -1;
			// It is guaranteed bal >= -1
			if (bal == -1) {
				ans++;
				bal++;
			}
		}

		return ans + bal;
	}
	public static int minAddToMakeValidForDoubleRightParanthesis(String S) {
		int ans = 0, bal = 0;
		for (int i = 0; i < S.length(); ++i) {
			char c = S.charAt(i);
			switch (c) {
				case '{' :
					if (bal % 2 == 0) {
						bal += 2;
					} else {
						ans++;
						bal++;
					}
					break;
				case '}' :
					bal--;
					break;
			}
			if (bal == -1) {
				if (i == S.length() - 1) {
					ans = ans + 2;
				} else if (S.charAt(i + 1) == '}') {
					ans = ans + 1;
					i++;
				} else {
					ans = ans + 2;
				}
				bal++;

			}

		}

		return ans + bal;
	}
}
