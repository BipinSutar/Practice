package com.bipin.practice.inheritance.test;

import com.bipin.practice.inheritance.Child;
import com.bipin.practice.inheritance.Child2;
import com.bipin.practice.inheritance.Parent;
import com.bipin.practice.inheritance.assembler.Assembler;

public class Test1 {

	public static void main(String[] args) {

		Assembler assembler = new Assembler();
		Parent parent1 = assembler.getChild();
		parent1 = new Child();
		dbg("parent1 " + parent1.toString());

		Parent parent2 = new Parent();
		parent2.setP1(21);
		parent2.setP2(22);
		parent2.setP3(23);
		dbg("parent2 " + parent2.toString());

		Parent parent3 = assembler.getGrandChild();
		dbg("parent3 " + parent3.toString());
		dbg(parent3.cal());

		Child2 child2 = new Child2();
		child2.setP1(50);
		dbg("child2 " + child2.toString());
		Object object = new Object();
		dbg(object.toString());
	}

	public static void dbg(String s) {
		System.out.println(s);
	}

}
