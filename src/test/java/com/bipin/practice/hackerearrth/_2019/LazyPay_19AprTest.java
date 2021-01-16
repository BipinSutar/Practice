package com.bipin.practice.hackerearrth._2019;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LazyPay_19AprTest {
	LazyPay_19Apr impl = null;
	@BeforeEach
	void setUp() throws Exception {
		impl = new LazyPay_19Apr();
	}

	@Test
	void testGoodSequences() {
		assertEquals(2, impl.getGoodSequences("1233", new int[]{1, 2, 3}));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2500; i++) {
			sb.append(1);
			sb.append(2);
		}
		int actual = impl.getGoodSequences(sb.toString(), new int[]{1, 2});
		assertEquals((2500 * 2500) % LazyPay_19Apr.mod, actual);
	}
	@Test
	public void test_isReachable() {
		impl = new LazyPay_19Apr(8 + 1);
		impl.addEdge(1, 2);
		impl.addEdge(2, 1);
		impl.addEdge(1, 3);
		impl.addEdge(3, 1);
		impl.addEdge(2, 4);
		impl.addEdge(4, 2);
		impl.addEdge(2, 5);
		impl.addEdge(5, 2);
		impl.addEdge(5, 6);
		impl.addEdge(6, 5);
		impl.addEdge(6, 7);
		impl.addEdge(7, 6);
		impl.addEdge(4, 8);
		impl.addEdge(8, 4);
		assertEquals("Bob",
				impl.totalNodes(impl.adj, 8 + 1, 3, 6) % 2 == 1
						? "Bob"
						: "Alex");
		assertEquals("Bob",
				impl.totalNodes(impl.adj, 8 + 1, 4, 4) % 2 == 1
						? "Bob"
						: "Alex");
		assertEquals("Alex",
				impl.totalNodes(impl.adj, 8 + 1, 1, 6) % 2 == 1
						? "Bob"
						: "Alex");
		assertEquals("Bob",
				impl.totalNodes(impl.adj, 8 + 1, 4, 7) % 2 == 1
						? "Bob"
						: "Alex");
	}

}
