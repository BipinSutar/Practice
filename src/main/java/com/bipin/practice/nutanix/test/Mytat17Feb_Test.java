package com.bipin.practice.nutanix.test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class EmpDomainKey {
	int id;

	public EmpDomainKey() {
		this.id = id;
	}
}

class EmpDomain {
	String name;
	EmpDomainKey key = null;

	public EmpDomain(String name, EmpDomainKey key) {
		this.name = name;
		this.key = key;
	}

}

public class Mytat17Feb_Test {
	public static void main(String[] args) {
		main1(args);
	}
	public static void main1(String[] args) {
		System.out.println("1");
		TreeMap<EmpDomain, Integer> map = new TreeMap<>(new Comparator<EmpDomain>() {

			@Override
			public int compare(EmpDomain o1, EmpDomain o2) {

				return o1.key.equals(o2.key) ? 1 : -1;
			}

		});
		System.out.println(map.comparator());
	}
}
