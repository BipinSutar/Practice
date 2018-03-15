package com.bipin.practice.algo.greedy;

import java.util.HashSet;
import java.util.Set;

public class PrimeFactors {

	public static void main(String[] args) {
		long num = 12246324123537L;
		System.out.printf("Prime factors of number \'%d\' are : %s %n", num, primeFactors(num));

	}

	public static Set<Integer> primeFactors(long number) {
		Set<Integer> primefactors = new HashSet<>();
		long copyOfInput = number;
		Math.sqrt(number);
		int count = 0;
		for (int i = 2; i <= copyOfInput; i++) {
			count++;
			if (copyOfInput % i == 0) {
				primefactors.add(i); // prime factor
				copyOfInput /= i;
				i--;
			}
		}
		System.out.println("For looop count " + count);
		return primefactors;
	}

}
