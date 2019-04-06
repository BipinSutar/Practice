package com.bipin.practice.inheritance.test;

public interface IstaticMethods {
	public static void print(String s) {
		System.out.println(s);
	}

	public static void sum(int a, int b) {
		System.out.println("int sum is " + (a + b));
	}

	public static void sum(byte a, byte b) {
		System.out.println("byte sum is " + (a + b));
	}

	public static void sum(long a, long b) {
		System.out.println("long sum is " + (a + b));
	}
}