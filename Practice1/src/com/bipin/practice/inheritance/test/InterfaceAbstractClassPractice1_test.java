package com.bipin.practice.inheritance.test;

interface ICustomParent1 {
	public String doSomething();

	public int getInt();
}

abstract class CustomParent1_Impl1 implements ICustomParent1 {

}

class CustomParent1_Impl2 extends CustomParent1_Impl1 {
	@Override
	public String doSomething() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInt() {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class InterfaceAbstractClassPractice1_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
