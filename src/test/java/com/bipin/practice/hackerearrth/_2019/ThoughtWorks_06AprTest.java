package com.bipin.practice.hackerearrth._2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThoughtWorks_06AprTest {
	ThoughtWorks_06Apr instance = new ThoughtWorks_06Apr();
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_getStringSimplificationCount() {
		assertEquals(2, instance.getStringSimplificationCount("aabbccaa", 2));
		assertEquals(1,
				instance.getStringSimplificationCount("aaabbbbbbaaa", 2));
	}
	@Test
	public void test_getGameOfStairsAns() {
		int height[] = new int[]{3, 7, 9, 10, 1, 2};
		int steps[] = new int[]{1, 1, 3, 2, 5, 1};
		assertEquals("3 3 9 7 10 1 ",
				instance.getGameOfStairsAns(6, height, steps));
	}
}
