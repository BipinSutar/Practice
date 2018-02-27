package com.bipin.practice.inheritance;

import java.io.IOException;

class MyCustomException extends IOException {
	MyCustomException() {
		super();
	}

	MyCustomException(String s) {
		super(s);
	}
}

class EParent {

	public void print() {
		System.out.println("Eparent does not declare exception");
	}

	public void print(int data) throws IOException {
		System.out.println("EParent throws Exception with data " + data);
		throw new IOException(data + "");
	}
}

class EChild extends EParent {
	@Override
	public void print() throws RuntimeException {
		System.out.println("Eparent does not declare exception");
	}

	@Override
	public void print(int data) throws IOException {
		System.out.println("EParent throws Exception with data " + data);
	}
}

public class ExceptionsOverridingDemo {

	public static void main(String[] args) {
		System.out.println(new ExceptionsOverridingDemo().checkFinally());
		String bipin = "bipin";
		System.out.println(bipin.codePointAt(0) + " " + bipin.codePointBefore(2) + " " + bipin.codePoints() + " "
				+ bipin.codePoints().count() + " " + bipin.codePointCount(0, bipin.length()));
	}

	public int checkFinally() {
		int i = 5;
		try {
			System.exit(0);
			return i;
		} catch (IndexOutOfBoundsException | ArithmeticException re) {
			return i + 10;
		} finally {

			i = i + 31;// will make i = 36 but will return 5
			return i;// will make i = 36 and will return 36

		}
	}
}
