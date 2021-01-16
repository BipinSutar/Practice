package com.bipin.practice.skillenza.test;

import java.util.Scanner;
import java.util.TreeMap;

public class SpecialNumbers {
	private static int[] special_numbers = new int[1000000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;// sc.nextInt();
		genSpecialNumbers();
		while (t-- > 0) {

		}
		int count = 0;
		for (int i = 0; i < special_numbers.length; i++) {
			if (special_numbers[i] != 0) {
				System.out.print(special_numbers[i] + " ");
				count++;
			}
		}
		System.out.println("\ncount " + count);
	}

	public static void genSpecialNumbers() {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map.floorKey(2-1);
		map.lowerKey(2);

		int k = 0;
		// for (int num = 1; num < 101; num++) {
		int num = 25;
		System.out.println(Integer.toBinaryString(num));
		char arr[] = Integer.toBinaryString(num).toCharArray();
		boolean isspecial = false;
		boolean isfirstZero = false;
		boolean zeroVisited = false;
		boolean isbreak = false;
		int counttillnow = 0;
		int countnow = 0;

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == '1') {
				counttillnow++;
				zeroVisited = false;
			} else {// it is 0
				if (!isfirstZero) {
					isfirstZero = true;
					zeroVisited = true;
					countnow = counttillnow;
					counttillnow = -1;
				} else if (!zeroVisited) {
					if (isValid(countnow, ++counttillnow)) {
						countnow = counttillnow;
						counttillnow = 0;
						zeroVisited = true;
					} else {
						isbreak = true;
						break;
					}
				}

			}

		}
		if (isValid(countnow, counttillnow))
			System.out.println(num);
		else if (!isbreak || (counttillnow == arr.length) || (counttillnow == -1))
			// special_numbers[k++] = num;
			System.out.println(num);
		// }

	}

	public static boolean isValid(int x, int y) {
		return (x + 1 == y) ? true : false;
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}
}
