package com.bipin.practice.hackarrank._2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class A {
	public int add(int a, int b) {
		return a + b;
	}
}

class SampleDemo implements Runnable {
	private Thread t;
	private String threadName;

	public SampleDemo(String threadName) {
		this.threadName = threadName;
	}

	public void run() {
		int i = 0;
		while (i < 2000) {
			System.out.println(threadName);
			i++;
		}
	}

	public void start() {
		if (t == null) {
			System.out.println("T is null");
			t = new Thread(this, threadName);
			t.start();

		}
	}
}

public class HackerrankJavaCertificationBasic extends A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.close();
		Stack s1;
		short s = 9;
		// System.out.println(add(s, 6));
		SampleDemo a = new SampleDemo("A");
		SampleDemo b = new SampleDemo("B");
		b.start();
		a.start();
	}

}
