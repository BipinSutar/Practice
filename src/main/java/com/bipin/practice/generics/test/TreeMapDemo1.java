package com.bipin.practice.generics.test;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo1 {

	public static void main(String[] args) {
		TreeMap<Integer, Integer> tmap = new TreeMap<>();
		tmap.put(2, 20);
		tmap.put(1, 20);
		tmap.put(5, 20);
		tmap.put(3, 20);
		tmap.put(4, 20);
		tmap.put(9, 20);
		tmap.put(6, 20);
		for (Map.Entry<Integer, Integer> m : tmap.entrySet()) {
			tmap.put(m.getKey(), m.getKey() * 10);
			System.out.println(m.getKey() + "    " + m.getValue());
		}
		System.out.println("ceilingKey " + tmap.ceilingKey(7));
		System.out.println("floorKey " + tmap.floorKey(7));

	}

}
