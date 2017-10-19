package com.bipin.practice.codechef.mock;

import java.util.Arrays;
import java.util.Scanner;

public class Lapindromes {
	static boolean isdebugon = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < T; i++) {
			String s = sc.nextLine();
			System.out.println(isLapindrome(s) ? "YES" : "NO");
			System.out.println(isLapindrome1(s) ? "YES" : "NO");
		}

		sc.close();
	}

	public static boolean isLapindrome(String s) {
		boolean result = true;
		char data[] = s.toCharArray();

		int mid = data.length / 2;
		dbg("mid " + mid);

		char leftdata[] = Arrays.copyOf(data, mid);
		if (data.length % 2 != 0) {
			mid++;
		}

		char rightdata[] = Arrays.copyOfRange(data, mid, data.length);
		Arrays.sort(leftdata);
		Arrays.sort(rightdata);

		for (char i : rightdata) {
			dbg(i + " ");
		}

		for (int i = 0; i < leftdata.length; i++) {
			if (leftdata[i] != rightdata[i]) {
				return false;
			}
		}

		return result;
	}

	public static boolean isLapindrome1(String s) {
		boolean result = true;
		int len = s.length();
		int chardata[] = new int[52];
		int charPointer = 97;
		int mid = len / 2;

		for (int i = 0; i < mid; i++) {
			chardata[(int) (s.charAt(i)) - charPointer]++;
		}
		dbg("here");
		for (int i = 0; i < chardata.length; i++) {
			if (chardata[i] != 0)
				dbg(i + "  " + chardata[i]);
		}
		if (len % 2 != 0) {
			mid++;
		}
		for (int i = mid; i < len; i++) {
			chardata[(int) (s.charAt(i)) - charPointer]--;
		}
		dbg("here1");
		for (int i = 0; i < chardata.length; i++) {
			if (chardata[i] != 0)
				dbg(i + "  " + chardata[i]);
		}
		for (int i = 0; i < chardata.length; i++) {
			if (chardata[i] > 0)
				return false;
		}
		return result;
	}

	public static void dbg(String s) {
		if (isdebugon) {
			System.out.println("dbg=> " + s);
		}
	}
}
