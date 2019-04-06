package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Lapindromes_LAPIN {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			System.out.println(isLapindrome(br.readLine()) ? "YES" : "NO");
		}
		br.close();
	}

	public static boolean isLapindrome(String s) {
		boolean islapindrome = true;
		int mid = s.length() / 2;
		//System.out.println(mid);
		Map<Character, Integer> pre = new HashMap();
		Map<Character, Integer> post = new HashMap();

		for (int i = 0; i < mid; i++) {
			char ch = s.charAt(i);
			if (pre.containsKey(ch))
				pre.put(ch, pre.get(ch) + 1);
			else
				pre.put(ch, 1);

		}
		if (s.length() % 2 != 0)
			mid++;
		for (int i = mid; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (post.containsKey(ch))
				post.put(ch, post.get(ch) + 1);
			else
				post.put(ch, 1);
		}
		for (char ch : pre.keySet()) {
			if (pre.get(ch) != post.get(ch)) {
				islapindrome = false;
				break;
			}
		}
		return islapindrome;

	}

}
