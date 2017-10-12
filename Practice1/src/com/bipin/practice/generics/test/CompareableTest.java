package com.bipin.practice.generics.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Movie implements Comparable<Movie> {
	int releaseYear, ratings;
	String name;

	@Override
	public int compareTo(Movie o) {

		return this.releaseYear - o.releaseYear;
	}

	@Override
	public String toString() {
		return "Movie [releaseYear=" + releaseYear + ", ratings=" + ratings + ", name=" + name + "]";
	}

}

class Student {
	int rollno;
	String name, address;

	Student(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", address=" + address + "]";
	}

}

class SortByRollno implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {

		return o1.rollno - o2.rollno;
	}

}

class SortByNameAsc implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {

		return o1.name.compareTo(o2.name);
	}

}

class SortByNameDsc implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {

		return o2.name.compareTo(o1.name);
	}

}

public class CompareableTest {

	public static void main(String[] args) {
		ArrayList<Student> ar = new ArrayList<Student>();
		ar.add(new Student(111, "bbbb", "london"));
		ar.add(new Student(131, "aaaa", "nyc"));
		ar.add(new Student(121, "cccc", "jaipur"));

		System.out.println("Unsorted");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar, new SortByRollno());

		System.out.println("\nSorted by rollno");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar, new SortByNameAsc());

		System.out.println("\nSorted by name");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar, new SortByNameDsc());

		System.out.println("\nSorted by name desc");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

	}

}
