package com.bipin.practice.threading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Processor extends Thread {
	private volatile boolean running = true;

	@Override
	public void run() {
		while (running) {
			try {
				Thread.sleep(1);
				System.out.println("rrr....");
			} catch (InterruptedException e) {

			}
		}

	}

	public void stopProcess() {
		running = false;
	}
}

public class VolatieDemo {

	public static void main(String[] args) throws IOException {
		Processor p = new Processor();
		p.start();
		new BufferedReader(new InputStreamReader(System.in)).readLine();
		p.stopProcess();

	}

}
