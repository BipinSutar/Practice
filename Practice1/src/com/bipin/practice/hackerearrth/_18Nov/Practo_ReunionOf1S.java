package com.bipin.practice.hackerearrth._18Nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practo_ReunionOf1S {
	private static ArrayList<Integer> indexs = new ArrayList<>();

	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
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
		int k = fs.nextInt();
		String line = fs.nextLine();
		init(line, n);
		while (k-- > 0) {
			int q_type = fs.nextInt();
			if (q_type == 1)
				System.out.println(getMaxLength(n));
			else if (q_type == 2)
				add(fs.nextInt());

		}

	}

	private static void init(String line, int n) {
		for (int i = 0; i < n; i++) {
			if (line.charAt(i) == '1')
				add(i + 1);
		}
	}

	private static void add(int x) {

		int pos = Collections.binarySearch(indexs, x);
		if (pos < 0) {
			indexs.add(-pos - 1, x);
		}

	}

	private static int getMaxLength(int n) {
		int count = 0, ans = 0;
		int len = indexs.size();
		if (len == 1)
			return 1;
		// for (int i : indexs) {
		// System.out.print(i + " ");
		// }
		// System.out.println("\nPrint done");
		for (int i = 1; i < len; i++) {
			if (indexs.get(i) - indexs.get(i - 1) == 1) {
				count++;
				if (i == len - 1)
					count++;
			} else {
				ans = max(ans, ++count);
				count = 0;
			}

		}
		return max(ans, count);

	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
