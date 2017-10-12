package com.bipin.practice.generics.test;

public class StringFunctionsTest {

	public static void main(String[] args) {
		System.out.println("dc".compareTo("ba"));

		byte[] b = "AAA".getBytes();
		for (byte bb : b) {
			System.out.print(bb + " ");

		}

		String s = "bipinsutar".substring(5);
		System.out.println(s);
		System.out.println("bipin".replace("bip", "su"));
		System.out.println(String.valueOf('a'));
	}

}
