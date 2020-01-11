package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Capillary_21Jul_2018 {
	public Capillary_21Jul_2018() {

	}
	public static void main(String[] args) throws IOException {// main for Unit
																// Balancer
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String symbols[] = br.readLine().split(",");
		int M = symbols.length - 1;
		String data[] = new String[M];
		for (int i = 0; i < M; i++) {
			data[i] = br.readLine();
		}

		System.out.println(
				new Capillary_21Jul_2018().getUnitBalancer(symbols, data));
		br.close();
	}

	public String getUnitBalancer(String[] symbols, String[] data) {

		String tdSymbols[][] = new String[data.length][4];
		for (int i = 0; i < data.length; i++) {
			String split[] = data[i].split(" ");
			tdSymbols[i][0] = split[0];
			tdSymbols[i][1] = split[1];
			tdSymbols[i][2] = split[2];
			tdSymbols[i][3] = split[3];
		}
		String first = "";
		Arrays.sort(tdSymbols, new Comparator<String[]>() {
			public int compare(String[] a, String[] b) {
				return a[3].compareTo(b[3]);
			}
		});
		for (int i = 0; i < symbols.length; i++) {
			int pos = binarySearchAsPerFourthColumn(tdSymbols, symbols[i]);
			if (pos == -1) {
				first = symbols[i];
				break;
			}

		}
		Arrays.sort(tdSymbols, new Comparator<String[]>() {
			public int compare(String[] a, String[] b) {
				return a[0].compareTo(b[0]);
			}
		});
		String node = first;
		StringBuilder sb = new StringBuilder();
		long mul = 1;
		sb.append(mul + node);
		int count = tdSymbols.length;
		while (count-- > 0) {
			int pos = binarySearchAsPerFirstColumn(tdSymbols, node);
			if (pos > -1) {
				long l = Long.parseLong(tdSymbols[pos][2]);
				sb.append(" = " + l * mul);
				mul *= l;
				node = tdSymbols[pos][3];
				sb.append(node);
			}
		}
		return sb.toString();
	}

	public int binarySearchAsPerFirstColumn(String A[][], String v) {
		int lo = 0;
		int hi = A.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int com = A[mid][0].compareTo(v);
			if (com == 0)
				return mid;
			if (com > 0)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return -1;
	}

	public int binarySearchAsPerFourthColumn(String A[][], String v) {
		int lo = 0;
		int hi = A.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int com = A[mid][3].compareTo(v);
			if (com == 0)
				return mid;
			if (com > 0)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return -1;
	}

	public static int getOddNumberCount(int l, int y) {
		if (l % 2 == 0) {
			l = l + 1;
		}
		if (y % 2 == 0) {
			y = y - 1;
		}
		return ((y - l) / 2) + 1;
	}

	public static boolean isDivisibleByCountOfOddIntegers(int x) {
		int ans = x % getOddNumberCount(1, x);
		return ans == 0;
	}

	public static int sort2DBinaryArray(String[] data, int N, int M) {
		char[][] bin = new char[N][M];
		TreeMap<Integer, Integer> com = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			bin[i] = data[i].toCharArray();
			com.put(i, 0);
		}

		for (int col = 0; col < M; col++) {
			for (int row = 0; row < N; row++) {
				if (bin[row][col] == '0') {
					com.remove(row);
				} else {
					com.put(row, 0);
				}

			}
		}

		return com.firstKey() + 1;
	}

}
