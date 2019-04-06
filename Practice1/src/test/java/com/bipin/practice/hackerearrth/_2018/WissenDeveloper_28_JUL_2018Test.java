package com.bipin.practice.hackerearrth._2018;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WissenDeveloper_28_JUL_2018Test {

	@Test
	public void testMergeSort2dArrat() {
		int L[] = { 4, 4, 5, 4, 1, 1 };
		int R[] = { 3, 4, 4, 2, 3, 2 };
		int A[][] = new int[L.length][2];
		for (int i = 0; i < L.length; i++) {
			A[i][0] = L[i];
			A[i][1] = R[i];
		}
		int a1[][] = WissenDeveloper_28_JUL_2018.align_rectangles(L.length, L, R);
		int a2[][] = WissenDeveloper_28_JUL_2018.mergeeSort(A);
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a1[i].length; j++) {
				assertEquals(a1[i][j], a2[i][j]);
			}
		}

	}

}
