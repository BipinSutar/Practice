package com.bipin.practice.inheritance.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

class A {

}

interface B {

}

class C extends A implements B {
	int x;

	// final C() {// Q8
	//
	// }

	C(int x) {
		x = x;// Q6
	}

	void Q22() {
		int a = 100;
		int b = 0;
		try {
			int temp = a / b;
		} catch (Exception e) {
		}
	}
}

class D implements B { // Q18
	A a = new A();
	// C c = new C();
	D d = new D();
}

public class FocusInfotectMcq {

	public static void main(String[] args) {
		star(5);
		checkAssertions(5);
		checkAssertions(21);
		System.exit(0);
		// Q20();
		// Q21();
		// Q25Test q25Test1 = new Q25Test();
		// Q25Test q25Test2 = new Q25Test();
		// q25Test1.incrmtAll();
		// System.out.println(++q25Test2.x);
		// new Q29Test().computeTreeMap();
		// new Q28Test().compteArrayList();
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		HashMap<Character, Character> data = new HashMap<Character, Character>();
		while (n-- > 0) {
			String lines[] = sc.nextLine().split(" ");
			data.put(lines[0].charAt(0), lines[1].charAt(0));
			// data.put(lines[1].charAt(0), lines[0].charAt(0));
		}
		String in = sc.nextLine();
		String temp = new String(in);
		for (int i = 0; i < in.length(); i++) {
			char ch = in.charAt(i);
			Character obj = data.get(ch);
			if (obj != null) {
				temp = in.replace(ch, obj.charValue());
				// temp = in.replace(obj.charValue(), ch);
			}

		}
		System.out.println(temp);

		sc.close();
	}

	private static void Q2() {
		int j = 5;
		for (int i = 0; i <= 5; i++) {
			if (i < j--)
				System.out.print(i * j + " ");
		}
	}

	private static void star(int i) {
		if (i > 1) {
			star(i / 2);
			star(i / 2);
		}
		System.out.println("Hello");
	}

	private static void checkAssertions(int a) {
		assert (a >= 0 && a <= 20) : "Invalid number from checkAssertions "
				+ FocusInfotectMcq.class.getName();

	}

	private static void Q20() {
		String str = "mumbai is nice city to live";
		str.concat(".com");
		str = str.toUpperCase();
		str.replaceFirst("is", "was");
		System.out.println(str);
		String strQ15 = "Hello from java , how you doing?";// Q15
		System.out.println(strQ15.substring(11));
	}

	private static void Q21() {
		String str = "java";
		String str1 = new String("java");
		System.out.print((str == str1) + " " + (str.equals(str1)) + " "
				+ (str.compareTo(str1)));
	}

}

class Parent {
	int an = 100;

	public void show() { // Q17
		System.out.println("printing parent");
	}
}

class Child extends Parent {
	// void show() {// Q17 answer is compilation fails;
	//
	// }
}

class MyParent {
	void show() throws RuntimeException {

	}
}

class Q25Test {
	static int x = 100;// Q25

	Q25Test() {

	}

	void incrmtAll() {
		x++;
	}

	void show() {
		System.out.println("in class Q25Test");
	}
}

class Q29Test {
	void computeTreeMap() {// Q29
		TreeMap<Integer, String> tm = new TreeMap<>();
		tm.put(1, "A");
		tm.put(2, "B");
		tm.put(3, "C");
		tm.put(4, "D");
		System.out.println("tm is " + tm);
		System.out.println("tm.entrySet() is " + tm.entrySet());
	}
}

class Q28Test {
	void compteArrayList() {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(1, 4);
		System.out.println(al);

	}
}