package com.bipin.practice.threading;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor1 implements Runnable {
	int id;

	Processor1(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting: " + id);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		System.out.println("Completed: " + id);
	}
}

public class ThreadPoolExecutorServiceProcessorDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 11; i++) {
			executor.submit(new Processor1(i));
		}
		try {
			Runtime.getRuntime()
					.exec("C:\\Program Files (x86)\\Notepad++\\notepad++.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();// stop accepting any new thread creation request
		// System.out.println("All tasks submitted");
		try {
			System.out.println("TimeUnit.DAYS.toDays(1) "
					+ TimeUnit.DAYS.toDays(1) + "  TimeUnit.DAYS "
					+ TimeUnit.DAYS + "  TimeUnit.DAYS.toString()"
					+ TimeUnit.DAYS.toString());
			executor.awaitTermination(TimeUnit.DAYS.toDays(1), TimeUnit.DAYS);
		} catch (InterruptedException e) {

		}

	}

}
