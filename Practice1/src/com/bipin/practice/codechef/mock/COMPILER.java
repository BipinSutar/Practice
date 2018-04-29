package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class COMPILER {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			System.out.println(getMaxValidLength(br.readLine()));
		}
		br.close();

	}

	public static int getMaxValidLength(String s) {
		int maxLen = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				count++;
			} else if (s.charAt(i) == '>') {
				count--;
				if (count < 0)
					break;
				else if (count == 0)
					maxLen = Math.max(maxLen, i + 1);
			}
		}
		return maxLen;
	}

}
