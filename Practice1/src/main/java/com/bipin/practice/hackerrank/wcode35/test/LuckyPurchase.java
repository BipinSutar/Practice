package com.bipin.practice.hackerrank.wcode35.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class LuckyPurchase {
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));

		}

		public String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		FastReader fs = new FastReader();
		long n = fs.nextLong();
		String validprice = "-1";
		BigInteger minPrice = BigInteger.valueOf(Long.MAX_VALUE);
		for (int i = 0; i < n; i++) {
			String in = fs.nextLine();
			String insplit[] = in.split(" ");
			if (isValidPrice(insplit[1])) {
				BigInteger temp = new BigInteger(insplit[1]);
				if (minPrice.compareTo(temp) > 0) {
					minPrice = temp;
					validprice = insplit[0];
				}
			}
		}
		System.out.println(validprice);
	}

	public static boolean isValidPrice(String s) {
		int len = s.length();
		if (len % 2 != 0)
			return false;
		// len = len / 2;
		int _4_7s = 0;// new int[2];
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (ch == '4')
				_4_7s++;
			else if (ch == '7')
				_4_7s--;
			else {
				_4_7s = -1;
				break;
			}

		}
		return _4_7s == 0 ? true : false;
	}
}
