package com.bipin.practice.hackerearrth._2019;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Pramata_04MayTest {
	Pramata_04May impl = null;
	@BeforeEach
	void setUp() {
		impl = new Pramata_04May();
	}

	@Test
	void test_getEasyMatrixPath() {
		char matrix[][] = new char[2][2];
		matrix[0] = new char[]{'d', 'b'};
		matrix[1] = new char[]{'c', 'a'};
		assertEquals("abd", impl.getEasyMatrixPath(matrix));
	}
	@Test
	void test_getEasyMatrixPath1() {
		char matrix[][] = new char[3][5];
		matrix[0] = new char[]{'d', 'z', 'x', 'w', 'w'};
		matrix[1] = new char[]{'y', 'b', 'l', 'w', 'w'};
		matrix[2] = new char[]{'k', 'z', 'a', 'w', 'w'};
		assertEquals("abdlwwz", impl.getEasyMatrixPath(matrix));
	}
	@Test
	void test_getEasyMatrixPath2() {
		char matrix[][] = new char[5][3];
		matrix[0] = new char[]{'d', 'z', 'x'};
		matrix[1] = new char[]{'y', 'b', 'l'};
		matrix[2] = new char[]{'k', 'z', 'a'};
		matrix[3] = new char[]{'k', 'z', 'w'};
		matrix[4] = new char[]{'k', 'z', 'w'};
		assertEquals("abdlwwz", impl.getEasyMatrixPath(matrix));
	}
	@Test
	void test_fun() {
		long a[] = new long[]{10, 50, 56};
		assertEquals("abdlwwz", impl.fun(a, 0));
	}
}
