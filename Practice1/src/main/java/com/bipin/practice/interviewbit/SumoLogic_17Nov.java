package com.bipin.practice.interviewbit;

import java.util.HashMap;
import java.util.Map;

public class SumoLogic_17Nov {

	public static void main(String[] args) {
		getprime(new int[] {});
	}

	public static int getproductsOfLengthsSpecialSubstring1(String s) {
		long prod = 1;
		final int mod = 1000000000 + 7;
		Map<String, Integer> specialString = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String sub = s.substring(i, j);
				if (specialString.containsKey(sub)) {
					prod = (prod * specialString.get(sub)) % mod;
				} else if (s.startsWith(sub)) {
					prod = (prod * sub.length()) % mod;
					specialString.put(sub, sub.length());
				}
			}
		}
		prod = prod % mod;
		return (int) prod;
	}

	public static int getproductsOfLengthsSpecialSubstring(String s) {
		long prod = 1;
		final int mod = 1000000000 + 7;
		char cs[] = s.toCharArray();
		for (int i = 1; i <= cs.length; i++) {
			prod = (prod * i) % mod;
		}
		for (int i = 1; i < cs.length; i++) {
			if (cs[i] == cs[0]) {
				int in = 1;
				for (int k = i + 1; k < cs.length; k++) {
					if (cs[k] == cs[in]) {
						prod = (prod * (in + 1)) % mod;
					} else {
						break;
					}
					in++;
				}
			}
		}
		return (int) (prod % mod);
	}

	public static int getMaxChocklets(int n, int m, int x, int y) {
		// n in no of magical candies
		// m is no of initial amount
		// x is amount to exchange candy with chocklate
		// y is amount to sell candy

		long maxChocks = -1;
		for (int i = n; i >= 0; i--) {
			int ans = n - i;
			long amount = m + (ans * y);
			if (i + ans == (amount / x)) {
				return i;
			}

		}
		return (int) maxChocks;
	}

	public static long max(long a, long b) {
		return a > b ? a : b;
	}

	public static long min(long a, long b) {
		return a < b ? a : b;
	}

	public static int getprime(int A[]) {
		primeNoGen1(1_000_000_000);
		return 0;
	}

	private static void primeNoGen1(int n) {
		int count = 0;
		for (int i = 2; i < n; i++) {
			boolean flag = true;
			int var = (int) Math.sqrt(i);
			for (int j = 2; j <= var; j = j + 1) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				count++;
			}
		}
		System.out.println(count);

	}
}
