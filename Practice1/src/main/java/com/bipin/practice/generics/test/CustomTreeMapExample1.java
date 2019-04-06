package com.bipin.practice.generics.test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class CustomTreeMapExample1_EMP implements Comparable<CustomTreeMapExample1_EMP> {
	int empid;
	String name;
	int salary;

	public CustomTreeMapExample1_EMP(int empid, String name, int salary) {
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int compareTo(CustomTreeMapExample1_EMP o) {
		// return this.empid - o.empid;
		return o.empid - this.empid;
	}

	@Override
	public int hashCode() {
		return empid;
	}

	// @Override
	// public String toString() {
	// return "ID =" + empid + " NAME " + name + " SALARY" + salary;
	// }

}

public class CustomTreeMapExample1 {

	public static void main(String[] args) {
		Map<CustomTreeMapExample1_EMP, Integer> treemap = new TreeMap<>(new Comparator<CustomTreeMapExample1_EMP>() {

			@Override
			public int compare(CustomTreeMapExample1_EMP o1, CustomTreeMapExample1_EMP o2) {

				return 0;
			}

		});
		treemap.put(new CustomTreeMapExample1_EMP(1, "ABC", 1000), 20);
		treemap.put(new CustomTreeMapExample1_EMP(2, "XYZ", 2000), 25);
		treemap.put(new CustomTreeMapExample1_EMP(3, "ABCD", 3000), 30);
		for (Map.Entry<CustomTreeMapExample1_EMP, Integer> s : treemap.entrySet()) {
			System.out.println(s.getKey() + " " + s.getValue());
		}
	}

}
