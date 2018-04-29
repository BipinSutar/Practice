package com.bipin.practice.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ThreadNo1 extends Thread {

	@Override
	public void run() {
		System.out.println("Inside " + ThreadNo1.class.getName());
		try {
			Thread.sleep(2000);
			System.out.println("Sleeping done");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}

public class MyThreadTest {
	private Random random = new Random();
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	private void stageOne() {
		// synchronized (MyThreadTest.class) {// 4968 milliseconds
		// synchronized (this) {// 6140 milliseconds
		synchronized (lock1) {// 2980 milliseconds
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(5000));
		}

	}

	private void stageTwo() {
		// synchronized (MyThreadTest.class) {// 4968 milliseconds
		// synchronized (this) {// 4968 milliseconds
		synchronized (lock2) {// 2980 milliseconds
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(5000));

		}
	}

	private void stageTwoProblem() {
		// synchronized (MyThreadTest.class) {// 4968 milliseconds
		// synchronized (this) {// 4968 milliseconds
		synchronized (lock2) {// 2980 milliseconds // solution is change lock2 to lock1
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(5000));// problem is here

		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void main1(String[] args) {
		System.out.println("Starting");
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		long o = System.currentTimeMillis();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {

		}
		long o1 = System.currentTimeMillis();
		System.out.println("Time taken " + (o1 - o));
		System.out.println("List 1 size " + list1.size() + " List 2 size " + list2.size());
	}

	public static void main(String[] args) {
		new MyThreadTest().main1(null);
	}
}
