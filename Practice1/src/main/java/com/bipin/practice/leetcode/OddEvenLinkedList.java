package com.bipin.practice.leetcode;

public class OddEvenLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
		@Override
		public String toString() {
			return printLinkedList(this);
		}
	}
	public static void main(String[] args) {
		printLinkedList(getTestCase1());
		printLinkedList(oddEvenList(getTestCase1()));
	}
	public static ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode oddHeadPointer = head;
		ListNode evenHeadPointer = head.next;
		while (odd != null && even != null) {
			ListNode t = even.next;
			if (t == null) {
				break;
			}
			odd.next = even.next;
			odd = odd.next;

			even.next = odd.next;
			even = even.next;

		}
		odd.next = evenHeadPointer;
		return oddHeadPointer;
	}
	public static ListNode getTestCase1() {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		return l;
	}
	public static String printLinkedList(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val + " -> ");
			head = head.next;
		}
		return (sb + " NULL");
	}
}
