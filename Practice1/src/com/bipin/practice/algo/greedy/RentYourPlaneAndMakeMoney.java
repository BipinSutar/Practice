package com.bipin.practice.algo.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class RentData {
	int startTime;
	int endtime;
	int price;

	RentData(int starttime, int endtime, int price) {
		this.startTime = starttime;
		this.endtime = endtime;
		this.price = price;

	}

	@Override
	public String toString() {
		return "RentData [startTime=" + startTime + ", endtime=" + endtime + ", price=" + price + "]";
	}

}

class RentdataOrderByEndTime implements Comparator<RentData> {

	@Override
	public int compare(RentData o1, RentData o2) {
		return o1.endtime - o2.endtime;
	}

}

class RentdataOrderByPrice implements Comparator<RentData> {

	@Override
	public int compare(RentData o1, RentData o2) {
		return o1.price - o2.price;
	}

}

class RentDataOrderByStartTime implements Comparator<RentData> {
	@Override
	public int compare(RentData o1, RentData o2) {
		return o1.startTime - o2.startTime;
	}
}

public class RentYourPlaneAndMakeMoney {
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int t = fs.nextInt();
		ArrayList<RentData> list = new ArrayList<>();
		int n, N = 0;
		while (t-- > 0) {
			n = fs.nextInt();
			N = n;
			while (n-- > 0) {
				list.add(new RentData(fs.nextInt(), fs.nextInt(), fs.nextInt()));
			}
		}
		// for (RentData s : list) {
		// System.out.println(s.toString());
		// }

		// ArrayList<RentData> list1 = list;
		// ArrayList<RentData> list2 = list;
		Collections.sort(list, new RentDataOrderByStartTime());
		// Collections.sort(list1, new RentdataOrderByEndTime());
		// Collections.sort(list2, new RentdataOrderByPrice());

		int best[] = new int[N + 1];
		best[N] = 0;
		for (int i = N - 1; i >= 0; i--) {
			best[i] = max(best[i + 1],
					best[find(list.get(i).startTime + list.get(i).endtime, N, list)] + list.get(i).price);
		}
		System.out.println(best[0]);
	}

	private static int find(int t, int N, ArrayList<RentData> list) {
		int a = 0;
		int b = N;
		while (b - a > 1) {
			int mid = (a + b) / 2;
			if (list.get(mid).startTime >= t)
				b = mid;
			else
				a = mid;

		}
		return b;
	}

	public static int max(int a, int b) {
		return (a >= b) ? a : b;
	}
}
