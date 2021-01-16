package com.bipin.practice.hackerearrth._2018;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Capillary_21Jul_2018Test {

	@Test
	public void test() {
		Capillary_21Jul_2018 obj1 = new Capillary_21Jul_2018();
		String symbols[] = "day,hour,second,minute".split(",");
		String data[] = new String[symbols.length - 1];
		data[1] = "day = 24 hour";
		data[0] = "hour = 60 minute";
		data[2] = "minute = 60 second";
		String ans = obj1.getUnitBalancer(symbols, data);
		System.out.println(ans);
		assertEquals("1day = 24hour = 1440minute = 86400second", ans);
	}

	@Test
	public void test1() {
		Capillary_21Jul_2018 obj1 = new Capillary_21Jul_2018();
		String symbols[] = "MM,CM,M,KM".split(",");
		String data[] = new String[symbols.length - 1];
		data[1] = "KM = 1000 M";
		data[0] = "M = 100 CM";
		data[2] = "CM = 10 MM";
		String ans = obj1.getUnitBalancer(symbols, data);
		System.out.println(ans);
		assertEquals("1KM = 1000M = 100000CM = 1000000MM", ans);
	}

	@Test
	public void test2() {
		Capillary_21Jul_2018 obj1 = new Capillary_21Jul_2018();
		String symbols[] = "KL,L,GAL,ML,NL".split(",");
		String data[] = new String[symbols.length - 1];
		data[1] = "KL = 1000 L";
		data[0] = "L = 1000 ML";
		data[2] = "GAL = 10 KL";
		data[3] = "ML = 10000 NL";
		String ans = obj1.getUnitBalancer(symbols, data);
		System.out.println(ans);
		assertEquals("1GAL = 10KL = 10000L = 10000000ML = 100000000000NL", ans);
	}

	@Test
	public void testBinarySearchAsPerFirstColumn() {
		String arr[][] = { { "A", "1" }, { "B", "2" }, { "C", "3" }, { "D", "4" } };
		Capillary_21Jul_2018 obj1 = new Capillary_21Jul_2018();
		assertEquals(0, obj1.binarySearchAsPerFirstColumn(arr, "A"));
		assertEquals(1, obj1.binarySearchAsPerFirstColumn(arr, "B"));
		assertEquals(2, obj1.binarySearchAsPerFirstColumn(arr, "C"));
		assertEquals(3, obj1.binarySearchAsPerFirstColumn(arr, "D"));
		assertEquals(-1, obj1.binarySearchAsPerFirstColumn(arr, "E"));
	}

	@Test
	public void testgetOddNumberCount() {
		assertEquals(4, Capillary_21Jul_2018.getOddNumberCount(1, 8));
		assertEquals(11, Capillary_21Jul_2018.getOddNumberCount(15, 36));
		assertEquals(16, Capillary_21Jul_2018.getOddNumberCount(1, 31));
		assertEquals(500, Capillary_21Jul_2018.getOddNumberCount(1, 1000));

	}

	@Test
	public void testIsDivisibleByCountOfOddIntegers() {
		for (int i = 2; i < 500001; i = i + 2) {
			if (!Capillary_21Jul_2018.isDivisibleByCountOfOddIntegers(i)) {
				System.out.println(i);
			}
		}
	}

	@Test
	public void testsort2DBinaryArray() {
		String data1[] = { "1111", "1110", "1111", "0001" };
		int ans1 = Capillary_21Jul_2018.sort2DBinaryArray(data1, data1.length, 4);
		System.out.println(ans1);
		assertEquals(1, ans1);
		String data2[] = { "1010", "0100", "0010", "0011" };
		int ans2 = Capillary_21Jul_2018.sort2DBinaryArray(data2, data2.length, 4);
		System.out.println(ans2);
		assertEquals(1, ans2);
	}

}
