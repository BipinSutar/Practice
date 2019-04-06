package com.bipin.practice.inheritance;

import java.util.LinkedList;
import static com.bipin.practice.inheritance.test.IstaticMethods.*;

public class StaticImportDemo {
	LinkedList<Integer> list = new LinkedList<Integer>();

	public static void main(String[] args) {
		print("bipin");
		
		sum((byte)1L, (byte)0b100);
		sum(1, 0b100);
		sum(1L, 0b100);
	}

}
