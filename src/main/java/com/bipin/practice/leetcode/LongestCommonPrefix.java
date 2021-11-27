package com.bipin.practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonPrefix {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] { "dogggg", "doggg", "dogg","d" }));
		br.close();

	}

	public String longestCommonPrefix(String[] strs) {

		StringBuilder max_prefix = new StringBuilder("");
		if (strs.length == 0) {
			return max_prefix.toString();
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String curr = strs[0];
		String next = strs[1];
		int min_len = min(curr.length(), next.length());

		for (int j = 0; j < min_len; j++) {
			if (curr.charAt(j) == next.charAt(j)) {
				max_prefix.append(curr.charAt(j));
			} else {
				break;
			}
		}

		for (int i = 2; i < strs.length; i++) {
			curr = strs[i];
			if (curr.length() < max_prefix.length()) {
				max_prefix = new StringBuilder(max_prefix.substring(0, curr.length()));
			}
			min_len = min(curr.length(), max_prefix.length());
			for (int j = 0; j < min_len; j++) {
				if (curr.charAt(j) != max_prefix.charAt(j)) {
					max_prefix = new StringBuilder(max_prefix.substring(0, j));
					break;
				}
			}

		}
		return max_prefix.toString();

	}

	public int min(int a, int b) {
		return a < b ? a : b;
	}

}
