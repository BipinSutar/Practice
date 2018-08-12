package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Vivriti_Capital_01June {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String list[] = new String[n];
		list = br.readLine().split(" ");
		System.out.println(getMaxLenCommonDigitSubarray(list));
		br.close();

	}

	public static int getMaxLenCommonDigitSubarray(String nums[]) {
		Set<Character> s1 = new HashSet<Character>();
		s1 = addCharsFromString(nums[0]);
		int len = Integer.MIN_VALUE;
		int currLen = 1;
		for (int i = 1; i < nums.length; i++) {
			Set<Character> s2 = addCharsFromString(nums[i]);

			s1.retainAll(s2);
			if (s1.isEmpty()) {
				len = Integer.max(len, currLen);
				s1=s2;
				currLen = 1;
			} else {
				currLen++;
			}
		}
		len = Integer.max(len, currLen);
		return len;
	}

	public static Set<Character> addCharsFromString(String s) {
		Set<Character> s1 = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			s1.add(s.charAt(i));
		}
		return s1;
	}

}
