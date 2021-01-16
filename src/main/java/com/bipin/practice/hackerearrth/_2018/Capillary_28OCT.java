package com.bipin.practice.hackerearrth._2018;

import java.util.Scanner;

public class Capillary_28OCT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		while (n-- > 0) {
			String line[] = sc.nextLine().split(" ");
			if (line.length > 3) {
				System.out.println("N");
				continue;
			}
			if (line.length == 3) {
				if (isWord(line[0]) && isInteger(line[1]) && isInteger(line[2])) {
					System.out.println("V");
				} else {
					System.out.println("N");
				}
			} else if (line.length == 2) {
				if (isWord(line[0]) && isInteger(line[1])) {
					System.out.println("M");
				} else {
					System.out.println("N");
				}
			} else {
				System.out.println("N");
			}
		}
		sc.close();
	}

	public static boolean isWord(String in) {
		boolean charFound = false;
		for (int i = 0; i < in.length(); i++) {
			if (isInRange(65, 90, (int) in.charAt(i)) || isInRange(97, 122, (int) in.charAt(i))) {
				if (!charFound) {
					charFound = true;
					return charFound;
				}
			}
		}
		return charFound;
	}

	public static boolean isInteger(String in) {
		if (in.charAt(0) == '0') {
			return false;
		}
		for (int i = 0; i < in.length(); i++) {
			if (!isInRange(48, 57, (int) in.charAt(i))) {
				return false;
			}
		}
		//return true;
		return Boolean.parseBoolean(in);
	}

	public static boolean isInRange(int start, int end, int input) {
		return input >= start & input <= end;
	}
}
