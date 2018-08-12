package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThoughtWorks_04May {
	public static long powersOf3[];

	public static void mainDigitsOfNumber(String[] args) throws IOException {// Main Digits in number
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());
		long start = System.currentTimeMillis();
		buidPowerof3();
		StringBuilder sb = new StringBuilder();
		Map<Long, Integer> numdigits = new HashMap<Long, Integer>();
		while (t-- > 0) {
			long n = Long.parseLong(br.readLine().trim());
			// Random random = new Random();
			// long n = random.nextLong() + 1500045L;
			if (numdigits.containsKey(n)) {
				sb.append(numdigits.get(n) + "\n");
			} else {
				int ans = getNumberofDigits(n);
				sb.append(ans + "\n");
				numdigits.put(n, ans);
			}

		}
		// System.out.println(sb.toString());
		System.out.println((System.currentTimeMillis() - start) / 1000L);
		br.close();
	}

	public static void buidPowerof3() {
		long max = 1000_000_000_000_000_000L;

		int curr = 38;
		powersOf3 = new long[curr];
		long sum = 0;
		for (int i = 0; i < curr; i++) {
			long pow = power(3, i + 1);
			sum = sum + pow;
			// System.out.println(pow + " ~ " + sum + " ~ " + (sum >= max) + " " + (i + 1));
			powersOf3[i] = sum;
		}
	}

	static long power(int x, int y) {
		if (y == 0)
			return 1L;
		else if ((y & 1) == 0) {
			long a = power(x, y / 2);
			return a * a;
		} else {
			long a = power(x, y / 2);
			return x * a * a;
		}
	}

	public static int getNumberofDigits(long a) {
		int pos = Arrays.binarySearch(powersOf3, a);
		// System.out.println("pos " + pos);
		if (pos < 0)
			pos = -pos;
		else
			pos++;
		return pos;
	}

	public static void mainCompareStrings(String[] args) throws IOException {// mainCompareStrings
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line[] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int q = Integer.parseInt(line[1]);
		String a = br.readLine();
		String b = br.readLine();
		char ch_a[] = a.toCharArray();
		char ch_b[] = b.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean check = true;
		boolean same = false;
		int prev_i = -1;
		while (q-- > 0) {
			int i = Integer.parseInt(br.readLine().trim()) - 1;
			ch_b[i] = '1';
			if (prev_i == i) {

			} else {
				if (check) {
					same = compare(ch_a, ch_b, i);
					if (same)
						check = false;
				}
			}
			prev_i = i;
			sb.append(same ? "YES" : "NO").append("\n");
		}
		System.out.println(sb.toString());

	}

	private static boolean compare(char[] ch_a, char[] ch_b, int pos) {
		int k = 0;
		if (pos < 10) {
			pos = Integer.max(pos, ch_a.length);
		}
		while (k < pos) {
			if (ch_a[k] > ch_b[k]) {
				return false;
			} else if (ch_a[k] < ch_b[k]) {
				return true;
			}
			k++;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line[] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int q = Integer.parseInt(line[1]);
		String a = br.readLine();
		String b = br.readLine();
		char ch_a[] = a.toCharArray();
		char ch_b[] = b.toCharArray();
		StringBuilder sb = new StringBuilder();
		long a_sum = 0;
		long b_sum = 0;
		for (int i = 0; i < n; i++) {
			if (ch_a[i] == '1') {
				a_sum = a_sum + (n - i);
			}
			if (ch_b[i] == '1') {
				b_sum = b_sum + (n - i);
			}

		}
		boolean check = true;
		boolean same = false;
		while (q-- > 0) {
			int i = Integer.parseInt(br.readLine().trim()) - 1;

			if (check) {
				if (ch_b[i] == '0') {
					b_sum = b_sum + (n - i);
					ch_b[i] = '1';
				}
				if (b_sum >= a_sum)
					same = true;
				if (same)
					check = false;

			}

			sb.append(same ? "YES" : "NO").append("\n");
		}
		System.out.println(sb.toString());

	}

}
