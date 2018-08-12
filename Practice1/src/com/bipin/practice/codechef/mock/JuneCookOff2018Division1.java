package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JuneCookOff2018Division1 {
	private static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {// Danya and Numbers
		System.out.println(getBitWiseAnd(6, 7));
		System.out.println(getBitWiseAnd(getBitWiseAnd(6, 7), 5));
		System.out.println(getBitWiseAnd(getBitWiseAnd(6, 7), 7));
		System.out.println(getBitWiseAnd(7, 5));
		System.exit(0);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line[] = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int K = Integer.parseInt(line[2]);
		line = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(line[i]));
		}
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {

		}
		br.close();

	}

	public static int getBitWiseAnd(int a, int b) {
		return a & b;
	}

	public static int getFx(int x) {
		int ans = 0;
		int maxBitAnd = -1;
		int i = 0;
		for (i = 1; i <= x; i++) {
			maxBitAnd = getBitWiseAnd(list.get(i - 1), list.get(i));
		}
		for (; i < list.size(); i++) {
			maxBitAnd = max(maxBitAnd, getBitWiseAnd(maxBitAnd, list.get(i)));
		}
		return ans;
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

}
