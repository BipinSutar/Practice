package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class PayPal_01Jun {

	public static void mainEvenPalin(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			sb.append(getMaxOccurNumberinString(getPalindrom(br.readLine())) + "\n");
		}

		System.out.println(sb.toString());
		/*
		 * for (int i = 0; i < 1000_000_000; i++) { if (isPalindrome(i))
		 * System.out.println(i); }
		 */
		br.close();
	}

	public static boolean isPalindrome(int n) {
		int r, sum = 0, temp;

		temp = n;
		int numdig = 0;
		while (n > 0) {
			r = n % 10; // getting remainder
			sum = (sum * 10) + r;
			n = n / 10;
			numdig++;
		}
		if (temp == sum && numdig % 2 == 0)
			return true;
		else
			return false;
	}

	public static String getPalindrom(String pos) {
		StringBuilder ans = new StringBuilder();
		String first = pos.substring(0, 1);
		StringBuilder rest = new StringBuilder(pos.substring(1));
		ans.append(first).append(rest).append(rest.reverse()).append(first);
		System.out.println(ans.toString());
		return ans.toString();
	}

	public static int getMaxOccurNumberinString(String num) {

		int nums[] = new int[10];
		for (int i = 0; i < num.length(); i++) {
			int n = Integer.parseInt(num.charAt(i) + "");
			nums[n]++;
		}
		int max = Integer.MIN_VALUE;
		int ans = 11;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				ans = i;
			} else if (nums[i] == max && i < ans) {
				ans = i;
			}
		}
		return ans;
	}

	public static void mainBobAndForest(String[] args) throws IOException {// bob and forest
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String lines[] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(lines[0]);
		int m = Integer.parseInt(lines[1]);
		int arr[][] = new int[n][m];
		String newline = "\n";
		for (int i = 0; i < n; i++) {
			String line = br.readLine().trim();
			for (int j = 0; j < m; j++) {
				if (line.charAt(j) == '*') {
					arr[i][j] = 1;
				} else {
					arr[i][j] = 0;
				}

			}
		}
		TreeMap<Integer, Integer> sizes = new PayPal_01Jun().maxSize(arr);
		int q = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			int k = Integer.parseInt(br.readLine().trim());
			Object ans = sizes.floorKey(k);
			int a = ans == null ? 0 : sizes.get(ans);
			sb.append(a + newline);
		}
		System.out.println(sb.toString());
		br.close();
	}

	private int min(int a, int b, int c) {
		int l = min(a, b);
		return min(l, c);
	}

	private int min(int a, int b) {
		return a < b ? a : b;
	}

	public TreeMap<Integer, Integer> maxSize(int arr[][]) {

		int result[][] = new int[arr.length][arr[0].length];
		TreeMap<Integer, Integer> tmapAsc = new TreeMap<>();
		for (int i = 0; i < arr.length; i++) {
			result[i][0] = arr[i][0];
		}

		for (int i = 0; i < arr[0].length; i++) {
			result[0][i] = arr[0][i];
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					continue;
				}
				int t = min(result[i - 1][j], result[i - 1][j - 1], result[i][j - 1]);
				result[i][j] = t + 1;

			}
		}

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				if (result[i][j] == 0) {
					continue;
				}
				if (tmapAsc.containsKey(result[i][j])) {
					tmapAsc.put(result[i][j], tmapAsc.get(result[i][j]) + 1);
				} else {
					tmapAsc.put(result[i][j], 1);
				}

			}
		}
		if (tmapAsc.isEmpty())
			return tmapAsc;
		int sum = tmapAsc.get(tmapAsc.lastKey());
		boolean f = false;
		for (Integer m : tmapAsc.descendingKeySet()) {
			if (f) {
				sum += tmapAsc.get(m);
				tmapAsc.put(m, sum);
			}
			f = true;
		}
		sum = 0;

		for (Integer m : tmapAsc.keySet()) {
			sum += tmapAsc.get(m);
			tmapAsc.put(m, sum);
			f = true;
		}
		return tmapAsc;
	}

	static int harr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String lines[] = br.readLine().split(" ");
			int n = Integer.parseInt(lines[0]);
			int x = Integer.parseInt(lines[1]);
			int v[] = new int[n];
			lines = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				v[i] = Integer.parseInt(lines[i]);
			}
			harr = v;
			MinHeapify(v.length-1);
			int v1[] = new int[n + 1];
			for (int i = 0; i < n; i++) {
				v1[i] = harr[i];
			}
			v1[n] = x;
			harr = v1;
			MinHeapify(v1.length-1);
			int total = 0;
			for (int i = v1.length - 1; i >= 0; i--) {
				total += v1[i];
			}
			System.out.println(total);
		} finally {
			br.close();
		}

	}

	public static void MinHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if (l < harr.length && harr[l] < harr[i])
			smallest = l;
		if (r < harr.length && harr[r] < harr[smallest])
			smallest = r;
		if (smallest != i) {
			// swap
			int temp = harr[smallest];
			harr[smallest] = harr[i];
			harr[i] = temp;
			MinHeapify(smallest);
		}

	}

	static int parent(int i) {
		return (i - 1) / 2;
	}

	// to get index of left child of node at index i
	static int left(int i) {
		return (2 * i + 1);
	}

	// to get index of right child of node at index i
	static int right(int i) {
		return (2 * i + 2);
	}
}
