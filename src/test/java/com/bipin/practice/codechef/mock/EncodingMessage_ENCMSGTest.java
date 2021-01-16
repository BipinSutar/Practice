package com.bipin.practice.codechef.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EncodingMessage_ENCMSGTest {

	@Test
	public void testgetRepacedCharAsPerStep2() {
		for (int i = 97; i < 97 + 26; i++) {
			System.out
					.println("In " + (char) i + " out " + EncodingMessage_ENCMSG
							.getRepacedCharAsPerStep2((char) i));
			// assertEquals((char) i,
			// EncodingMessage_ENCMSG.getRepacedCharAsPerStep2((char)
			// i));
		}

	}

	@Test
	public void testgetEncodedMessage() {
		System.out
				.println(EncodingMessage_ENCMSG.getEncodedMessage("sharechat"));
		assertEquals("shizxvzsg",
				EncodingMessage_ENCMSG.getEncodedMessage("sharechat"));
		System.out.println(EncodingMessage_ENCMSG.getEncodedMessage("chef"));
		assertEquals("sxuv", EncodingMessage_ENCMSG.getEncodedMessage("chef"));
	}

}
