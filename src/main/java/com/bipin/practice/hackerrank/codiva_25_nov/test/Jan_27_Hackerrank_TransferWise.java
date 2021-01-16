package com.bipin.practice.hackerrank.codiva_25_nov.test;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Jan_27_Hackerrank_TransferWise {
	public static class LinkedListNode {
		int val;
		LinkedListNode next;

		LinkedListNode(int val) {
			this.val = val;
		}
	}

	public static void mainLinkedListNode(String[] args) {
		int data[] = new int[] { 2, 2, 1, 1, 1, 3, 3, 4, 6, 5, 6, 8 };
		LinkedListNode head = null;
		for (int i = 0; i < data.length; i++) {
			LinkedListNode node = new LinkedListNode(data[i]);
			if (head == null) {
				head = node;
			} else {
				LinkedListNode n = head;
				while (n.next != null) {
					n = n.next;
				}
				n.next = node;
			}

		}
		LinkedListNode res = distinct(head);
		while (res != null) {
			System.out.print(res.val + " , ");
			res = res.next;
		}

	}

	private static LinkedListNode distinct(LinkedListNode in) {
		// Map<Integer, Object> map = new LinkedHashMap<>();
		Map<Integer, Object> map = new TreeMap<>();
		Object present = new Object();
		while (in != null) {
			if (!map.containsKey(in.val))
				map.put(in.val, present);
			in = in.next;
		}
		LinkedListNode head = null;
		for (Integer i : map.keySet()) {
			LinkedListNode node = new LinkedListNode(i);
			if (head == null) {
				head = node;
			} else {
				LinkedListNode n = head;
				while (n.next != null) {
					n = n.next;
				}
				n.next = node;
			}
		}
		return head;
	}

	static boolean canRepresentBST(int pre[], int n) {
		// Create an empty stack
		Stack<Integer> s = new Stack<Integer>();

		// Initialize current root as minimum possible
		// value
		int root = Integer.MIN_VALUE;

		// Traverse given array
		for (int i = 0; i < n; i++) {
			// If we find a node who is on right side
			// and smaller than root, return false
			if (pre[i] < root) {
				return false;
			}

			// If pre[i] is in right subtree of stack top,
			// Keep removing items smaller than pre[i]
			// and make the last removed item as new
			// root.
			while (!s.empty() && s.peek() < pre[i]) {
				root = s.peek();
				s.pop();
			}

			// At this point either stack is empty or
			// pre[i] is smaller than root, push pre[i]
			s.push(pre[i]);
		}
		return true;
	}

	public static void main(String[] args) {

		int[] pre1 = new int[] { 40, 30, 35, 80, 100 };
		int n = pre1.length;
		if (canRepresentBST(pre1, n) == true) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		int[] pre2 = new int[] { 40, 30, 35, 20, 80, 100 };
		int n1 = pre2.length;
		if (canRepresentBST(pre2, n) == true) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		long a = System.currentTimeMillis();
		System.out.println(intToRoman(Integer.MAX_VALUE));
		long b = System.currentTimeMillis();
		//System.out.println(toRoman(Integer.MAX_VALUE));
		long c = System.currentTimeMillis();
		System.out.println(b - a);
		System.out.println(c - b);
	}

	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		int times = 0;
		String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
		int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
		for (int i = ints.length - 1; i >= 0; i--) {
			times = num / ints[i];
			num %= ints[i];
			while (times > 0) {
				sb.append(romans[i]);
				times--;
			}
		}
		return sb.toString();
	}

	public final static String toRoman(int number) {
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
		int l = map.floorKey(number);
		if (number == l) {
			return map.get(number);
		}
		return map.get(l) + toRoman(number - l);
	}
}
