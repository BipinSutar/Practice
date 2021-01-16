package com.bipin.practice.hackerrank.wcode35.test;

import java.util.Scanner;

public class LeftRotation {

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String[] nd = scan.nextLine().split(" ");

		int n = Integer.parseInt(nd[0].trim());

		int d = Integer.parseInt(nd[1].trim());

		int[] a = new int[n];

		String[] aItems = scan.nextLine().split(" ");

		for (int aItr = 0; aItr < n; aItr++) {
			int aItem = Integer.parseInt(aItems[aItr].trim());
			a[aItr] = aItem;
		}
		a = getLeftRoration(a, d);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static int[] getLeftRoration(int data[], int d) {
		int copy[] = new int[data.length];
		int pos = 0;
		d = d % data.length;
		for (int i = 0; i < data.length; i++) {
			pos = (data.length + i - d) % data.length;
			System.out.println("pos " + pos + " i " + i);
			copy[pos] = data[i];
		}

		return copy;
	}
}
