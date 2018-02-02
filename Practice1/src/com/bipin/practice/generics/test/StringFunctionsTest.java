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
		String str = "abcd"; // new String LITERAL which is interned in the pool
		String str1 = new String("abcd"); // new String, not interned: str1 != str
		String str2 = str.substring(0, 2); // new String which is a view on str
		String str3 = str.substring(0, 2); // same: str3 != str2
		String str7 = str1.substring(0, str1.length()); // special case: str1 is returned
	}

}
