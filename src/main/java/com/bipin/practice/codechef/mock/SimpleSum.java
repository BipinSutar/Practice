package com.bipin.practice.codechef.mock;

public class SimpleSum {

	public static void main(String[] args) {
		int n = 10000;

		for (int ni = 1; ni <= n; ni++) {
			int sum = 0;
			for (int i = 1; i <= ni; i++) {
				sum += (ni / getGCDUsingEuclid_Recursive(i, ni));
			}
			//System.out.println(ni + " " + sum);
		}
	}

	public static int getGCDUsingEuclid_Recursive(int a, int b) {
		return b == 0 ? a : getGCDUsingEuclid_Recursive(b, a % b);
	}
}
