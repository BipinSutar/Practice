package com.bipin.practice.leetcode;

import java.util.PriorityQueue;

public class MergekSortedLists_23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode temp = this;
            while (temp != null) {
                sb.append(temp.val).append(",");
                temp = temp.next;
            }
            return sb.substring(0, sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        ListNode l1 = createLinkedList(new int[]{1, 4, 5});
        ListNode l2 = createLinkedList(new int[]{1, 3, 4});
        ListNode l3 = createLinkedList(new int[]{2, 6});
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        ListNode l4 = new MergekSortedLists_23().mergeKLists(new ListNode[]{l1, l2, l3});
        System.out.println(l4);
    }

    public static ListNode createLinkedList(int[] arr) {
        ListNode pointer = new ListNode(-1);
        ListNode head = pointer;
        for (int i = 0; i < arr.length; i++) {
            pointer.next = new ListNode(arr[i]);
            pointer = pointer.next;

        }
        return head.next;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode resultPointer = result;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (l1, l2) -> Integer.compare(l1.val, l2.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }

        }
        while (!queue.isEmpty()) {
            result.next = queue.poll();
            result = result.next;
            if (result.next != null) {
                queue.add(result.next);
            }
        }
        return resultPointer.next;


    }
}
