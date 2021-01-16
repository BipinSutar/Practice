package com.bipin.practice.inheritance;

public class Child extends Parent {
	private int c1, c2, c3;
	// private Parent parent;

	// public Parent getParent() {
	// return parent;
	// }
	//
	// public void setParent(Parent parent) {
	// this.parent = parent;
	// }

	public int getC1() {
		return c1;
	}

	public void setC1(int c1) {
		this.c1 = c1;
	}

	public int getC2() {
		return c2;
	}

	public void setC2(int c2) {
		this.c2 = c2;
	}

	public int getC3() {
		return c3;
	}

	public void setC3(int c3) {
		this.c3 = c3;
	}

	@Override
	@MyInterface
	public String toString() {
		return "Child [c1=" + c1 + ", c2=" + c2 + ", c3=" + c3 + ", parent=" +
		// parent +
				", toString()=" + super.toString() + "]";
	}

	@Override
	public String cal() {
		return Child.class.getName();
	}

}
