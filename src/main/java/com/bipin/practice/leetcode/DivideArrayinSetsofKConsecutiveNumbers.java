package com.bipin.practice.leetcode;

import java.util.TreeMap;

public class DivideArrayinSetsofKConsecutiveNumbers {
	public static void main(String[] args) {
		int nums[] = new int[]{15, 16, 17, 18, 19, 16, 17, 18, 19, 20, 6, 7, 8,
				9, 10, 3, 4, 5, 6, 20};
		int k = 5;
		System.out.println(new DivideArrayinSetsofKConsecutiveNumbers()
				.isPossibleDivide(nums, k));
	}
	public boolean isPossibleDivide(int[] nums, int k) {
		if ((nums.length % k) != 0) {
			return false;
		}
		TreeMap<Integer, Integer> m = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (m.containsKey(nums[i])) {
				m.put(nums[i], m.get(nums[i]) + 1);
			} else {
				m.put(nums[i], 1);
			}
		}
		System.out.println(m);
		// Arrays.sort(nums);
		while (!m.isEmpty()) {
			int fE = m.firstKey();
			removeFreq(m, fE);
			for (int i = 1; i < k; i++) {
				int next = fE + i;
				if (m.containsKey(next)) {
					removeFreq(m, next);
				} else {
					return false;
				}
				System.out.println(m);
			}
		}
		return true;

	}
	public void removeFreq(TreeMap<Integer, Integer> m, int key) {
		if (m.containsKey(key)) {
			if (m.get(key) > 1) {
				m.put(key, m.get(key) - 1);
			} else {
				m.remove(key);
			}
		}
	}
}
