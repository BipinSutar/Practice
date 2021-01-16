package com.bipin.practice.hackerrank.wcode35.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SparseArrays {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		Map<String, Integer> map = new HashMap<>();
		while (n-- > 0) {
			String key = br.readLine();
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else
				map.put(key, 1);
		}
		int q = Integer.parseInt(br.readLine().trim());
		while (q-- > 0) {
			String key = br.readLine();
			int con = map.get(key) == null ? 0 : map.get(key);
			System.out.println(con);
		}
		br.close();
	}

}
