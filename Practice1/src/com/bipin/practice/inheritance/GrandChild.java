package com.bipin.practice.inheritance;

public class GrandChild extends Child {
	private int g1, g2;

	public int getG1() {
		return g1;
	}

	public void setG1(int g1) {
		this.g1 = g1;
	}

	public int getG2() {
		return g2;
	}

	public void setG2(int g2) {
		this.g2 = g2;
	}

	// @Override
	public String toString() {
		return "GrandChild [g1=" + g1 + ", g2=" + g2 + ", toString() =" + super.toString() + "]";
	}

	public String cal() {
		return GrandChild.class.getName();
	}
}
