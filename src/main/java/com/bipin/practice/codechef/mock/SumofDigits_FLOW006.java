package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumofDigits_FLOW006 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int num = n, sum = 0;
			while (num > 0) {
				sum += num % 10;
				num = num / 10;
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb.toString());
		br.close();

	}

	public static int getSumOfDigits(String inputNumbers) {
		int digit = 0;
		int add = 0;
		for (int counter = 0; counter < inputNumbers.length(); counter++) {
			char ch = inputNumbers.charAt(counter);
			digit = Character.getNumericValue(ch);
			add = add + digit;
		}
		return add;
	}

}
