package com.bipin.practice.interviewbit;

import org.junit.jupiter.api.Test;

public class SumoLogic_17NovTest {

	@Test
	public void test() {
		int ans = SumoLogic_17Nov.getMaxChocklets(5, 10, 2, 1);
		// Assert.assertEquals(5, ans);
		ans = SumoLogic_17Nov.getMaxChocklets(3, 10, 4, 2);
		// Assert.assertEquals(2, ans);
		ans = SumoLogic_17Nov.getMaxChocklets(303, 117, 237, 367);
		// Assert.assertEquals(184, ans);
		ans = SumoLogic_17Nov.getMaxChocklets(440, 14539, 27414, 14176);
		// Assert.assertEquals(150, ans);
	}

}
