package com.bipin.practice.generics.test;

import java.util.HashMap;
import java.util.Map;

interface IMSIC {
	final int a = 10;
}

class EmployeeMSCI {
	int id;
	String name;
	int salary;

	EmployeeMSCI(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return "id " + id + " name " + name + " salary " + salary;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals method called " + ((EmployeeMSCI) obj).toString());
		// return (this == obj);
		if (this == obj) {
			System.out.println("this == obj is " + this == obj);
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		EmployeeMSCI emsci = (EmployeeMSCI) obj;
		return (emsci.name == this.name && emsci.id == this.id && emsci.salary == this.salary);

	}

	@Override
	public int hashCode() {
		// return super.hashCode();
		return this.id;
	}
}

public class HashMapDemoMSCI {

	public static void main(String[] args) {
		EmployeeMSCI e1 = new EmployeeMSCI(0, "ABC", 2000);
		EmployeeMSCI e2 = new EmployeeMSCI(1, "ABC", 2000);
		// EmployeeMSCI e3 = new EmployeeMSCI(2, "ABC", 2000);
		Map<EmployeeMSCI, Integer> emap = new HashMap<>(20);
		emap.put(e1, 1);
		emap.put(e2, 2);
		// emap.put(e3, 3);
		e1.id = 1;
		System.out.println(emap.get(e1) + " " + emap.size());
		System.out.println("salary of e1 and e2 are different hance null op");
		for (EmployeeMSCI e : emap.keySet()) {
			// System.out.println(e + " " + emap.get(e));
		}
	}

}
