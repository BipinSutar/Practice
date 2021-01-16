package com.bipin.practice.designPatterns;

class Phone {
	private int ram, memory, price;
	private String os, processor;

	Phone(int ram, int memory, int price, String os, String processor) {
		this.ram = ram;
		this.memory = memory;
		this.price = price;
		this.os = os;
		this.processor = processor;
	}

	@Override
	public String toString() {
		return "Phone [ram=" + ram + ", memory=" + memory + ", price=" + price + ", os=" + os + ", processor="
				+ processor + "]";
	}

}

class PhoneBuilder {
	private int ram, memory, price;
	private String os, processor;

	public PhoneBuilder setRam(int ram) {
		this.ram = ram;
		return this;
	}

	public PhoneBuilder setMemory(int memory) {
		this.memory = memory;
		return this;
	}

	public PhoneBuilder setPrice(int price) {
		this.price = price;
		return this;
	}

	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;
	}

	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}

	public Phone getPhone() {
		return new Phone(ram, memory, price, os, processor);
	}

}

public class PhoneBuilderTest {

	public static void main(String[] args) {
		Phone moto = new PhoneBuilder().setMemory(2).setOs("Android").setRam(1).getPhone();
		System.out.println(moto);
	}

}
