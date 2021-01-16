package com.bipin.practice.hackerearrth._2019;

/**
 * 
 * @author BipinSutar </br>
 *         Q1. true</br>
 *
 */
public class DBS_June2019 {
	public static void main(String[] args) throws InterruptedException {
		Test_q2.main(args);
		Test_q3.main(args);
	}

}
class Test_q2 {
	public static void main(String[] args) throws InterruptedException {
		Test_q2 t = new Test_q2();
		t = null;
		System.gc();
		Thread.sleep(1000);
		System.out.println("End main");
	}
	@Override
	protected void finalize() {
		System.out.println("Finalize Method called");
		System.out.println(10 / 0);
	}
}
class Test_q3 {
	public static void main(String[] args) throws InterruptedException {
		try {
			test();
		} catch (RuntimeException r) {
			System.out.println("re");
		}
	}
	static void test() throws RuntimeException {
		try {
			System.out.println("test");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("ex");
		}
	}
}