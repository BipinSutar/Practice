package com.bipin.practice.inheritance.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RepeatedWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Ravi had been saying that he had been there";
		System.out.println(getFirstRepeatedWord(input));
	}

	private static char[] getFirstRepeatedWord(String in) {
		Map<String, Integer> data = new HashMap<String, Integer>();
		String[] split_in = in.split(" ");
		for (int i = 0; i < split_in.length; i++) {
			
		}
		
		
		return null;
	}

}
