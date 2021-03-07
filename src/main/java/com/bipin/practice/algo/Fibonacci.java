package com.bipin.practice.algo;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	private static final int NIL = -1;
	private static final int MAX = 1000;
	private static int lookup[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		long start = System.currentTimeMillis();
		System.out.println(fibogenRecur(40));
		long end1 = System.currentTimeMillis();
		System.out.println((end1 - start) / 1000.0);
		System.out.println(fibogenRecurUsingDynamicPrograming(6));
		System.out.println(fibogenRecurUsingDynamicPrograming(6, new HashMap<>()));
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

	public static int fibogenRecurUsingDynamicPrograming(int n, Map<Integer, Integer> memo) {
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		if (n <= 2) {
			memo.put(n, 1);
			return memo.get(n);
		}
		int ans = fibogenRecurUsingDynamicPrograming(n - 1, memo) + fibogenRecurUsingDynamicPrograming(n - 2, memo);
		memo.put(n, ans);
		return memo.get(n);
	}
}
