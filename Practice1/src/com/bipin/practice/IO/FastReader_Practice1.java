package com.bipin.practice.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader_Practice1 {
	BufferedReader br = null;
	StringTokenizer st = null;

	FastReader_Practice1() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

}
