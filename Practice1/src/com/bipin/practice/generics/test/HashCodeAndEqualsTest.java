package com.bipin.practice.generics.test;

import java.util.HashMap;
import java.util.Map;

class Geek {
	String name;
	int id;

	public Geek(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		System.err.println("equals method called");
		// return (this == obj);
		if (this == obj) {
			System.out.println("this == obj is " + this == obj);
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		Geek geek = (Geek) obj;
		return (geek.name == this.name && geek.id == this.id);

	}

	@Override
	public int hashCode() {
		//return super.hashCode();
		 return this.id;
	}

	@Override
	public String toString() {
		return "Name " + this.name + " Id : " + this.hashCode();
	}
}

public class HashCodeAndEqualsTest {

	public static void main(String[] args) {
		Map<Geek, String> map = new HashMap<Geek, String>();
		map.put(new Geek("aditya", 1), "Comp Science");
		map.put(new Geek("aditya", 1), "IT");

		for (Geek geek : map.keySet()) {
			System.out.println(geek);
		}
	}

}
