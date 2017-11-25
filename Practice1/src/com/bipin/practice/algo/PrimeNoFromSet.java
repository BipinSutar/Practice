package com.bipin.practice.algo;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNoFromSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int data[] = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextInt();

		}
		printPrime(data);
		sc.close();

	}

	public static void printPrime(int data[]) {
		//Arrays.sort(data);
		for (int i = 0; i < data.length; i++) {
			boolean flag = true;
			for (int j = 0; j < data.length; j++) {
				if (j != data.length) {
					if ((data[i] % data[j] == 0) & data[i] != data[j]) {
						flag = false;
						break;
					}

				}
			}
			if (flag) {
				System.out.print(data[i] + " ");
			}
		}
	}

}
