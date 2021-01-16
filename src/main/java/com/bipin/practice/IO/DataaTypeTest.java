package com.bipin.practice.IO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DataaTypeTest implements Serializable {
	@Override
	public String toString() {
		return 0 + "";
	}

	@MyCustomAnnotation
	public int cal() {
		return 0;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1060303368955804698L;

	public static void main(String[] args) {
		int a = 3;
		Object o = a + 5 + " bipin" + 'v' / 2;
		System.out.println(o);
		System.out.println("bipin".replace("i", ""));
		int i = 5;
		Integer ii = new Integer(i);// Boxing..
		Integer jj = i;// AutoBoxing
		int j = jj.intValue();// Unboxing
		int kk = jj;// AutoUnboxing
		Map<String, Integer> map = new HashMap<String, Integer>();

	}

}
