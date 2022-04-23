package com.bipin.practice.codingninjas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RectangularNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		br.close();
	}

	public static String getPattern(int n) {
		if (n == 1) {
			return "1";

		}
		return null;
	}

}
