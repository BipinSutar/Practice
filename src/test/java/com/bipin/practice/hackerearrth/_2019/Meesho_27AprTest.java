package com.bipin.practice.hackerearrth._2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Meesho_27AprTest {
	Meesho_27Apr impl = null;
	// method tested

	@BeforeEach
	void setUp() throws Exception {
		impl = new Meesho_27Apr();
	}
	@Test
	void test_getXPartitioned() {
		int exp = 0;
		String s = "1000000000000000000";
		String s_arr[] = new String[100000];
		for (int i = 0; i < s_arr.length; i++) {
			s_arr[i] = s;
		}
		long st = System.currentTimeMillis();
		assertEquals(exp, impl.getXPartitioned(s_arr));
		long end = System.currentTimeMillis();
		System.out.println(end - st);

	}
	@Test
	void test_getXPartitioned_1() {
		int exp = 2;
		String s_arr[] = new String[]{"2", "2", "1", "2", "2"};
		long st = System.currentTimeMillis();
		assertEquals(exp, impl.getXPartitioned(s_arr));
		long end = System.currentTimeMillis();
		System.out.println(end - st);

	}

}
