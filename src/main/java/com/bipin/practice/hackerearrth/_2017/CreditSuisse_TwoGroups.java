package com.bipin.practice.hackerearrth._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class CreditSuisse_TwoGroups {
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

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

	public static void main(String[] args) {
		dod();
		FastReader fs = new FastReader();
		long t = 1;// fs.nextLong();
		while (t-- > 0) {
			long n = fs.nextLong();
			long t1 = System.currentTimeMillis();
			// System.out.println(power1(n));
			long t2 = System.currentTimeMillis();
			// System.out.println((t2 - t1) / 1000);
			System.out.println(power2(n));

		}

	}

	public static long power1(long y) {
		long res = 1; // Initialize result
		int a = 1000000000;
		for (int i = 1; i < y + 1; i++) {
			res = (res << 1) % 1000000007;
		}
		return (res - 2) % 1000000007;
	}

	public static long power2(long n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 0;
		if (n < 0)
			return 0;
		long ret = 1;
		long a = 2;
		long MODULO = 1000000007;
		while (n > 0) {
			if (n % 2 != 0)
				ret = ret * a % MODULO;
			a = a * a % MODULO;
			n >>= 1;
			// System.out.println("n= " + n + " a =" + a + " ret=" + ret);
		}
		return (ret - 2);// % MODULO;
	}
	public static void dod() {
		String s = "hackerearth hackthons";
		StringTokenizer st = new StringTokenizer(s, "h");
		while (st.hasMoreElements()) {
			System.out.print(st.nextToken());
		}
		double a = 290.05;
		int b = 100;
		byte c = (byte) a;
		byte d = (byte) b;
		System.out.println(c + " " + d);
		Stack sa = new Stack<>();
		sa.push("h");
		sa.push("s");
		System.out.println(sa + " " + sa.search("z"));
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(7, 4, 10, 3, 17));
		Stream<Integer> myStream = al.stream();
		Stream<Integer> myVals = al.stream().sorted().filter((n) -> n % 2 == 1);
		myVals = al.stream().filter((n) -> n % 2 == 1).filter((n) -> n > 5);
		myVals.forEach((n)-> System.out.print(n+ " "));
	}
}
