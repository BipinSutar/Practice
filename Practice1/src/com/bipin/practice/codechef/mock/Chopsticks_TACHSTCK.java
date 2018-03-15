package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chopsticks_TACHSTCK {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line[] = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int d = Integer.parseInt(line[1]);
		int chopstiks[] = new int[n];

		for (int i = 0; i < n; i++) {
			chopstiks[i] = Integer.parseInt(br.readLine());

		}
		Arrays.sort(chopstiks);
		int j = n - 1;
		int pairs = 0;
		while (j >= 1) {
			if (abs(chopstiks[j] - chopstiks[j - 1]) <= d) {
				pairs++;
				j = j - 2;
			} else {
				j--;
			}
		}
		System.out.println(pairs);
		br.close();
	}

	public static int abs(int a) {
		return (a < 0) ? -a : a;
	}

}
