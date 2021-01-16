package com.bipin.practice.generics.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		Set<Long> myset = new HashSet<>();
		Set<Long> myset1 = new TreeSet<>();
		HashSet<Integer> intset = new HashSet<>();
		LinkedHashSet<Integer> intsets = new LinkedHashSet<>();
		myset1.add(new Long(1));
		myset.add(new Long(1));

		List<String> l = new ArrayList<>(15);
		l.add(" Bipin ");
		l.add(" Bipin1 ");
		l.add(1, " Bipin2 ");
		l.get(1);
		List<Integer> l1 = new LinkedList<>();
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			intset.add(random.nextInt(5000));
		}
		l1.addAll(intset);
		for (int i : l1) {
			System.out.println(i);
		}
	}

}
