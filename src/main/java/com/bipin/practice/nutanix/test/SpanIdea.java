package com.bipin.practice.nutanix.test;

import static com.bipin.practice.nutanix.test.Ab2.show;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

class Ab1 {
	static void show() {
		System.out.println("In Ab1 show");
	}
}

class Ab2 extends Ab1 {
	static void show() {
		System.out.println("In Ab2 show");
	}
}

public class SpanIdea {

	public static void main(String[] args) {
		Date q = new Date(System.currentTimeMillis());
		java.util.Date uq = new java.util.Date();
		System.out.println(uq + " ** " + q);
		show();
		Set<Integer> a = new HashSet<>();
		a.add(1);
	}

}
