package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class RestaurantRating_RRATING {
	public static void mainTreeSet(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		TreeSet<Long> pq = new TreeSet<>(Collections.reverseOrder());
		while (t-- > 0) {
			String line[] = br.readLine().trim().split(" ");
			int type = Integer.parseInt(line[0].trim());
			if (type == 1) {
				long num = Long.parseLong(line[1].trim());
				pq.add(num);
			} else {
				int size = pq.size() / 3;
				if (size == 0) {
					sb.append("No reviews yet" + "\n");
				} else {
					long ans = 0;
					Iterator<Long> itr = pq.iterator();
					while (size-- > 0) {
						ans = itr.next();
					}
					sb.append(ans + "\n");
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> minpq = new PriorityQueue<>();
		PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> b - a);
		int n = 0;
		while (t-- > 0) {
			String line[] = br.readLine().trim().split(" ");
			int type = Integer.parseInt(line[0].trim());
			if (type == 1) {
				n++;
				Integer num = Integer.parseInt(line[1].trim());
				maxpq.add(num);
				if (!minpq.isEmpty() && !maxpq.isEmpty()
						&& minpq.peek() < maxpq.peek()) {
					maxpq.add(minpq.remove());
					minpq.add(maxpq.remove());
				}
				if (n % 3 == 0) {
					minpq.add(maxpq.remove());
				}

			} else {
				if (!minpq.isEmpty()) {
					sb.append(minpq.peek() + "\n");
				} else {
					sb.append("No reviews yet" + "\n");
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> minpq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>(
				Collections.reverseOrder());
		int n = 0;
		while (t-- > 0) {
			String line[] = br.readLine().trim().split(" ");
			int type = Integer.parseInt(line[0].trim());
			if (type == 1) {
				n++;
				int num = Integer.parseInt(line[1].trim());
				if (maxpq.isEmpty() || maxpq.peek() >= num) {
					maxpq.add(num);
				} else {
					minpq.add(num);
				}
				while (minpq.size() < n / 3) {
					minpq.add(maxpq.poll());
				}
				while (minpq.size() > n / 3) {
					maxpq.add(minpq.poll());
				}
			} else {
				if (n < 3) {
					sb.append("No reviews yet" + "\n");
				} else {
					sb.append(minpq.peek() + "\n");
				}
			}

		}
		System.out.println(sb.toString());
		br.close();
	}
}
