package com.bipin.practice.hackarrank._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class OrderStrings {
	// final long g=123456789012345678901234567890L;

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
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
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
		int n = fs.nextInt();
		String coldata[] = new String[n];
		for (int i = 0; i < n; i++) {
			coldata[i] = fs.nextLine();
		}
		String fourth = fs.nextLine();
		String fourthsplit[] = fourth.split(" ");

		int key = Integer.parseInt(fourthsplit[0]) - 1;
		boolean reverse = Boolean.parseBoolean(fourthsplit[1]);
		int sorttype = fourthsplit[2].equals("lexicographic") ? 1 : 0;
		if (sorttype == 1) {
			OrderStringSortLexo(n, coldata, key, reverse);
		} else
			OrderStringSortNumeric(n, coldata, key, reverse);
	}

	public static void OrderStringSortLexo(int n, String coldata[], final int key, boolean reverse) {
		Arrays.sort(coldata, new Comparator<String>() {
			public int compare(String a, String b) {
				// return a[key].compareTo(b[key]);
				// return Integer.compare(Integer.parseInt(a.split(" ")[key]),
				// Integer.parseInt(b.split(" ")[key]));
				return a.split(" ")[key].compareTo(b.split(" ")[key]);
			}
		});
		if (reverse)
			displayReverse(coldata);
		else
			display(coldata);

	}

	public static void OrderStringSortNumeric(int n, String coldata[], final int key, boolean reverse) {
		Arrays.sort(coldata, new Comparator<String>() {
			public int compare(String a, String b) {
				// return a[key].compareTo(b[key]);
				// return Long.compare(Long.parseLong(a.split(" ")[key]),
				// Long.parseLong(b.split(" ")[key]));
				return new BigDecimal(a.split(" ")[key]).compareTo(new BigDecimal(b.split(" ")[key]));
			}
		});
		if (reverse)
			displayReverse(coldata);
		else
			display(coldata);
	}

	public static void display(String[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

	public static void displayReverse(String[] data) {
		for (int i = data.length - 1; i > -1; i--) {
			System.out.println(data[i]);
		}
	}

}
