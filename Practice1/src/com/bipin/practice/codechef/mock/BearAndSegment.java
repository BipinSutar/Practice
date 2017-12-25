package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Bear Limak has a string S. Each character of S is a digit '0' or '1'.
 * 
 * Help Limak and check if all the '1' digits form a single non-empty segment
 * (consecutive subsequence) in the string. For each test case, print "YES" or
 * "NO" accordingly.
 * 
 * Input The first line of the input contains an integer T denoting the number
 * of test cases. The description of T test cases follows.
 * 
 * The only line of each test case contains one string S, consisting of digits
 * '0' and '1' only.
 * 
 * Output For each test case, output a single line containing the answer — "YES"
 * if all the '1' digits form a single non-empty segment, and "NO" otherwise.
 * Don't print the quotes.
 * 
 *
 */
public class BearAndSegment {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			System.out.println(isValid(br.readLine()) ? "YES" : "NO");
		}
		br.close();
	}

	public static boolean isValid(String s) {
		int flag = 0;
		int firstFlag = 0;
		int secondFlag = 0;
		char arr[] = s.toCharArray();
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == '1')
				flag = 1;
			if (flag == 1 && arr[j] == '0')
				firstFlag = 1;
			if (firstFlag == 1 && arr[j] == '1') {
				secondFlag = 1;
				break;
			}
		}

		if (secondFlag == 1 || flag == 0)
			return false;
		else
			return true;

	}
}
