package com.bipin.practice.hackerrank.wcode35.test;

import java.util.HashMap;
import java.util.Map;

public class AnagramDemoTest {

	public static void main(String[] args) {
		System.out.println(new AnagramDemoTest().checkAnagram("bipin", "ipibn"));
	}

	public static int cal() {
		return 0;
	}

	public boolean checkAnagram(String s, String f) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.codePointCount(0, s.length()); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else
				map.put(s.charAt(i), 1);
		}
		for (int i = 0; i < f.codePoints().count(); i++) {
			if (map.containsKey(f.charAt(i))) {
				map.put(f.charAt(i), map.get(f.charAt(i)) - 1);
			} else {
				return false;
			}
		}

		for (int count : map.values()) {
			if (count != 0)
				return false;
		}
		return true;
	}
}
