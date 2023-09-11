package com.bipin.practice.inheritance;

public class StringCastExamplesDemo {

	public static void main(String[] args) {
		main1();
		main2();
		main3();
	}

	public static void main1() {
		String str = "Hello World";
		/*
		 * StringBuilder sb = (StringBuilder) str; System.out.println(sb); // compile
		 * time error
		 */

	}

	public static void main2() {
		String str = new String("Hello World");
		/*
		 * StringBuilder sb = (Object) str; System.out.println(sb); // compile time
		 * error
		 */
	}

	public static void main3() {
		Object str = new String("Hello World");
//		StringBuilder sb = (StringBuilder) str; // classCastException
		String str1 = (String) str;
		System.out.println(str1);

		/*
		 * String s = (String) new Object(); // classCastException
		 * System.out.println(s);
		 */

		Object1 o1 = (Object1) new Object();
	}

}

class Object1 extends Object {

}
