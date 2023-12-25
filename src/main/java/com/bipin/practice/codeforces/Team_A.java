package com.bipin.practice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Team_A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < n; i++) {
			String line[] = br.readLine().split(" ");
			int sum = Integer.parseInt(line[0]) + Integer.parseInt(line[1]) + Integer.parseInt(line[2]);
			if (sum > 1) {
				count++;
			}
		}
		System.out.println(count);
		br.close();
	}

}
