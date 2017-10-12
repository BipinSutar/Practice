package com.bipin.practice.algo;

public class PrimeNoGenerator {

	public static void main(String[] args) {
		primeNoGen(150);
		System.out.println();
		fibogen(15);
	}

	private static void primeNoGen(int n) {
		for (int i = 0; i < n; i++) {

			int counter = 0;
			// for (int j = i; j >= 1; j--) {
			double var = Math.sqrt((i + 0.0))+1;
			for (double j = var; j >= 1; j--) {
				if (i % j == 0) {
					counter++;
				}
			}
			if (counter == 2) {
				System.out.print(i + " ,");
			}
		}

	}

	public static void fibogen(int n) {
		int a = 0, b = 0, c = 1;
		for (int i = 0; i <= n; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.print(c + " ");

		}
	}

}
