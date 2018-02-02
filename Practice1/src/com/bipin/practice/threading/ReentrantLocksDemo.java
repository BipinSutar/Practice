package com.bipin.practice.threading;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class RunnerReEntrant {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	public void firstThread() throws InterruptedException {
		lock.lock();// it will acquire lock same as sychronized block
		System.out.println("Thread 1 says Waiting ....");
		cond.await();// acts like wait method
		System.out.println("Thread 1 says  Waiting done of first");
		try {
			incrementcount();
		} finally {
			lock.unlock();
		}
	}

	private void incrementcount() throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
		Thread.sleep(100);

	}

	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("Thread 2 says Press any key!");
		new Scanner(System.in).nextLine();
		System.out.println("Thread 2 says  Got key!");
		cond.signal();
		try {
			incrementcount();
		} finally {
			lock.unlock();// try commenting this line for below explanation
			// this is mandatory after signal method .. as signal will notify just a signal
			// but not release the lock but unlock
			// method will actully will release the lock
			// if we uncomment this thread will wait till thread 2 releases the lock
		}
	}

	public void finished() {
		System.out.println("count is  " + count);
	}
}

public class ReentrantLocksDemo {

	public static void main(String[] args) {
		RunnerReEntrant re = new RunnerReEntrant();
		Thread t = new Thread(() -> {
			try {
				re.firstThread();
			} catch (InterruptedException r) {
				r.printStackTrace();
			}
		});
		Thread t1 = new Thread(() -> {
			try {
				re.secondThread();
			} catch (InterruptedException r) {
				r.printStackTrace();
			}
		});
		t.start();
		t1.start();
		try {
			t.join();
			t1.join();
			re.finished();
		} catch (InterruptedException r) {
			r.printStackTrace();
		}

	}

}
