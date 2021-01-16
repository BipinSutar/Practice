package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LittleElephantandCandies_LECANDY {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String line[] = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int c = Integer.parseInt(line[1]);
			int A[] = new int[n];
			line = br.readLine().split(" ");
			int sum = 0;
			for (int i = 0; i < n; i++) {
				A[i] = Integer.parseInt(line[i]);
				sum += A[i];
			}
			if (sum <= c) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		br.close();
	}

}
