package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class ChefAndHisSoftware_TSECJ05 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			String line[] = br.readLine().trim().split(" ");
			int k = Integer.parseInt(line[0].trim());
			int n = Integer.parseInt(line[1].trim());
			line = br.readLine().trim().split(" ");
			PriorityQueue<Integer> minpq = new PriorityQueue<>();
			int size = 0;
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(line[i]);
				if (size < k) {
					minpq.add(num);
					size++;
				} else {
					if (minpq.peek() < num) {
						minpq.poll();
						minpq.add(num);
					}
				}
				// printing
				if (size < k) {
					sb.append(-1 + " ");
				} else {
					sb.append(minpq.peek() + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
