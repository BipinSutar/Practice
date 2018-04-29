package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstrings_CSUB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String line = br.readLine();
			long countOne = 0;
			for (int i = 0; i < n; i++) {
				if (line.charAt(i) == '1')
					countOne++;
			}
			countOne = countOne * (countOne + 1) / 2;
			System.out.println(countOne);
		}
		br.close();
	}

}
