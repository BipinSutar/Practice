package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class RealibilityTest_07_AND_15_Jul {
	public static final int N = 4;

	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int puzzle[][] = null;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			puzzle = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line[] = br.readLine().split(" ");
				for (int k = 0; k < N; k++) {
					puzzle[i][k] = Integer.parseInt(line[k]);
				}
			}
			System.out.println(isSolvable(puzzle) ? "YES" : "NO");
		}

		br.close();

	}

	static int getInvCount(int arr[]) {
		int inv_count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (!(arr[i] == 0 || arr[j] == 0)) {
					if (arr[i] > arr[j])
						inv_count++;
				}
			}
		}
		return inv_count;
	}

	// find Position of blank from bottom
	static int findXPosition(int puzzle[][]) {
		int pos = -1;
		for (int i = N - 1; i >= 0; i--)
			for (int j = N - 1; j >= 0; j--)
				if (puzzle[i][j] == 0) {
					pos = N - i;
					break;
				}
		return pos;
	}

	// This function returns true if given
	// instance of N*N - 1 puzzle is solvable
	static boolean isSolvable(int puzzle[][]) {
		// Count inversions in given puzzle
		int p[] = new int[N * N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				p[i * N + j] = puzzle[i][j];
			}
		}
		int invCount = getInvCount(p);

		int pos = findXPosition(puzzle);
		if ((pos & 1) == 0)
			return (invCount & 1) == 1 ? true : false;
		else
			return (invCount & 1) == 0 ? true : false;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine().trim());
		String[] inp = br.readLine().split(" ");
		int[] profit = new int[N];
		int i;
		for (i = 0; i < N; i++) {
			profit[i] = Integer.parseInt(inp[i]);
		}
		Arrays.sort(profit);
		int Q = Integer.parseInt(br.readLine().trim());
		for (i = 0; i < Q; i++) {
			String[] temp = br.readLine().split(" ");
			int l = Integer.parseInt(temp[0]);
			int r = Integer.parseInt(temp[1]);
			long out_ = solve(N, profit, l, r);
			System.out.println(out_);
		}

		wr.close();
		br.close();
	}

	static long solve(int N, int[] profit, int l, int r) {

		int lpos = Arrays.binarySearch(profit, l);
		int rpos = Arrays.binarySearch(profit, r);
		if (lpos < 0) {
			lpos = -lpos - 1;
		}
		if (rpos < 0) {
			rpos = -rpos - 2;
		}
		int lo = lowerIndex(profit, N, l);
		int u = upperIndex(profit, N, r);
		int ret = rpos - lpos + 1;
		return u - lo + 1;

	}

	static int lowerIndex(int arr[], int n, int x) {
		int l = 0, h = n - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] >= x)
				h = mid - 1;
			else
				l = mid + 1;
		}
		return l;
	}

	static int upperIndex(int arr[], int n, int y) {
		int l = 0, h = n - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] <= y)
				l = mid + 1;
			else
				h = mid - 1;
		}
		return h;
	}
}