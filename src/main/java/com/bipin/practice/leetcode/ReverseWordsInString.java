package com.bipin.practice.leetcode;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString().reverseWords("the sky is blue"));
        System.out.println(new ReverseWordsInString().reverseWords("  hello world  "));
        System.out.println(new ReverseWordsInString().reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int prevPointer = s.length();
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                boolean isCharAppend = false;
                for (int j = i + 1; j < prevPointer; j++) {
                    sb.append(s.charAt(j));
                    isCharAppend = true;
                }
                if (isCharAppend) {
                    sb.append(' ');
                }
                prevPointer = i;

            }

        }
        for (int j = i + 1; j < prevPointer; j++) {
            sb.append(s.charAt(j));
        }

        return sb.toString();

    }
}
