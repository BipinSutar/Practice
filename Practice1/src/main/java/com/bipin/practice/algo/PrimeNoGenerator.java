package com.bipin.practice.algo;

public class PrimeNoGenerator {

	public static void main(String[] args) {
		primeNoGen(150);
		System.out.println("\n");

		primeNoGen1(150);
		System.out.println();
		// fibogen(15);
	}

	private static void primeNoGen(int n) {
		for (int i = 0; i < n; i++) {

			int counter = 0;
			for (int j = i; j >= 1; j--) {
				if (i % j == 0) {
					counter++;
				}
			}
			if (counter == 2) {
				System.out.print(i + " ,");
			}
		}

	}



	private static void primeNoGen1(int n) {
		// System.out.print("2 ,3 ,5 ,7 ,11 ,");
		for (int i = 2; i < n; i++) {
			boolean flag = true;
			int var = (int) Math.sqrt(i);
			for (int j = 2; j <= var; j = j + 1) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.print(i + " ,");
			}
		}

	}
}
