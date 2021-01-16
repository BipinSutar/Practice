package com.bipin.practice.hackerearrth._2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UpGrad_10Feb_Test {

	@Test
	public void testgetMinSum() {
		float a = 0;
		System.out.println(abs(a));

		int arr[] = new int[]{1, 5, 3, 2, 10};
		assertEquals(7, UpGrad_10Feb.getMinSum(arr));
		arr = new int[]{6, 12, 7, 8, 10, 15};
		assertEquals(9, UpGrad_10Feb.getMinSum(arr));
		arr = new int[]{1, 5, 10, 2, 3};
		assertEquals(8, UpGrad_10Feb.getMinSum(arr));
		arr = new int[]{1, 2, 10, 2, 3};
		assertEquals(2, UpGrad_10Feb.getMinSum(arr));
		arr = new int[]{10, 2, 5, 3, 1};
		assertEquals(7, UpGrad_10Feb.getMinSum(arr));
		arr = new int[]{1, 5, 3, 10, 2};
		assertEquals(7, UpGrad_10Feb.getMinSum(arr));
		arr = new int[]{2, 2, 2};
		assertEquals(0, UpGrad_10Feb.getMinSum(arr));
		arr = new int[]{2, 3, 2};
		assertEquals(0, UpGrad_10Feb.getMinSum(arr));
		arr = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE};
		assertEquals(0, UpGrad_10Feb.getMinSum(arr));
		arr = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE - 10,
				Integer.MAX_VALUE, Integer.MAX_VALUE - 20};
		assertEquals(20, UpGrad_10Feb.getMinSum(arr));
		arr = new int[]{20, 10, 20, 0};
		assertEquals(20, UpGrad_10Feb.getMinSum(arr));

	}
	public static float abs(float a) {
		return (a <= 0.0F) ? -a : a;
	}
	@Test
	public void testgetJumpOverThis() {
		int n = 4;
		int val[] = new int[]{1, 4, 3, 2};
		int h[] = new int[]{4, 0, 3, 2};
		int m = 2;
		int mi[] = new int[]{1, 2};
		int min_height[] = new int[]{3, 2};
		assertEquals(9,
				UpGrad_10Feb.getJumpOverThis(n, val, h, m, mi, min_height));
	}
}
