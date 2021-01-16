package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TerribleMathematics_BADMATH {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			String line[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(line[0].trim());
			int m = Integer.parseInt(line[1].trim());
			String s = br.readLine();
			sb.append(getNumberOfWays(n, m, s) + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	public static int getNumberOfWays(int n, int m, String s) {
		int ans = 0;
		Set<Integer> dashPos = new LinkedHashSet<>();
		BigInteger zero = new BigInteger(0 + "");
		BigInteger bm = new BigInteger(m + "");
		for (int i = 0; i < n; i++) {
			if ('_' == s.charAt(i)) {
				dashPos.add(i);
			}
		}
		Set<String> combos = getCombos(dashPos.size());
		for (String comb : combos) {
			StringBuilder a = new StringBuilder();
			int dashPosition = 0;
			for (int i = 0; i < s.length(); i++) {
				if (dashPos.contains(i)) {
					a.append(comb.charAt(dashPosition));
					dashPosition++;
				} else {
					a.append(s.charAt(i));
				}
			}
			// long num = Long.parseLong(a.toString(), 2);
			// ans = num % m == 0 ? ans + 1 : ans;
			BigInteger thousand = new BigInteger(a.toString(), 2);
			ans = thousand.mod(bm).equals(zero) ? ans + 1 : ans;

		}
		return ans;
	}
	public static Set<String> getCombos(int n) {
		Set<String> s = new HashSet<>();
		int rows = (int) Math.pow(2, n);
		for (int i = 0; i < rows; i++) {
			String t = "";
			for (int j = n - 1; j >= 0; j--) {
				t = t + ((i / (int) Math.pow(2, j)) % 2 + "");
			}
			s.add(t);
		}

		return s;
	}

}
