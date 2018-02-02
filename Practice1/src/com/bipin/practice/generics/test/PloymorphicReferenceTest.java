package com.bipin.practice.generics.test;

class Animal {
	String type = "Animal";

	public void showDetail() {
		System.out.println("I'm animal");
	}
}

class Dog extends Animal {
	String type = "Dog";

	@Override
	public void showDetail() {
		System.out.println("I'm Dog");
	}

	public void printWhaIAte() {
		System.out.println("Pedigree, Chicken");
	}

	public int getSum(short a, short b) {
		System.out.println("Short version");
		return 10;
	}

	public int getSum(int a, int b) {
		System.out.println("int version");
		return 5;
	}

}

public class PloymorphicReferenceTest {

	public static void main(String[] args) {
		Animal p = new Dog();
		p.showDetail();
		System.out.println(p.type);
		// p.printWhatIAte();

		Dog g = (Dog) p;
		System.out.println(g.type);
		g.printWhaIAte();
		byte a = (byte) (128 + 128), b = 15;
		short a1 = 3, a2 = 4;
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(a);
		System.out.println(g.getSum(a, b));
		System.out.println(g.getSum(a, a1));
		System.out.println(g.getSum(a1, a2));
		new Object().notify();
		new Object().notifyAll();
	}

}
