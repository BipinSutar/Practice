package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
