package com.bipin.practice.inheritance.test;

interface Person {
	static void print() {
		System.out.println("static for person who eats");
	}

	default void print1() {
		System.out.println("Default for person who eats");
	}
}

interface Mamal {
	static void print() {
		System.out.println("Default for mamal who eats");
	}
}

abstract class PersonAbtract implements Person {
	@Override
	public void print1() {
		System.out.println("default abstract override for person who eats");
	}
}

public class InterFaceStaticMethodDemo implements Person, Mamal {

	public static void main(String[] args) {
		PersonAbtract p = new PersonAbtract() {
			@Override
			public void print1() {
				System.out.println("Default override for person who eats");
			}

		};
		p.print1();
		int a = 10;
		int b = 20;
		System.out.println("before swap a " + a + " b " + b);
		b = a + b - (a = b);
		System.out.println("after swap a " + a + " b " + b);
	}

}
