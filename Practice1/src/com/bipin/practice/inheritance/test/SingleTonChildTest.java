package com.bipin.practice.inheritance.test;

class SingleTonParent {
	private SingleTonParent() {
	}
}

class SingleTonChild extends SingleTonParent {
	SingleTonChild() {
	}
}

public class SingleTonChildTest {

	public static void main(String[] args) {

	}
}
