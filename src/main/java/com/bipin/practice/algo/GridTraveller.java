package com.bipin.practice.algo;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

	public static void main(String[] args) {
		System.out.println(gridTraveller(1, 1, new HashMap<>()));
		System.out.println(gridTraveller(2, 3, new HashMap<>()));
		System.out.println(gridTraveller(3, 2, new HashMap<>()));
		System.out.println(gridTraveller(3, 3, new HashMap<>()));
		System.out.println(gridTraveller(18, 18, new HashMap<>()));
		long start = System.currentTimeMillis();
		System.out.println(gridTraveller(1000, 1000, new HashMap<>()));
		long end = System.currentTimeMillis();
		System.out.println(gridTraveller1(1000, 1000, new HashMap<>()));
		long end1 = System.currentTimeMillis();
		System.out.println((end - start) / 1000.0);
		System.out.println((end1 - end) / 1000.0);

	}

	// gridTraveller (0,1)-> 0 gridTraveller(1,0) ->1
	public static long gridTraveller(long m, long n, Map<String, Long> memo) {
		String key = m + "," + n;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		if (m == 1 && n == 1)
			return 1;
		if (m == 0 || n == 1)
			return 0;

		long ans = gridTraveller(m - 1, n, memo) + gridTraveller(m, n - 1, memo);
		memo.put(key, ans);
		return memo.get(key);
	}

	// gridTraveller (0,1)-> 0 gridTraveller(1,0) ->1
	public static long gridTraveller1(long m, long n, Map<String, Long> memo) {
		String key = m + "," + n;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		String key1 = n + "," + m;
		if (memo.containsKey(key1)) {
			return memo.get(key1);
		}
		if (m == 1 && n == 1)
			return 1;
		if (m == 0 || n == 1)
			return 0;

		long ans = gridTraveller1(m - 1, n, memo) + gridTraveller1(m, n - 1, memo);
		memo.put(key, ans);
		memo.put(key1, ans);
		return memo.get(key);
	}
}
