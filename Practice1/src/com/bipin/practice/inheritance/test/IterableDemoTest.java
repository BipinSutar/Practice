package com.bipin.practice.inheritance.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.sun.swing.internal.plaf.metal.resources.metal;

class ITEmp implements Iterable<ITEmp> {
	ArrayList<ITEmp> lists;

	@Override
	public Iterator<ITEmp> iterator() {
		lists = new ArrayList<>();
		return lists.iterator();
	}

}

public class IterableDemoTest {

	public static void main(String[] args) {
		System.out.println(new ITEmp() {

		}.iterator());
	}

}
