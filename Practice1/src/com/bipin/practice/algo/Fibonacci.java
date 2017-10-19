package com.bipin.practice.algo;

public class Fibonacci {
	private static final int NIL = -1;
	private static final int MAX = 100;
	private static int lookup[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		long start = System.currentTimeMillis();
		System.out.println(fibogenRecur(40));
		long end1 = System.currentTimeMillis();
		System.out.println((end1 - start) / 1000.0);
		System.out.println(fibogenRecurUsingDynamicPrograming(40));
		System.out.println((System.currentTimeMillis() - end1) / 1000.0);
	}

	public static void init() {
		lookup = new int[MAX];
		for (int i = 0; i < MAX; i++) {
			lookup[i] = NIL;
		}
	}

	public static void fibogen(int n) {
		int a = 0, b = 0, c = 1;
		for (int i = 0; i <= n; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.print(c + " ");

		}
	}

	public static int fibogenRecur(int n) {
		if (n <= 1)
			return n;
		else
			return fibogenRecur(n - 1) + fibogenRecur(n - 2);
	}

	public static int fibogenRecurUsingDynamicPrograming(int n) {
		if (lookup[n] == NIL) {
			if (n <= 1)
				lookup[n] = n;
			else
				lookup[n] = fibogenRecurUsingDynamicPrograming(n - 1) + fibogenRecurUsingDynamicPrograming(n - 2);
		}
		return lookup[n];
	}
}
