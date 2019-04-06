package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _05_Jan_Cogoport {
	public class FastReader {
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

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
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

	public static void mainmainKilljeeAndClosestNumber(String[] args) {
		FastReader fs = new _05_Jan_Cogoport().new FastReader();
		int n = fs.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = fs.nextInt();
		}
		int q = fs.nextInt();
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			int type = fs.nextInt();
			if (type == 1) {
				arr[fs.nextInt() - 1] = fs.nextInt();
			} else {
				int L = fs.nextInt() - 1;
				int R = fs.nextInt() - 1;
				int p = fs.nextInt();
				int op_min = Integer.MAX_VALUE, ans = -1;
				boolean found = false;
				for (int i = L; i <= R; i++) {
					if (arr[i] > p) {
						int op = arr[i] - p;
						if (op < op_min) {
							op_min = op;
							ans = arr[i];
							found = true;
						}

					}
				}
				if (found)
					sb.append(ans + "\n");
				else
					sb.append("-1\n");

			}
		}
		System.out.print(sb.toString());
	}

	public static void mainKilljeeAndClosestNumberRegression(String[] args) {// Killjee and closest number regression
																				// testing
		FastReader fs = new _05_Jan_Cogoport().new FastReader();
		int n = 100000;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) Math.random() * 10;
		}
		long o = System.currentTimeMillis();
		int q = 100000;
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			int type = fs.nextInt();
			if (type == 1) {
				;// arr[fs.nextInt() - 1] = fs.nextInt();
			} else {
				int L = 1 - 1;
				int R = n - 1;
				int p = (int) Math.random() * 10;
				int op_min = Integer.MAX_VALUE, ans = -1;
				boolean found = false;
				for (int i = L; i <= R; i++) {
					if (arr[i] > p) {
						int op = arr[i] - p;
						if (op < op_min) {
							op_min = op;
							ans = arr[i];
							found = true;
						}

					}
				}
				if (found)
					sb.append(ans + "\n");
				else
					sb.append("-1\n");

			}
		}
		System.out.print(sb.toString());
		long o1 = System.currentTimeMillis();
		System.out.println(o1 - o);
	}

	public static void main(String[] args) {
		// SubString("1110");
		// SubString("1101");
		// SubString("1011");
		// SubString("1100");
		// SubString("1001");
		// SubString("1000");
		// SubString("1010");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100000; i++) {
			sb.append("1001001001");
		}
		// System.out.println("start " + sb.length());
		long o = System.currentTimeMillis();
		// SubString(sb.toString());
		SubString("10011100100");
		long o1 = System.currentTimeMillis();
		System.out.println("Time taken " + (o1 - o));
	}

	public static void SubString(String str) {
		long count = 0;
		int n = str.length();
		int countby = 0;
		// System.out.println("n is " + n);
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '1') {
				for (int j = i + 1; j <= n; j++) {
					count = (count + 1) ;
					countby++;
				}
				// System.out.println("Count by " + i + " = " + countby);
				countby = 0;
			}
		}
		System.out.println("1.Total count " + count);
		count = 0;
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '1') {
				count = count + (n - i);
			}
		}
		System.out.println("2.Total count " + count);
	}
}
