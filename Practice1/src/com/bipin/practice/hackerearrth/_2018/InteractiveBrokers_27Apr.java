package com.bipin.practice.hackerearrth._2018;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
import java.util.stream.Collectors;

class DerivedBase {
	DerivedBase() {
		System.out.println("inside " + DerivedBase.class.getName() + " constructor");
		printAll();
	}

	public void printAll() {
		System.out.println(getClass().getName() + " with " + weight);
	}

	int weight = 10;
}

class DerivedChild extends DerivedBase {
	DerivedChild() {
		System.out.println("inside " + DerivedChild.class.getName() + " constructor");
		printAll();
	}

	public void printAll() {
		System.out.println(getClass().getName() + " with " + height);
	}

	int height = 10;
}

class Person {
	int personId;
	String name;
	int age;

	Person(int pid, String name, int age) {
		this.personId = pid;
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {

		// return this.personId;
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (personId != other.personId)
			return false;
		return true;
	}

}

public class InteractiveBrokers_27Apr {

	public static void main(String[] args) {
		InteractiveBrokers_27Apr o1 = new InteractiveBrokers_27Apr();
		// o1.checkPerformaceConcat();
		System.out.println("someMethod has returned : " + o1.someMethod());
		DerivedChild d1 = new DerivedChild();
	}

	public String someMethod() {
		HashMap<Person, String> persons = new HashMap<>();
		Person p1 = new Person(1, "Bipin", 25);
		persons.put(p1, "Gorai 2, Borivali");
		return persons.get(new Person(1, "Bipin", 25));
	}

	public void checkPerformaceConcat() {
		Vector<String> v = new Vector<>();
		long limit = 2000000L;
		Random r = new Random();
		for (long i = 0; i < limit; i++) {
			v.add(r.nextInt(10000) + "10000");
		}

		String s1 = concatList_V1(v);
		String s2 = concatList_V2(v);
		String s3 = concatList_V3(v);
		String s4 = concatList_V4(v);
		String s5 = concatList_V5(v);
		// System.out.println(s2.equals(s5));
	}

	String concatList_V1(Vector<String> sList) {
		long start = System.currentTimeMillis();
		String ret = "";
		int loopcount = 0;
		Iterator<String> iter = sList.iterator();
		StringBuilder sb = new StringBuilder();
		// String sb = "";
		while (iter.hasNext()) {
			sb.append(iter.next());
			// sb += iter.next();
			loopcount++;
		}
		ret = sb.toString();
		displayTimeDiff(1, start);
		// System.out.println("loopcount of concatList_V1 " + loopcount);
		return ret;
	}

	String concatList_V2(Vector<String> sList) {
		long start = System.currentTimeMillis();
		String ret = "";
		Iterator<String> iter = sList.iterator();
		StringBuilder sb = new StringBuilder();
		int loopcount = 0;
		while (iter.hasNext()) {
			sb.append(iter.next()).append(iter.hasNext() ? iter.next() : "");
			loopcount++;
		}
		ret = sb.toString();
		displayTimeDiff(2, start);
		// System.out.println("loopcount of concatList_V2 " + loopcount);
		return ret;
	}

	String concatList_V3(Vector<String> sList) {
		// for loop
		long start = System.currentTimeMillis();
		String ret = "";
		int loopcount = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		int mid = sList.size() / 2;
		for (int i = 0, j = mid; i < mid; i++, j++) {
			sb.append(sList.get(i));
			sb1.append(sList.get(j));
			loopcount++;
		}
		ret = sb.append(sb1).toString();
		displayTimeDiff(3, start);
		// System.out.println("loopcount of concatList_V3 " + loopcount);
		return ret;
	}

	String concatList_V5(Vector<String> sList) {
		// for loop
		long start = System.currentTimeMillis();
		String ret = "";
		StringBuilder sb = new StringBuilder();
		int len = sList.size();
		int loopcount = 0;
		for (int i = 0; i < len;) {
			sb.append(sList.get(i++));
			if (i < len) {
				sb.append(sList.get(i++));
			}
			loopcount++;
		}
		ret = sb.toString();
		displayTimeDiff(5, start);
		// System.out.println("loopcount of concatList_V5 " + loopcount);
		return ret;
	}

	String concatList_V4(Vector<String> sList) {
		long start = System.currentTimeMillis();
		String str = sList.stream().collect(Collectors.joining());
		displayTimeDiff(4, start);
		return str;

	}

	public void displayTimeDiff(int version, long start) {
		System.out.println("Time by version " + version + " is " + (System.currentTimeMillis() - start));
	}

}
