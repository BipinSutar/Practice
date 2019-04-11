package com.bipin.practice.hackerearrth._2019;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.bipin.practice.hackerearrth._2019.Wissen_06Apr.SubArrayPositionAns;

class Wissen_06AprTest {
	Wissen_06Apr instance = new Wissen_06Apr();
	@Test
	void test_getSubArrayPositionAns() {
		assertEquals(0, instance.getSubArrayPositionAns(new int[0]).size());
		int arr[] = new int[]{3, 4, 2};
		Set<SubArrayPositionAns> actualList = instance
				.getSubArrayPositionAns(arr);
		assertTrue(actualList.contains(instance.new SubArrayPositionAns(1, 2)));
		assertTrue(actualList.contains(instance.new SubArrayPositionAns(1, 3)));
		assertTrue(actualList.contains(instance.new SubArrayPositionAns(2, 2)));
		assertTrue(actualList.size() == 3);
	}
	@Test
	void test_getSubArrayPositionAns1() {
		int sameElement = 1;
		int arr[] = new int[]{sameElement, sameElement, sameElement,
				sameElement, sameElement, sameElement, sameElement, sameElement,
				sameElement, sameElement, sameElement, sameElement,
				sameElement};
		Set<SubArrayPositionAns> actualList = instance
				.getSubArrayPositionAns(arr);
		assertTrue(actualList.contains(
				instance.new SubArrayPositionAns(sameElement, arr.length)));
		assertTrue(actualList.size() == 1);
		sameElement = 2;
		arr = new int[]{sameElement, sameElement, sameElement, sameElement,
				sameElement, sameElement, sameElement, sameElement, sameElement,
				sameElement, sameElement, sameElement, sameElement, sameElement,
				sameElement, sameElement};
		actualList = instance.getSubArrayPositionAns(arr);
		assertTrue(actualList.contains(
				instance.new SubArrayPositionAns(1, arr.length)));
		assertTrue(actualList.size() == 1);

	}
}
