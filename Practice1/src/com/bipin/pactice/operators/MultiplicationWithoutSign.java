package com.bipin.pactice.operators;

public class MultiplicationWithoutSign {

	public static void main(String[] args) {
		System.out.println(get1(15));
		System.out.println(get2(15));
		System.out.println(get3(15));
		System.out.println(get4(15));
		System.out.println();
		System.out.println(83&78);
	}

	public static int get1(int n) {
		return n << 1;
	}

	public static int get2(int n) {
		return n >> 1;
	}

	public static int get3(int n) {
		return n << 10;// Multiply by 2 , 10 times
	}

	public static int get4(int n) {
		return n >> 3;// divide by 2, 3 times
	}

	public static int getAns(int operation, int n, int times) {
		if (operation == 1) {// i.e multiply
			return n << times;// multiply by 2 , input no of times
		} else {
			return n >> times;//divide by 2 , input no of times
		}
	}
}
