package com.bipin.practice.generics.test;

import java.util.ArrayList;
import java.util.List;

interface MySet<T> {
	public boolean add(T t);
	public boolean remove(T t);
}
class MyHashSet<T> implements MySet<T> {
	List<T> list = new ArrayList<>();
	T values [] = (T[]) new Object[16];
	@Override
	public boolean add(T t) {
		for (T obj : list) {
			if (obj != null && obj.hashCode() == t.hashCode()
					&& obj.equals(t)) {
				return false;
			}
		}
		return list.add(t);
	}
	@Override
	public boolean remove(T t) {
		for (T obj : list) {
			if (obj != null && obj.hashCode() == t.hashCode()
					&& obj.equals(t)) {
				return false;
			}
		}
		return list.remove(t);

	}
}

public class MyCustomSetTest {
	public static void main(String[] args) {
		MySet<Integer> set = new MyHashSet<>();
		System.out.println(set.add(1));
		System.out.println(set.add(2));
		System.out.println(set.add(2));
		System.out.println(set.add(3));
	}
}
