package com.bipin.practice.algo;

public class Euclid_GCD {

	public static void main(String[] args) {
		int first = 40;
		int second = 290;
		int gcd = getGCDUsingEuclid_Recursive(first, second);
		int lcm = (first * second) / gcd;
		System.out.println("GCD is " + gcd + " LCM is " + lcm);

	}

	public static int getGCDUsingEuclid(int a, int b) {
		/*
		 * Algo is 1. take max no of a and b in dividend and smaller no in divisor 2.
		 * divide the dividend by divisor and note down remainder 3. if remainder is
		 * zero then divisor is gcd 4. if remainder is not zero then assign divisor into
		 * dividend and remainder into divisor 5. perform step 2 and stop if step 3 is
		 * valid.
		 * 
		 * 
		 */
		// int dividend = a > b ? a : b;
		// int divisor = a <= b ? a : b;
		//
		// while (divisor != 0) {
		// int remainder = dividend % divisor;
		// dividend = divisor;
		// divisor = remainder;
		// }
		//
		// return dividend;
		while (b != 0) {
			int remainder = a % b;
			a = b;
			b = remainder;
		}
		return a;
	}

	public static int getGCDUsingEuclid_Recursive(int a, int b) {
		return b == 0 ? a : getGCDUsingEuclid_Recursive(b, a % b);
	}
}
