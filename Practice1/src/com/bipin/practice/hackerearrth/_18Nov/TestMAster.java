package com.bipin.practice.hackerearrth._18Nov;

import java.util.Set;
import java.util.TreeSet;

class A {
	int i;

	A(int i) {

	}

	private static void move() {
		System.out.println("A");
		throw new RuntimeException();
	}
}

public class TestMAster {
	public static void main(String[] args) {
		try {
			System.out.println("0");
			System.exit(0);
			move();
			System.out.println("a");
		} finally {
			System.out.println("f");
		}
		System.exit(0);
		Set s = new TreeSet();
		boolean b[] = new boolean[5];
		b[0] = s.add("a");
		b[1] = s.add(new Integer(2));
		b[2] = s.add("b");
		b[3] = s.add("a");
		b[4] = s.add(new Object());
		for (int i = 0; i < 5; i++) {
			System.out.print(b[i] + " ");
		}

	}

	private static void move() {
		throw new RuntimeException();
	}

	public static void a() {
		throw new RuntimeException();
	}

}
