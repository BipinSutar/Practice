package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LostGuyRadhu_MAY19F1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			String line[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(line[0]);
			int q = Integer.parseInt(line[1]);
			int n_arr[] = new int[n];
			int q_arr[] = new int[q];
			line = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				n_arr[i] = Integer.parseInt(line[i]);
			}
			line = br.readLine().trim().split(" ");
			for (int i = 0; i < q; i++) {
				q_arr[i] = Integer.parseInt(line[i]);
			}
			q_arr = getThoughtsAns(n_arr, q_arr);
			for (int i = 0; i < q; i++) {
				sb.append(q_arr[i] + "\n");
			}
		}
		System.out.println(sb.toString());
		br.close();

	}
	public static int[] getThoughtsAns(int arr[], int q[]) {
		int maxarr[] = new int[arr.length];
		maxarr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxarr[i] = max(maxarr[i - 1], arr[i]);
		}
		int q_arr[] = new int[q.length];
		for (int i = 0; i < q.length; i++) {
			q_arr[i] = maxarr[q[i] - 1];
		}
		return q_arr;
	}
	public static int max(int a, int b) {
		return a > b ? a : b;
	}

}
