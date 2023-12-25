package com.bipin.practice.hackerearrth._2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClearTrip_TruckCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getTrucksAfterCollision(new int[] { 10, 4, 2, -5, 10, 4, 2, -5 }));
		System.out.println(getTrucksAfterCollision(new int[] { -2, -1, 1, 2, 3, 4, 5 }));
		System.out.println(getTrucksAfterCollision(new int[] { 10, 4, 2, -15, -20 }));
		System.out.println(getTrucksAfterCollision(new int[] { 10, 4, 2, 10, -10, -10 }));
	}

	public static List<Integer> getTrucksAfterCollision(int input[]) {
		Stack<Integer> stack = new Stack<>();
		boolean didIPushNegativeElementToStack = false;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > 0) {
				stack.push(input[i]);
				didIPushNegativeElementToStack = false;
			} else if (stack.isEmpty() || didIPushNegativeElementToStack) {
				stack.push(input[i]);
				didIPushNegativeElementToStack = true;
			} else {
				while (!stack.isEmpty() && stack.peek() < abs(input[i])) {
					stack.pop();
				}

				if (stack.isEmpty()) {
					stack.push(input[i]);
					didIPushNegativeElementToStack = true;
				} else if (stack.peek() == abs(input[i])) {
					stack.pop();
					didIPushNegativeElementToStack = false;
				}
			}
		}
		return new ArrayList<Integer>(stack);
	}

	public static int abs(int a) {
		return a < 0 ? -a : a;
	}

}
