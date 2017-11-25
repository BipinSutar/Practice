package com.bipin.practice.hackerrank.wcode35.test;

import java.util.Scanner;

public class PowerOfLasrgeNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(power(sc.nextLong(), sc.nextLong()));

	}

	public static long power(long x, long y) {
		long temp;
		if (y == 0)
			return 1;
		temp = power(x, y / 2);
		if (y % 2 == 0)
			return (temp * temp) % 1000000007;
		else {
			if (y > 0)
				temp = (x * temp * temp);
			else
				temp = ((temp * temp) / x);
		}
		return temp % 1000000007;
	}
}
