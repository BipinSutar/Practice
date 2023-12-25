package com.bipin.practice.inheritance;

public class OverloadingTest {
	public static void main(String[] args) {
		AOverload a = new AOverload();
//		a.show(null);
	}
}

class AOverload {

	public void show(String s) {
		System.out.println("String " + s);
	}

	public void show(Child3InOverloadingTest s) {
		System.out.println("Object " + s);
	}
}

class ChildInOverloadingTest extends Object {
	@Override
	public String toString() {
		return "ChildInOverloadingTest []";
	}
}

class Child2InOverloadingTest extends ChildInOverloadingTest {

	@Override
	public final String toString() {
		return "Child2InOverloadingTest []";
	}

}

class Child3InOverloadingTest extends ChildInOverloadingTest {
	@Override
	public String toString() {
		return "Child3InOverloadingTest []";
	}
}
