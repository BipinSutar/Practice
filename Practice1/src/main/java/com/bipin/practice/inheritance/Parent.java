package com.bipin.practice.inheritance;

public class Parent {
	private int p1, p2, p3;

	public int getP1() {
		return p1;
	}

	public void setP1(int p1) {
		this.p1 = p1;
	}

	public int getP2() {
		return p2;
	}

	public void setP2(int p2) {
		this.p2 = p2;
	}

	public int getP3() {
		return p3;
	}

	public void setP3(int p3) {
		this.p3 = p3;
	}

	@Override
	public String toString() {
		return "Parent [p1=" + getP1() + ", p2=" + getP2() + ", p3=" + getP3() + "]";
	}

	public String cal() {
		return Parent.class.getName();
	}

}
