package com.bipin.practice.generics.test;

import java.util.Map;
import java.util.TreeMap;

interface Nonneg {
	public void cal();

	public static void print() {

		System.out.println("hi from static interface");
	}
	
}

class Employee implements Comparable {
	String name;
	int id;
	int salary;

	Employee(String name, int id, int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	@Override
	public int compareTo(Object e) {
		return 0;
	}

	@Override
	public String toString() {
		return "name " + name + " id " + id + " salary " + salary;
	}
}

public class TreeMapTest {
	public static void main(String[] args) {
		Map<Employee, Integer> emap = new TreeMap<>();
		Object o = new Object();
		Nonneg nonneg = new Nonneg() {

			@Override
			public void cal() {
				Nonneg.print();

			}

		};
		nonneg.cal();
		int num = 1264598374;//21456
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int firstnum = -1;
		int numlength = 0;
		while (num > 0) {
			map.put(num % 10, num % 10);
			if (num < 10 && num > 0)
				firstnum = num;
			num = num / 10;
			numlength++;

		}
		StringBuilder ans = new StringBuilder("" + map.ceilingKey(firstnum + 1) + map.get(firstnum));
		System.out.println("firstnum " + firstnum);
		int key = map.ceilingKey(firstnum + 2);
		while (numlength > 2) {
			ans.append(map.get(key));
			if (numlength != 3)
				key = map.ceilingKey(key + 1);
			numlength--;
		}
		System.out.println(ans);
	}
}
