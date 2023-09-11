package com.bipin.practice.generics.test;

import java.util.LinkedList;

public class LinkedListAddNumber {
    static class LinkedListNode {
        int data;
        LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this == null) {
                return "Null";
            }
            LinkedListNode temp = this;
            while (temp != null) {
                sb.append(temp.data);
                sb.append(" , ");
                temp = temp.next;
            }
            return sb.toString();
        }
    }

    LinkedList<Integer> head1, head2, result;

    public static void main(String[] args) {
        int arr2[] = {1, 2, 3, 1, 2, 3, 5, 2, 3, 4, 1, 3, 5, 6, 4, 5, 0, 5, 2, 3, 4, 8, 9, 6, 3, 1, 2, 5, 6, 1, 7, 8,
                9, 6, 3, 2, 5, 4, 1, 2, 0, 2, 5, 8, 9, 6, 3, 2, 1, 1, 2, 3, 1, 2, 3, 5, 2, 3, 4, 1, 3, 5, 6, 4, 5, 0, 5,
                2, 3, 4, 8, 9, 6, 3, 1, 2, 5, 6, 1, 7, 8, 9, 6, 3, 2, 5, 4, 1, 2, 0, 2, 5, 8, 9, 6, 3, 2, 1, 1, 2, 3, 1,
                2, 3, 5, 2, 3, 4, 1, 3, 5, 6, 4, 5, 0, 5, 2, 3, 4, 8, 9, 6, 3, 1, 2, 5, 6, 1, 7, 8, 9, 6, 3, 2, 5, 4, 1,
                2, 0, 2, 5, 8, 9, 6, 3, 2, 1, 1, 2, 3, 1, 2, 3, 5, 2, 3, 4, 1, 3, 5, 6, 4, 5, 0, 5, 2, 3, 4, 8, 9, 6, 3,
                1, 2, 5, 6, 1, 7, 8, 9, 6, 3, 2, 5, 4, 1, 2, 0, 2, 5, 8, 9, 6, 3, 2, 1};
        int arr1[] = {1, 8, 4, 5, 6, 7, 8, 1, 8, 4, 5, 6, 7, 8, 1, 8, 4, 5, 6, 7, 8, 1, 8, 4, 5, 6, 7, 8, 1, 8, 4, 5,
                6, 7, 8, 1, 8, 4, 5, 6, 7, 8, 1, 8, 4, 5, 6, 7, 8, 1, 8, 4, 5, 6, 7, 8};

//        new LinkedListAddNumber().cal(arr1, arr2);
        System.out.println(new LinkedListAddNumber().calForAddTwoNumbers(new int[]{5, 6, 3, -1}, new int[]{8, 4, 2, -1}));

    }

    private void cal(int[] arr1, int[] arr2) {
        head1 = new LinkedList<>();

        head2 = new LinkedList<>();

        result = new LinkedList<>();

        for (int i = 0; i < arr1.length; i++) {
            head1.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            head2.add(arr2[i]);
        }
        sum();
    }

    private void sum() {
        int h1 = head1.size() - 1;
        int h2 = head2.size() - 1;

        if (h2 > h1) {
            // swap
            LinkedList<Integer> temp = head1;
            head1 = head2;
            head2 = temp;
            h1 = h1 + h2 - (h2 = h1);
        }

        int carry = 0;
        while (h2 > -1) {
            int sum = head1.get(h1) + head2.get(h2) + carry;
            carry = sum / 10;
            sum = sum % 10;
            result.addFirst(sum);
            h1--;
            h2--;
        }
        while (h1 > -1) {
            int sum = head1.get(h1) + carry;
            carry = sum / 10;
            sum = sum % 10;
            result.addFirst(sum);
            h1--;

        }
        if (carry > 0)
            result.addFirst(carry);
        System.out.println(result);
        for (int i : result) {
            System.out.print(i);
        }
    }

    public LinkedListNode calForAddTwoNumbers(int[] arr1, int[] arr2) {
        LinkedListNode head1 = new LinkedListNode(arr1[0]);
        LinkedListNode head2 = new LinkedListNode(arr2[0]);
        LinkedListNode headTemp = head1;
        for (int i = 1; i < arr1.length; i++) {
            LinkedListNode temp = new LinkedListNode(arr1[i]);
            headTemp.next = temp;
            headTemp = headTemp.next;
        }
        headTemp = head2;
        for (int i = 1; i < arr2.length; i++) {
            LinkedListNode temp = new LinkedListNode(arr2[i]);
            headTemp.next = temp;
            headTemp = headTemp.next;
        }
        return addTwoNumbers(head1, head2);
    }

    public LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode temp1 = head1;
        LinkedListNode temp2 = head2;
        LinkedListNode ans = null;
        LinkedListNode tempAns = null;
        int carry = 0;
        while (temp1.data != -1 && temp2.data != -1) {
//            System.out.println(temp1.data + " + " + temp2.data);
            int sum = temp1.data + temp2.data + carry;
            carry = sum / 10;
            sum = sum % 10;

            LinkedListNode newNode = new LinkedListNode(sum);
            if (ans == null) {
                ans = newNode;
                tempAns = ans;
            } else {
                tempAns.next = newNode;
                tempAns = tempAns.next;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;

        }
        while (temp1.data != -1) {
            int sum = temp1.data + carry;

            carry = sum / 10;
            sum = sum % 10;

            LinkedListNode newNode = new LinkedListNode(sum);
            if (ans == null) {
                ans = newNode;
                tempAns = ans;
            } else {
                tempAns.next = newNode;
                tempAns = tempAns.next;
            }
            temp1 = temp1.next;

        }

        while (temp2.data != -1) {
            int sum = temp2.data + carry;

            carry = sum / 10;
            sum = sum % 10;

            LinkedListNode newNode = new LinkedListNode(sum);
            if (ans == null) {
                ans = newNode;
                tempAns = ans;
            } else {
                tempAns.next = newNode;
                tempAns = tempAns.next;
            }
            temp2 = temp2.next;

        }

        return ans;
    }

}
