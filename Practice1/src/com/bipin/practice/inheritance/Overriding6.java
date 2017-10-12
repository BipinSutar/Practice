package com.bipin.practice.inheritance;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

/*
 *
 * @author bsutar
 **/
class A {
	int data1 = 10;

	void show1() {
		System.out.println("In A=" + data1);
	}
}

class B extends A {
	int data2 = 20;

	void show1() {
		System.out.println("In B=" + data2);
	}

}

public class Overriding6 {
	public static void main(String args[]) {
		A a = new B();
		System.out.println("Data1=" + a.data1);
		//gfggSystem.out.println("Data2=" + a.data2);
		a.show1();
		a.show1();
	}
}