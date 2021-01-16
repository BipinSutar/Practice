package com.bipin.practice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Weeklycontest160 {

	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		s.add("xdvqiefpcs");
		s.add("vgnacw");
		s.add("raobcnwgufztdykmsvlj");
		System.out.println(maxLength(s));

	}
	public static int maxLength(List<String> arr) {

		int maxlen = 0;
		if (arr.size() == 1) {
			String s = arr.get(0);
			Set<Character> ch = new HashSet<>();
			for (char c : s.toCharArray()) {
				ch.add(c);
			}
			return ch.size();
		}

		for (int i = 0; i < arr.size(); i++) {
			if (!isUniqueStr(arr.get(i))) {
				continue;
			}
			String concat = arr.get(i);
			for (int j = i + 1; j < arr.size(); j++) {
				if (!isUniqueStr(arr.get(j))) {
					continue;
				}
				String temp = concat + arr.get(j);
				int currsize = getUniqLen(temp);
				if (currsize == temp.length()) {
					concat = temp;
				}

			}
			maxlen = maxlen > concat.length() ? maxlen : concat.length();
		}
		return maxlen;

	}
	static boolean isUniqueStr(String s) {
		Set<Character> ch = new HashSet<>();
		for (char c : s.toCharArray()) {
			ch.add(c);
		}
		return ch.size() == s.length();
	}
	static int getUniqLen(String s) {
		Set<Character> ch = new HashSet<>();
		for (char c : s.toCharArray()) {
			ch.add(c);
		}
		return ch.size();
	}
}
