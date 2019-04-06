package com.bipin.practice.algo;

public class GSTest {

	public static void main(String[] args) {
		System.out.println(cal(1000));
	}

	public static boolean cal(int n) {
		while (n % 10 == 0) {
			n /= 10;
		}
		return n == 1;
	}
}
