package com.bipin.practice.IO;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;
import java.awt.MouseInfo;
//To Compile mvn clean install -Dmaven.test.skip=true
class SleepPreventerRunnable implements Runnable {
public static final int ONE_SECOND = 1000;
public static final int ONE_MINUTE = 60 * ONE_SECOND;
public static final int moveby = 2;
private boolean flag = false;
	@Override
	public void run() {
		try {
			System.out.println(" Sleep Preventer running with low priority thread");
			Robot hal = new Robot();	
			boolean flag_upward = false;
			while (true) {
				Thread.sleep(ONE_MINUTE * 2);
				int x = MouseInfo.getPointerInfo().getLocation().x;
				int y = MouseInfo.getPointerInfo().getLocation().y;
				if(flag_upward){
					hal.mouseMove(x - moveby, y - moveby);	
				}else{
					hal.mouseMove(x + moveby, y + moveby);	
				}
				flag_upward = !flag_upward;				
				
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
