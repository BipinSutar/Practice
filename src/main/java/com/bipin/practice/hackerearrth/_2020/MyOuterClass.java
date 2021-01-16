package com.bipin.practice.hackerearrth._2020;

class MyOuterClass {
	private int x = 1;
	private String st = "Number";
	public void innerInstance() {
		MyInnerClass inner = new MyInnerClass();
		inner.seeOuter();
	}
	public static void main(String args[]) {
		MyOuterClass obj = new MyOuterClass();
		obj.innerInstance();
	}

	private class MyInnerClass {
		private void seeOuter() {
			System.out.println(st + " " + x);
		}
	}
}
