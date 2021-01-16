package com.bipin.practice.generics.test;

enum Nums {
	ONE("One"), TWO("Two"), THREE("Three", 3);
	private String value = null;
	private int key;

	private Nums(String value) {
		this.value = value;
	}

	private Nums(String value, int key) {
		this.value = value;
		this.key = key;
	}

	public String toString() {
		return this.value;
	}
}

public class EnumTest {
	public static void main(String[] args) {
		System.out.println(Nums.ONE.name() == Nums.ONE.name());
		System.out.println(Nums.THREE == Nums.THREE);
	}
}
