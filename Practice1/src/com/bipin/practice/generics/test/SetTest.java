package com.bipin.practice.generics.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		Set<Long> myset = new HashSet<>();
		Set<Long> myset1 = new TreeSet<>();
		myset1.add(new Long(1));
		myset.add(new Long(1));

		List<String> l = new ArrayList<>(15);
		l.add(" Bipin ");
		l.add(" Bipin1 ");
		l.add(1, " Bipin2 ");
		l.get(1);
		List<String> l1 = new LinkedList<>();
		l1.add(" Bipin ");
		l1.add(" Bipin1 ");
		l1.add(1, " Bipin2 ");
		l1.get(1);

	}

}
