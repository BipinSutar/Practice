package com.bipin.practice.hackerearrth._2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
class EventTimeinInt implements Comparable<EventTimeinInt> {
	int shopPos;
	char eventType;

	EventTimeinInt(int shopPos, char eventType) {
		this.shopPos = shopPos;
		this.eventType = eventType;
	}

	@Override
	public int compareTo(EventTimeinInt o) {
		if (this.shopPos == o.shopPos) {
			return this.eventType - o.eventType;
		}
		return this.shopPos - o.shopPos;

	}

	@Override
	public String toString() {
		return "shopPos = " + this.shopPos + " type = " + this.eventType + "\n";
	}
}
class Pair implements Comparable<Pair> {
	public int start;
	public int end;
	public Pair(int s, int e) {
		this.start = s;
		this.end = e;
	}
	@Override
	public int compareTo(Pair o) {
		if (this.start != o.start) {
			return Integer.compare(this.start, o.start);
		}
		return Integer.compare(this.end, o.end);
	}
	@Override
	public String toString() {
		return "Pair [start=" + start + ", end=" + end + "]";
	}

}

public class StashAway_07Mar {
	protected void finalize() {
		System.out.println("Coding!");
	}
	public static void main(String[] args) throws IOException {
		// mainTheMaximumSum(args);
		// mainPopularShops(args);
		Integer num = 10;
		num = null;
		System.gc();
	}
	public static void mainTheMaximumSum(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			String line[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(line[i].trim());
			}
			for (int i = n - 1; i > 0; i--) {
				if (arr[i] < arr[i - 1]) {
					arr[i - 1] = arr[i];
				}
			}
			long sum = 0;
			for (int i = 0; i < n; i++) {
				sum += arr[i];
			}
			sb.append(sum + "\n");

		}
		System.out.println(sb.toString());
		br.close();
	}
	public static void mainPopularShops(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			String line[] = br.readLine().split(" ");
			int n = Integer.parseInt(line[0].trim());
			int m = Integer.parseInt(line[1].trim());
			int l[] = new int[m];
			int r[] = new int[m];
			for (int i = 0; i < m; i++) {
				line = br.readLine().split(" ");
				l[i] = Integer.parseInt(line[0].trim());
				r[i] = Integer.parseInt(line[1].trim());
			}
			findMaxGuests(l, r, n, sb);
		}
		System.out.println(sb.toString());
		br.close();
	}
	private static <K> void findMaxGuests1(int arrl[], int exit[], int n,
			StringBuilder sb) {
		Arrays.sort(arrl);
		Arrays.sort(exit);
		int i = 0, j = 0;
		int guests_in = 1;
		int size = 0;
		int k = 3;
		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
		while (i < n && j < n) {
			if (arrl[i] <= exit[j]) {
				guests_in++;
				// if (size < k) {
				if (!map.containsKey(guests_in)) {
					map.put(guests_in, new TreeSet<>());
				}
				map.get(guests_in).add(arrl[i]);
				size++;
				/*
				 * } else { if (map.lastKey() < guests_in) {
				 * map.pollFirstEntry(); if (!map.containsKey(guests_in)) {
				 * map.put(guests_in, new TreeSet<>()); }
				 * map.get(guests_in).add(arrl[i]); } }
				 */
				i++;
			} else {
				guests_in--;
				j++;
			}
		}
		TreeSet<Integer> ans = new TreeSet<>();
		for (Integer itr : map.descendingKeySet()) {
			for (Integer child_itr : map.get(itr)) {
				if (k <= 0) {
					break;
				}
				if (ans.add(child_itr)) {
					k--;
				}
			}
		}
		for (Integer itr : ans) {
			sb.append(itr + " ");
		}

	}
	private static <K> void findMaxGuests4(int arrl[], int exit[], int n,
			StringBuilder sb) {
		List<EventTimeinInt> al = new ArrayList<>();
		int k = 3;
		for (int i = 0; i < arrl.length; i++) {
			al.add(new EventTimeinInt(arrl[i], 'A'));
			al.add(new EventTimeinInt(exit[i], 'D'));
		}
		Collections.sort(al);
		int guests_in = 0;
		int firstMax = Integer.MIN_VALUE;
		int firstMaxShop = Integer.MIN_VALUE;
		for (EventTimeinInt e : al) {
			if (e.eventType == 'A') {
				guests_in++;
			} else if (e.eventType == 'D') {
				guests_in--;
			}
			if (guests_in > firstMax) {
				firstMax = guests_in;
				firstMaxShop = e.shopPos;
			}
		}
		int secondMax = Integer.MIN_VALUE;
		int secondMaxShop = Integer.MIN_VALUE;
		guests_in = 0;
		for (EventTimeinInt e : al) {
			if (e.eventType == 'A') {
				guests_in++;
			} else if (e.eventType == 'D') {
				guests_in--;
			}
			if (guests_in > secondMax && guests_in < firstMax
					&& e.shopPos != firstMaxShop) {
				secondMax = guests_in;
				secondMaxShop = e.shopPos;
			} else if (guests_in == firstMax && e.shopPos != firstMaxShop) {
				secondMax = guests_in;
				secondMaxShop = e.shopPos;
				break;
			}
		}
		int thirdMax = Integer.MIN_VALUE;
		int thirdMaxShop = Integer.MIN_VALUE;
		guests_in = 0;
		for (EventTimeinInt e : al) {
			if (e.eventType == 'A') {
				guests_in++;
			} else if (e.eventType == 'D') {
				guests_in--;
			}
			if (guests_in > thirdMax && guests_in < secondMax) {
				thirdMax = guests_in;
				thirdMaxShop = e.shopPos;
			} else if (guests_in == firstMax && e.shopPos != firstMaxShop
					&& e.shopPos != secondMaxShop) {
				thirdMax = guests_in;
				thirdMaxShop = e.shopPos;
				break;
			} else if (guests_in == secondMax && e.shopPos != secondMaxShop) {
				thirdMax = guests_in;
				thirdMaxShop = e.shopPos;
				break;
			}
		}
		ArrayList<Integer> ans = new ArrayList<>(
				Arrays.asList(firstMaxShop, secondMaxShop, thirdMaxShop));
		Collections.sort(ans);
		for (Integer i : ans) {
			sb.append(i + " ");
		}

	}
	private static <K> void findMaxGuests2(int arrl[], int exit[], int n,
			StringBuilder sb) {
		Arrays.sort(arrl);
		Arrays.sort(exit);
		int i = 0, j = 0;
		int guests_in = 0;
		int firstMax = 0;
		int firstMaxShop = arrl[0];
		while (i < arrl.length && j < exit.length) {
			if (arrl[i] < exit[j]) {
				guests_in++;
				if (guests_in > firstMax) {
					firstMax = guests_in;
					firstMaxShop = arrl[i];
				}
				i++;
			} else {
				guests_in--;
				j++;
			}
		}
		i = 0;
		j = 0;
		guests_in = 1;
		int secondMax = 1;
		int secondMaxShop = arrl[0];
		while (i < n && j < n) {
			if (arrl[i] <= exit[j]) {
				guests_in++;
				if (guests_in > secondMax && guests_in < firstMax) {
					secondMax = guests_in;
					secondMaxShop = arrl[i];
				}
				i++;
			} else {
				guests_in--;
				j++;
			}
		}
		i = 0;
		j = 0;
		guests_in = 1;
		int thirdMax = 1;
		int thirdMaxShop = arrl[0];
		while (i < n && j < n) {
			if (arrl[i] <= exit[j]) {
				guests_in++;
				if (guests_in > thirdMax && guests_in < secondMax) {
					thirdMax = guests_in;
					thirdMaxShop = arrl[i];
				}
				i++;
			} else {
				guests_in--;
				j++;
			}
		}
		ArrayList<Integer> ans = new ArrayList<>(
				Arrays.asList(firstMaxShop, secondMaxShop, thirdMaxShop));
		Collections.sort(ans);
		for (Integer ii : ans) {
			sb.append(ii + " ");
		}
	}
	public static boolean isOverlapping(Pair first, Pair second) {
		return (second.start <= first.start && first.start <= second.end)
				|| (first.start <= second.start && second.start <= first.end);
	}
	public static void findMaxGuests3(int start[], int end[], int n,
			StringBuilder sb) {
		int N = start.length;

		Pair interval[] = new Pair[N];
		for (int i = 0; i < N; i++) {
			interval[i] = new Pair(start[i], end[i]);
		}

		Arrays.sort(interval);
		int firstMax = 1;
		int firstMaxShop = interval[0].start;
		for (int i = 0; i < N; i++) {
			int overlappingCount = 0;
			for (int j = i; j >= 0; j--) {
				if (isOverlapping(interval[j], interval[i])) {
					overlappingCount++;
				} else {
					break;
				}
			}

			if (overlappingCount > firstMax) {
				firstMax = overlappingCount;
				firstMaxShop = interval[i].start;
			}
		}
		int secondMax = 1;
		int secondMaxShop = interval[0].start;
		for (int i = 0; i < N; i++) {
			int overlappingCount = 0;
			for (int j = i; j >= 0; j--) {
				if (isOverlapping(interval[j], interval[i])) {
					overlappingCount++;
				} else {
					break;
				}
			}

			if (overlappingCount > secondMax && overlappingCount < firstMax) {
				secondMax = overlappingCount;
				secondMaxShop = interval[i].start;
			}
		}
		int thirdMax = 1;
		int thirdMaxShop = interval[0].start;
		for (int i = 0; i < N; i++) {
			int overlappingCount = 0;
			for (int j = i; j >= 0; j--) {
				if (isOverlapping(interval[j], interval[i])) {
					overlappingCount++;
				} else {
					break;
				}
			}

			if (overlappingCount > thirdMax && overlappingCount < secondMax) {
				thirdMax = overlappingCount;
				thirdMaxShop = interval[i].start;
			}
		}
		ArrayList<Integer> ans = new ArrayList<>(
				Arrays.asList(firstMaxShop, secondMaxShop, thirdMaxShop));
		Collections.sort(ans);
		for (Integer ii : ans) {
			sb.append(ii + " ");
		}
	}
	public static void findMaxGuests(int arrl[], int exit[], int n,
			StringBuilder sb) {
		int shops[] = new int[n + 1];
		int max1 = 0;
		int max2 = 0;
		int max3 = 0;
		for (int i = 0; i < arrl.length; i++) {
			for (int j = arrl[i]; j <= exit[i]; j++) {
				shops[j]++;
			}
		}
		int max1_pos = 0;
		int max2_pos = 0;
		int max3_pos = 0;
		for (int i = 1; i < shops.length; i++) {
			if (shops[i] > max1) {
				max1 = shops[i];
				max1_pos = i;
			}
		}
		for (int i = 1; i < shops.length; i++) {
			if (shops[i] > max2 && shops[i] < max1) {
				max2 = shops[i];
				max2_pos = i;
			} else if (shops[i] == max1 && i != max1_pos) {
				max2 = shops[i];
				max2_pos = i;
				break;
			}
		}
		for (int i = 1; i < shops.length; i++) {
			if (shops[i] > max3 && shops[i] < max2) {
				max3 = shops[i];
				max3_pos = i;
			} else if (shops[i] > max3 && shops[i] < max1) {
				max3 = shops[i];
				max3_pos = i;
			} else if (shops[i] == max2 && i != max1_pos && i != max2_pos) {
				max3 = shops[i];
				max3_pos = i;
				break;

			} else if (shops[i] == max1 && i != max1_pos && i != max2_pos) {
				max3 = shops[i];
				max3_pos = i;
				break;
			}
		}
		List<Integer> printArr = new ArrayList<>(
				Arrays.asList(max1_pos, max2_pos, max3_pos));
		Collections.sort(printArr);
		for (Integer i : printArr) {
			sb.append(i + " ");
		}
	}

}
