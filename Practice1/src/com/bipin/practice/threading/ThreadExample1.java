package com.bipin.practice.threading;

class ThreadExample1_RUNNABLE implements Runnable {
	Thread t;

	public ThreadExample1_RUNNABLE() {
		t = new Thread(this, "Data Thread");
		t.start();
	}

	@Override
	public void run() {
		System.out.println(t.getName());

	}
}

public class ThreadExample1 {

	public static void main(String[] args) {
		Thread t1 = Thread.currentThread();
		System.out.println(t1);

	}

}
