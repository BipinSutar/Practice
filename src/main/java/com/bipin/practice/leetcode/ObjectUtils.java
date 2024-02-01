package com.bipin.practice.leetcode;

public class ObjectUtils {

	public static Object getObject(Class className) {
		Class cls;
		// className.class.getDeclaredConstructor();
		return null;

	}

	public static Object getObject(String className) {
		Class cls;
		try {
			cls = Class.forName(className);
			return cls.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
