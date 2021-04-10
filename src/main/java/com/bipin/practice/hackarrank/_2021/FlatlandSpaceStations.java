package com.bipin.practice.hackarrank._2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FlatlandSpaceStations {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String line[] = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int arr[] = new int[m];
		line = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		System.out.println(getMaxStation(n, arr));
		br.close();
	}

	public static int getMaxStation1(int n, int stations[]) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < stations.length; i++) {
			map.put(stations[i], null);
		}
		for (int i = 0; i < n; i++) {

		}
		return 0;
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

}
