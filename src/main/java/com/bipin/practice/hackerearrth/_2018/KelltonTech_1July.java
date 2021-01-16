package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class KelltonTech_1July {
	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int N = Integer.parseInt(br.readLine().trim());
		String line[] = br.readLine().trim().split(" ");
		TreeMap<Integer, Integer> tmap = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			int no = Integer.parseInt(line[i]);
			if (tmap.containsKey(no)) {
				tmap.put(no, tmap.get(no) + 1);
			} else {
				tmap.put(no, 1);
			}
		}
		int i_i = 1;
		boolean ans = false;
		for (Map.Entry<Integer, Integer> i_map : tmap.entrySet()) {
			if (!(i_i == 1 || i_i == tmap.size())) {
				int x = i_map.getKey();
				long sum1 = 0;
				long sum2 = 0;
				for (Map.Entry<Integer, Integer> i_map_in1 : tmap.headMap(x, false).entrySet()) {
					sum1 = sum1 + (i_map_in1.getKey() * i_map_in1.getValue());
				}
				for (Map.Entry<Integer, Integer> i_map_in1 : tmap.tailMap(x, false).entrySet()) {
					sum2 = sum2 + (i_map_in1.getKey() * i_map_in1.getValue());
				}
				if (sum1 == sum2) {
					ans = true;
					break;
				}

			}
			i_i++;
		}

		System.out.println(ans ? "YES" : "NO");
		br.close();
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0) {
			String line[] = br.readLine().trim().split(" ");
			int N = Integer.parseInt(line[0]);
			// int M = Integer.parseInt(line[1]);
			String[] lines = new String[N];
			boolean ans = true;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				lines[i] = br.readLine().trim();
				sb.append(lines[i]);
			}

			ans = getPalindrome(sb.toString());
			/*
			 * if (ans) { for (int i = 0; i < M; i++) { StringBuilder sb = new
			 * StringBuilder(); for (int j = 0; j < N; j++) { sb.append(lines[j].charAt(i));
			 * } ans = getPalindrome(sb.toString()); if (!ans) { break; } } }
			 */

			System.out.println(ans ? "YES" : "NO");
		}
	}

	public static boolean getPalindrome(String str) {

		// Store counts of characters
		Map<Character, Integer> hmap = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			Character c = new Character(str.charAt(i));
			if (hmap.containsKey(c)) {
				hmap.put(c, hmap.get(c) + 1);
			} else {
				hmap.put(c, 1);
			}
		}

		/*
		 * find the number of odd elements. Takes O(n)
		 */
		int oddCount = 0;
		Iterator<Character> itr = hmap.keySet().iterator();
		while (itr.hasNext()) {
			Character c = itr.next();
			Integer v = hmap.get(c);
			if ((v.intValue() % 2) != 0) {
				oddCount++;
			}

		}

		/*
		 * odd_cnt = 1 only if the length of str is odd
		 */
		if (oddCount > 1 || oddCount == 1 && (str.length() % 2 == 0)) {
			return false;
		} else {
			return true;
		}
	}
}
