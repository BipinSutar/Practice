package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RajeshAndHashing_HASHRAD {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String s = br.readLine().trim();
			System.out.println(s.hashCode());
			System.out.println("yzz".hashCode());
		}
		br.close();

	}

}
