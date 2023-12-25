package com.bipin.practice.hackerearrth._2021;

import java.util.TreeMap;

public class GridEquation {

	public static void main(String[] args) {
		solve(4, 4);

	}

	static int solve(int n, int term) {
		int j = 1;
		int k = 1;
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		int c = 1;
		tm.put(k, c);
		while (j != n) {
			j = j + 1;
			k = k + j;
			c++;
			tm.put(k, c);
		}

		int lb = tm.floorKey(term);
		int diff = term - lb;
		int i_i = n - diff - lb;

		return 0;
	}

}
