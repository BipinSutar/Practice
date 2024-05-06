package com.bipin.practice.hackarrank._2024;

public class WayFair_Round1_Palindrome {

    public static void main(String args[]) {
        WayFair_Round1_Palindrome o = new WayFair_Round1_Palindrome();
        System.out.println(o.isValidPalindrome(""));
        System.out.println(o.isValidPalindrome("A"));
        System.out.println(o.isValidPalindrome("    "));
        System.out.println(o.isValidPalindrome("  ABA  "));
        System.out.println(o.isValidPalindrome("Racer"));
        System.out.println(o.isValidPalindrome("Recer"));
        System.out.println(o.isValidPalindrome("NotRacer"));
        System.out.println(o.isValidPalindrome("Was it a car or a cat I saw"));
        System.out.println(o.isValidPalindrome("AAAA AAAA    @@@@@@@@@@@    AAAA AAAA AAAA"));

    }

    public Boolean isValidPalindrome(String input) {
        System.out.print(input + " ");
        if (input == null) {
            return false;
        }
        int leftPointer = 0;
        int rightPointer = input.length() - 1;
        boolean isValidCharFound = false;
        while (leftPointer <= rightPointer) {
            if (!isValidChar(input.charAt(leftPointer))) {
                leftPointer++;
                continue;
            }
            if (!isValidChar(input.charAt(rightPointer))) {
                rightPointer--;
                continue;
            }
            isValidCharFound = true;
            if (Character.toLowerCase(input.charAt(leftPointer)) == Character.toLowerCase(input.charAt(rightPointer))) {
                leftPointer++;
                rightPointer--;
            } else {
                return false;
            }

        }
        return isValidCharFound;
    }

    public boolean isValidChar(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
