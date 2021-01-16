package com.bipin.practice.mySirGExamples;

import static java.lang.System.*;

import java.io.IOException;

class A28 {
	static {
		out.println("A28 static block");// same as System.out.println("A28 void method"); as we have imported System.*
										// as static
		System.exit(0);
	}

	public A28() {
		out.println("A28 constructor");
	}

	/**
	 * method name same as class name and constructor name, it gets treated as
	 * different member without constructor overloading nor method overloading
	 * 
	 */
	public void A28() {
		System.out.println("A28 void method");
	}

	public void A28(int a) {
		System.out.println("A28 void method with int val as " + a);
	}
}

class A28Child extends A28 {

	public A28Child() {
		super();
	}

	public void A28() {
		super.A28(2);
	}
}

public class Example28 {
	static {
		System.out.println("Example28 static block");

		try {
			cal();
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		System.exit(0);
	}

	public static void main(String[] args) {
		out.println("Example28 first line");
		A28 a28 = new A28Child();
		out.println("Example28 third line");
		a28.A28();

	}

	private static void cal() throws IOException {
		throw new IOException();

	}

}
