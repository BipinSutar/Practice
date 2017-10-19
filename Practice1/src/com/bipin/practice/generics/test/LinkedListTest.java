package com.bipin.practice.generics.test;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.peekFirst();
		list.isEmpty();
		Integer a = list.pop();
		System.out.println(a);
	}

}
