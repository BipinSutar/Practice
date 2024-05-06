package com.bipin.practice.leetcode;

import java.io.IOException;
import java.util.Arrays;

public class CreditAgricole_20Feb2020 {

	public static void main(String[] args) throws IOException {
		System.out.println(process("DC501"));

	}
	public static String process(String data) {
		StringBuilder sb = new StringBuilder();
		for (String s : data.split("(?<=[a-zA-Z])(?=\\d)")) {
			sb.append(sortString(s));
		}
		return sb.toString();

	}
	public static String sortString(String inputString) {
		// convert input string to char array
		char tempArray[] = inputString.toCharArray();

		// sort tempArray
		Arrays.sort(tempArray);

		// return new sorted string
		return new String(tempArray);
	}
}
