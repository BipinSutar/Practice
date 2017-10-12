package com.bipin.practice.inheritance.assembler;

import com.bipin.practice.inheritance.Child;
import com.bipin.practice.inheritance.GrandChild;
import com.bipin.practice.inheritance.Parent;

public class Assembler {
	public Child getChild() {
		Child childObj = new Child();
		childObj.setC1(11);
		childObj.setC2(12);
		childObj.setC3(13);

		Parent parentObj = new Parent();
		parentObj.setP1(1);
		parentObj.setP2(2);
		parentObj.setP3(3);

		// childObj.setParent(parentObj);

		return childObj;
	}

	public GrandChild getGrandChild() {
		GrandChild grandChild = new GrandChild();
		grandChild.setG1(31);
		grandChild.setG2(32);
		return grandChild;

	}
}
