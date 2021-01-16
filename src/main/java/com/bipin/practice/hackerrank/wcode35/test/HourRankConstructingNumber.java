package com.bipin.practice.hackerrank.wcode35.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HourRankConstructingNumber {
	static int count = 0;

	private static int[] st; // Array to store segment tree
	private static int[] sumst;// Array to store segment tree
	private static int[] maxst;// Array to store segment tree

	public static void mainConstructingNumber(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String line = br.readLine();
			cal(line, n);
		}
		br.close();
	}

	private static void cal(String line, int n) {
		String lineSplit[] = line.split(" ");
		long sum = 0;
		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(lineSplit[i]);
			long m = num;
			long a;
			while (m > 0) {
				a = m % 10;
				sum += a;
				m /= 10;
			}
		}
		if (sum % 3 == 0)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String line = br.readLine();
			cal1(line, n);
		}
		br.close();
	}

	private static void cal1(String line, int n) {
		String linespit[] = line.split(" ");
		int data[] = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(linespit[i]);
		}
		constructSegmentTree(data);
		// for (int i : st) {
		// System.out.print(i + " , ");
		// }
		// System.out.println();
		// for (int i : sumst) {
		// System.out.print(i + " , ");
		// }
		// System.out.println();
		// for (int i : maxst) {
		// System.out.print(i + " , ");
		// }
		// System.out.println();
		long max = Long.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				long ans = findans(data, i, j);
				// System.out.println("i , j , ans " + i + " , " + j + " , " + ans);
				max = max < ans ? ans : max;
				// count++;
			}
		}
		System.out.println(max);
	}

	private static long findans(int[] data, int i, int j) {
		if (i == j)
			return 0;// data[i] * ((data[i]) - (data[i]));
		return findRangeGcd(data.length, i, j) * ((getSum(data.length, i, j)) - (RMQ(data.length, i, j)));
	}

	public static int[] constructSegmentTree(int[] arr) {
		int height = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
		int size = 2 * (int) Math.pow(2, height) - 1;
		st = new int[size];
		constructST(arr, 0, arr.length - 1, 0);
		sumst = new int[size];
		constructSTUtilSum(arr, 0, arr.length - 1, 0);
		maxst = new int[size];
		constructSTUtilMax(arr, 0, arr.length - 1, 0);
		return st;
	}

	public static int constructST(int[] arr, int ss, int se, int si) {
		if (ss == se) {
			st[si] = arr[ss];
			return st[si];
		}
		int mid = ss + (se - ss) / 2;
		st[si] = gcd(constructST(arr, ss, mid, si * 2 + 1), constructST(arr, mid + 1, se, si * 2 + 2));
		return st[si];
	}

	// Finding The gcd of given Range
	public static int findRangeGcd(int n, int ss, int se) {
		if (ss < 0 || se > n - 1 || ss > se)
			throw new IllegalArgumentException("Invalid arguments");

		return findGcd(0, n - 1, ss, se, 0);
	}

	public static int findGcd(int ss, int se, int qs, int qe, int si) {
		if (ss > qe || se < qs)
			return 0;

		if (qs <= ss && qe >= se)
			return st[si];

		int mid = ss + (se - ss) / 2;

		return gcd(findGcd(ss, mid, qs, qe, si * 2 + 1), findGcd(mid + 1, se, qs, qe, si * 2 + 2));
	}

	// Function to return gcd of a and b
	static int gcd(int a, int b) {
		// if (a == 0)
		// return b;
		// return gcd(b % a, a);
		a = Math.abs(a);
		b = Math.abs(b);
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		return b == 0 ? a : gcd(b, a % b);
	}

	static int constructSTUtilSum(int arr[], int ss, int se, int si) {
		// If there is one element in array, store it in current node of
		// segment tree and return
		if (ss == se) {
			sumst[si] = arr[ss];
			return arr[ss];
		}

		// If there are more than one elements, then recur for left and
		// right subtrees and store the sum of values in this node
		int mid = ss + (se - ss) / 2;
		sumst[si] = constructSTUtilSum(arr, ss, mid, si * 2 + 1) + constructSTUtilSum(arr, mid + 1, se, si * 2 + 2);
		return sumst[si];
	}

	static int constructSTUtilMax(int arr[], int ss, int se, int si) {
		// If there is one element in array, store it in current
		// node of segment tree and return
		if (ss == se) {
			maxst[si] = arr[ss];
			return arr[ss];
		}

		// If there are more than one elements, then recur for left and
		// right subtrees and store the minimum of two values in this node
		int mid = ss + (se - ss) / 2;
		maxst[si] = maxVal(constructSTUtilMax(arr, ss, mid, si * 2 + 1),
				constructSTUtilMax(arr, mid + 1, se, si * 2 + 2));
		return maxst[si];
	}

	static int maxVal(int x, int y) {
		return (x > y) ? x : y;
	}

	// Return minimum of elements in range from index qs (quey
	// start) to qe (query end). It mainly uses RMQUtil()
	static int RMQ(int n, int qs, int qe) {
		// Check for erroneous input values
		if (qs < 0 || qe > n - 1 || qs > qe) {
			System.out.println("Invalid Input");
			return -1;
		}

		return RMQUtil(0, n - 1, qs, qe, 0);
	}

	/*
	 * A recursive function to get the minimum value in a given range of array
	 * indexes. The following are parameters for this function.
	 * 
	 * st --> Pointer to segment tree index --> Index of current node in the segment
	 * tree. Initially 0 is passed as root is always at index 0 ss & se --> Starting
	 * and ending indexes of the segment represented by current node, i.e.,
	 * st[index] qs & qe --> Starting and ending indexes of query range
	 */
	static int RMQUtil(int ss, int se, int qs, int qe, int index) {
		// If segment of this node is a part of given range, then
		// return the min of the segment
		if (qs <= ss && qe >= se)
			return maxst[index];

		// If segment of this node is outside the given range
		if (se < qs || ss > qe)
			return -1;

		// If a part of this segment overlaps with the given range
		int mid = ss + (se - ss) / 2;
		return maxVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1), RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
	}

	// Return sum of elements in range from index qs (quey start) to
	// qe (query end). It mainly uses getSumUtil()
	static int getSum(int n, int qs, int qe) {
		// Check for erroneous input values
		if (qs < 0 || qe > n - 1 || qs > qe) {
			// System.out.println("Invalid Input");
			return -1;
		}
		return getSumUtil(0, n - 1, qs, qe, 0);
	}

	static int getSumUtil(int ss, int se, int qs, int qe, int si) {
		// If segment of this node is a part of given range, then return
		// the sum of the segment
		if (qs <= ss && qe >= se)
			return sumst[si];

		// If segment of this node is outside the given range
		if (se < qs || ss > qe)
			return 0;

		// If a part of this segment overlaps with the given range
		int mid = ss + (se - ss) / 2;
		return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
	}

}