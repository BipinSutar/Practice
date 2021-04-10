package com.bipin.practice.leetcode;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) throws IOException {
		System.out.println(lengthOfLongestSubstring("pwwkew") == 3);
	}

	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> m = new HashMap<>();
		int n = s.length();
		Queue<Character> queue = new LinkedList<>();
		int len = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			while (m.containsKey(c)) {
				char head = queue.poll();
				m.remove(head);
			}
			m.put(c, null);
			queue.offer(c);
			len = Math.max(len, queue.size());

		}
		return len;
	}
}
