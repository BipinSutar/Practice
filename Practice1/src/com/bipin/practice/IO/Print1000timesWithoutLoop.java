package com.bipin.practice.IO;

public class Print1000timesWithoutLoop {
	public void p1() {
		System.out.println("Bipin");
	}

	public void p3() {
		p1();
		p1();
		p1();
	}

	public void p10() {
		p3();
		p3();
		p3();
		p1();
	}

	public void p30() {
		p10();
		p10();
		p10();
	}

	public void p100() {
		p30();
		p30();
		p30();
		p10();
	}

	public void p300() {
		p100();
		p100();
		p100();
	}

	public void p1000() {
		p300();
		p300();
		p300();
		p100();
	}

	public static void main(String[] args) {
		System.out.println(String.format("%020d", 0));
		System.out.print(String.format("%020d", 0).replace("0", "Shreyash\n"));
		new Print1000timesWithoutLoop().p30();
		method(null);

	}

	public static void method(Object o) {
		System.out.println("Object impl");
	}

	public static void method(String s) {
		System.out.println("String impl");
		long longWithL = 1000 * 60 * 60 * 24 * 365L;
		long longWithoutL = 1000 * 60 * 60 * 24 * 365;
		System.out.println(longWithL);
		System.out.println(longWithoutL);
	}

}
