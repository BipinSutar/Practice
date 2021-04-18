package com.bipin.practice.hackarrank._2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class FlatlandSpaceStations {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		String line[] = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int arr[] = new int[m];
		line = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		System.out.println(getMaxStation(n, arr));
		System.out.println(getMaxStation1(n, arr));
		br.close();
	}

	public static int getMaxStation1(int n, int stations[]) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < stations.length; i++) {
			map.put(stations[i], null);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			Integer left = map.floorKey(i);
			Integer right = map.ceilingKey(i);
			if (left != null && right != null) {
				int currmin = min(Math.abs(i - left), Math.abs(i - right));
				if (currmin > max) {
					max = currmin;
				}
			} else if (left == null && right == null) {

			} else if (left == null && right != null) {
				int currmin = Math.abs(i - right);
				if (currmin > max) {
					max = currmin;
				}
			} else if (left != null && right == null) {
				int currmin = Math.abs(i - left);
				if (currmin > max) {
					max = currmin;
				}
			}
		}
		return max;
	}

	public static int min(int a, int b) {
		return a < b ? a : b;

	}

	public static int getMaxStation(int n, int stations[]) {
		Arrays.sort(stations);
		int res = stations[0];
		for (int i = 1; i < stations.length; i++) {
			res = max(res, (stations[i] - stations[i - 1]) / 2);
		}
		res = max(res, n - 1 - stations[stations.length - 1]);
		return res;
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static String fairRations(List<Integer> B) {
		// Write your code here
		int count = 0;
		int sum = 0;
		for (int i = 0; i < B.size(); i++) {
			sum += B.get(i);
		}
		if (sum % 2 == 1) {
			return "NO";
		} else {
			for (int i = 0; i < B.size(); i++) {
				if (B.get(i) % 2 != 0) {
					B.add(i, B.get(i) + 1);
					B.add(i + 1, B.get(i + 1) + 1);
					count += 2;
				}

			}

		}
		return count + "";
	}

}
