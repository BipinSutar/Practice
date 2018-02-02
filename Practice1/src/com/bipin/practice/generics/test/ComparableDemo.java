package com.bipin.practice.generics.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

class Entity implements Comparable<Entity> {
	int key, value;

	Entity(int key, int value) {
		this.key = key;
		this.value = value;

	}

	@Override
	public String toString() {
		return "key = " + this.key + " value = " + this.value;
	}

	@Override
	public int compareTo(Entity o) {
		return this.key - o.key;
	}

}

public class ComparableDemo {

	public static void main(String[] args) {
		List<Entity> list = new ArrayList<Entity>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(new Entity(rand.nextInt(31) + 5, rand.nextInt(60) + 35));
		}
		for (Entity e : list) {
			System.out.println(e);
		}
		System.out.println();
		Collections.sort(list, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				return ((Entity) o1).key - ((Entity) o2).key;
			}

		});
		for (Entity e : list) {
			System.out.println(e);
		}
	}

	public static void comparePerfoamanceOfList() {
		StringBuilder sb = new StringBuilder("bipinSutarF");
		System.out.println(sb.toString());// to string method present in StringBuilder class
		List<Entity> arraylist = new ArrayList<Entity>();
		List<Entity> vector = new Vector<Entity>();
		List<Entity> linkedlist = new LinkedList<Entity>();
		long o = System.currentTimeMillis();
		for (int i = 0; i < 4000000; i++) {
			arraylist.add(new Entity(i, i + 1));
		} // fast
		long o1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			vector.add(0, new Entity(i, i + 1));
		} // faster
		long o2 = System.currentTimeMillis();
		for (int i = 0; i < 4000000; i++) {
			linkedlist.add(new Entity(i, i + 1));
		} // fastest
		long o3 = System.currentTimeMillis();
		System.out.println(o1 - o);
		System.out.println(o2 - o1);
		System.out.println(o3 - 02);
	}

}
