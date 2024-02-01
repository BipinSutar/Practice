package com.bipin.practice.leetcode;

public class ClassNameGenerator {
	public static void main(String[] args) {
		String inputLong = "121. Best Time to Buy and Sell Stock";
		inputLong = "238. Product of Array Except Self";
		inputLong = "152. Maximum Product Subarray";
		int code = Integer.parseInt(inputLong.replaceAll("[^0-9]", ""));
		String input = inputLong.replaceAll("[0-9]", "").replace('.', Character.MIN_VALUE).trim();
		System.out.println(getClassName(input, code));
	}

	public static String getClassName(String input, Integer code) {
		StringBuilder res = new StringBuilder();
		String[] li = input.split(" ");
		for (int i = 0; i < li.length; i++) {
			StringBuilder curr = new StringBuilder(li[i]);
			curr.setCharAt(0, toUpperCase(curr.charAt(0)));
			for (int j = 1; j < curr.length(); j++) {
				curr.setCharAt(j, toLowerCase(curr.charAt(j)));
			}
			res.append(curr);
		}
		res.append("_");
		if (code != null) {
			res.append(code);
		}
		return res.toString();
	}

	public static char toUpperCase(char ch) {
		return (ch + "").toUpperCase().charAt(0);
	}

	public static char toLowerCase(char ch) {
		return (ch + "").toLowerCase().charAt(0);
	}
}