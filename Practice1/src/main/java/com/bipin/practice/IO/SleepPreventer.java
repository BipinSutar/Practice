package com.bipin.practice.IO;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;
import java.util.Set;

class SleepPreventerRunnable implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println(" Sleep Preventer running with low priority thread");
			Robot hal = new Robot();
			Random random = new Random();
			while (true) {
				hal.delay(1000 * 60);
				Thread.sleep(4000 * 60);
				int x = random.nextInt() % 640;
				int y = random.nextInt() % 480;
				hal.mouseMove(x, y);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class SleepPreventer {
	public static void main(String[] args) throws Exception {
		// SleepPreventerRunnable sr = new SleepPreventerRunnable();
		// Thread t = new Thread(sr, "Thread-SleepPreventer");
		// t.setPriority(Thread.MIN_PRIORITY);
		// t.start();
		new SleepPreventerRunnable().run();
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		for (Thread t : threadSet) {
			if (t.getThreadGroup() == Thread.currentThread().getThreadGroup()) {
				System.out.println("Thread :" + t + ":" + "state:" + t.getState());
			}
		}
		System.out.println(getThreadByName("Thread-SleepPreventer"));
	}

	public static Thread getThreadByName(String threadName) {
		for (Thread t : Thread.getAllStackTraces().keySet()) {
			if (t.getName().equals(threadName))
				return t;
		}
		return null;
	}
}
