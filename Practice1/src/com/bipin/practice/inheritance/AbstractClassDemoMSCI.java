package com.bipin.practice.inheritance;

interface ICusAbstractClass {
	static void show() {}
}

abstract class CusAbstractClass {
	protected String name = "bipin";

	public CusAbstractClass() {
	}

	public CusAbstractClass(String name) {
		this.name = name;
	}

	void show() {

	}

	abstract CusAbstractClass show1();
}

public class AbstractClassDemoMSCI extends CusAbstractClass {
	protected String name = "bipinSutar";

	public AbstractClassDemoMSCI() {
	}

	public AbstractClassDemoMSCI(String name) {
		System.out.println(this.name);
		this.name = name;
		System.out.println(this.name);
		System.out.println(super.name);
	}

	public static void main(String[] args) {
		CusAbstractClass cusAbstractClass = new AbstractClassDemoMSCI("ABC");
		// System.out.println(cusAbstractClass.name);

	}

	@Override
	AbstractClassDemoMSCI show1() {
		// Co variant demo
		return new AbstractClassDemoMSCI();

	}

}
