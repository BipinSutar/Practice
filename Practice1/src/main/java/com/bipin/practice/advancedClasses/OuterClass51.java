package com.bipin.practice.advancedClasses;

public class OuterClass51 {

	class InnerClass51 {
		int count = 0;

		public void inMethod() {
			System.out.println("userinner51()");
		}
	}

	static class InnerClass52 {
		static int count = 0;

		public void inMethod() {
			System.out.println("userinner52()");
		}
	}

	public static void main(String[] args) {
		OuterClass51 outerclass51 = new OuterClass51();
		OuterClass51.InnerClass51 innerClass51 = outerclass51.new InnerClass51();
		innerClass51.inMethod();
		new OuterClass51().new InnerClass51().inMethod();
		InnerClass52 class52 = new InnerClass52();
		class52.inMethod();

	}

}
