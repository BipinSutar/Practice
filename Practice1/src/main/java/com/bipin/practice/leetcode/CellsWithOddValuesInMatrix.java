package com.bipin.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CellsWithOddValuesInMatrix {

	public static void main(String[] args) {
		int n = 2;
		int m = 3;
		int indices[][] = new int[][]{{0, 1}, {1, 1}};
		System.out.println(
				new CellsWithOddValuesInMatrix().oddCells(n, m, indices));
	}
	public int oddCells(int n, int m, int[][] indices) {
		int[][] mat = new int[n][m];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < indices.length; i++) {
			for (int j = 0; j < indices[i].length; j++) {
				int pos = indices[i][j];
				if (map.containsKey(pos)) {
					map.put(pos, map.get(pos) + 1);
				} else {
					map.put(pos, 1);
				}
			}
		}

		int count = 0;
		for (Integer index : map.keySet()) {
			int freq = map.get(index).intValue();
			int index_i = index.intValue();
			for (int j = 0; j < m; j++) {
				mat[index_i][j] = mat[index_i][j] + freq;
			}
			for (int j = 0; j < n; j++) {
				mat[j][index_i] = mat[j][index_i] + freq;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] % 2 == 1) {
					count++;
				}
			}
		}
		return count;
	}
}
