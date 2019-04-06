package com.bipin.practice.threading;

public class Starter extends Thread {
	int x = 2;

	public static void main(String[] args) throws Exception {
		new Starter().makeItSo();
	}

	public Starter() {
		System.out.println("IN Starter");
		x = 5;
		start();
	}

	public void run() {
		System.out.println("IN run");
		x *= 2;
		// new Starter().start();
	}

	public void makeItSo() throws Exception {
		// join();
		System.out.println("IN makeItSo");
		x = x - 1;
		System.out.println("X " + x);
	}
}
