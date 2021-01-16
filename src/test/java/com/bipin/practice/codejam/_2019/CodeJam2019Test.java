package com.bipin.practice.codejam._2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bipin.practice.codejam._2019.CodeJam2019.ForegeoneAns;

class CodeJam2019Test {
	CodeJam2019 instance = new CodeJam2019();
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_getForegeoneAns() {
		ForegeoneAns ans = instance.getForegeoneAns("94841");
		assertEquals(94841,
				(Long.parseLong(ans.getL())) + (Long.parseLong(ans.getR())));
		ans = instance.getForegeoneAns("90909");
		assertEquals(90909,
				(Long.parseLong(ans.getL())) + (Long.parseLong(ans.getR())));
		ans = instance.getForegeoneAns("40000000000000945");
		assertEquals(40000000000000945L,
				(Long.parseLong(ans.getL())) + (Long.parseLong(ans.getR())));
		ans = instance.getForegeoneAns("94000004400");
		assertEquals(94000004400L,
				(Long.parseLong(ans.getL())) + (Long.parseLong(ans.getR())));
		ans = instance.getForegeoneAns("912335600000400");
		assertEquals(912335600000400L,
				(Long.parseLong(ans.getL())) + (Long.parseLong(ans.getR())));
	}
	@Test
	public void test_getYouCanGoYourOwnWay() {
		//assertEquals("EESSSESE", instance.getYouCanGoYourOwnWay(5, "SEEESSES"));
		assertEquals("ES", instance.getYouCanGoYourOwnWay(2, "SE"));
		assertEquals("SE", instance.getYouCanGoYourOwnWay(2, "ES"));
		assertEquals("SEEESSES", instance.getYouCanGoYourOwnWay(5, "EESSSESE"));
	}
}
