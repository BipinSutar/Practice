package com.bipin.practice.advancedClasses;

enum E1 {
	SB(90, 0), MB(120), LB(290);
	private int nop;

	E1(int n) {
		nop = n;
	}

	E1(int n, int def) {
		nop = n;
	}

	int getNop() {
		return nop;
	}
}

public abstract class E1Test {
	public static void main(String[] args) {
		System.out.println(E1.SB.getNop());
		System.out.println(E1.values());
	}
}
