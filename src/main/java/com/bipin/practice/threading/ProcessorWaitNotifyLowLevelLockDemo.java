package com.bipin.practice.threading;

import java.util.LinkedList;
import java.util.Random;

public class ProcessorWaitNotifyLowLevelLockDemo {
	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	Object lock = new Object();

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (lock) {
				while (list.size() == 10) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}

		}
	}

	public void consume() throws InterruptedException {
		Random r = new Random();
		while (true) {
			synchronized (lock) {
				System.out.print("List size is " + list.size());
				while (list.size() == 0) {
					lock.wait();
				}

				System.out.println("; value removed is " + list.removeFirst());
				lock.notify();

			}
			Thread.sleep(2000);

		}
	}

	public static void main(String[] args) {
		ProcessorWaitNotifyLowLevelLockDemo obj = new ProcessorWaitNotifyLowLevelLockDemo();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					obj.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t1 = new Thread(() -> {
			try {
				obj.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t.start();
		t1.start();

	}

}
