package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Equals_17_FEB {

	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int data[] = new int[n];
		int max = Integer.MIN_VALUE;
		int defaultvalue = 0;
		TreeMap<Integer, Integer> asc_map = new TreeMap<>();
		TreeMap<Integer, Integer> dsc_map = new TreeMap<>();

		String line[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(line[i]);
			if (data[i] > max)
				max = data[i];
		}
		boolean maxfound = false;
		for (int i = 0; i < n; i++) {
			if (!maxfound) {
				asc_map.put(data[i], defaultvalue);
				if (data[i] == max)
					maxfound = true;
			} else {
				dsc_map.put(data[i], defaultvalue);
			}
		}
		long size = dsc_map.size() + asc_map.size();
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			Integer in = Integer.parseInt(br.readLine());
			boolean first = asc_map.containsKey(in);
			boolean second = dsc_map.containsKey(in);
			if (in >= max || (first && second)) {
				sb.append(size + "\n");
				continue;
			}
			if (first) {
				dsc_map.put(in, defaultvalue);
			} else {
				asc_map.put(in, defaultvalue);
			}
			size++;
			sb.append(size + "\n");
		}
		System.out.print(sb.toString());
		sb = new StringBuilder();
		for (Integer i : asc_map.keySet()) {
			sb.append(i + " ");
		}
		for (Integer i : dsc_map.descendingKeySet()) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString().substring(0, sb.length() - 1));
		br.close();
	}

	public static void main2(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int init[] = new int[2];
		String line[] = br.readLine().split(" ");
		init[0] = Integer.parseInt(line[0]);
		init[1] = Integer.parseInt(line[1]);
		line = br.readLine().split(" ");
		int arr[] = new int[init[0]];
		for (int i = 0; i < init[0]; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		int lis[] = new int[init[0]];
		int i, j, max = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < init[0]; i++)
			lis[i] = 1;

		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < init[0]; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
		for (int ii = 0; ii < init[0]; ii++)
			if (init[1] <= lis[ii]) {
				int cal = arr[ii] - arr[(ii + 1) - lis[ii]];

				if (max < cal)
					max = cal;
			}
		System.out.println(max == 0 ? -1 : max);
		br.close();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int init[] = new int[2];
		String line[] = br.readLine().split(" ");
		init[0] = Integer.parseInt(line[0]);
		init[1] = Integer.parseInt(line[1]);
		line = br.readLine().split(" ");
		int arr[] = new int[init[0]];
		for (int i = 0; i < init[0]; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		int lis[] = new int[arr.length];
		int diff[] = new int[arr.length];
		lis[0] = 1;// length 1
		int len = 1;
		int sum = 0;
		diff[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				len++;
				sum += arr[i] - arr[i - 1];
			} else {
				len = 1;
				sum = 0;
			}
			lis[i] = len;
			diff[i] = sum;
		}
		int max = 0;
		for (int ii = 0; ii < arr.length; ii++) {
			System.out.println(diff[ii]);
			if (init[1] <= lis[ii]) {
				// int cal = arr[ii] - arr[(ii + 1) - lis[ii]];
				// if (max < cal)
				// max = cal;
				if (max < diff[ii])
					max = diff[ii];
			}
		}
		System.out.println("ans " + (max == 0 ? -1 : max));

	}
}
