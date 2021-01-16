package com.bipin.practice.IO;

public class DataTypeInternal {

	public static void main(String[] args) {
		Class<Integer> a = int.class;
		Class<Integer> b = Integer.TYPE;
		Class<Integer> c = Integer.class;

		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		System.out.println(System.identityHashCode(c));
		System.out.println("Integer.TYPE == int.class " + (Integer.TYPE == int.class));
		System.out.println("Integer.TYPE == Integer.class " + (Integer.TYPE == Integer.class));
	}

}
