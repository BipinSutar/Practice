package com.bipin.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString_567 {
    public static void main(String[] args) {
        PermutationInString_567 obj = new PermutationInString_567();
        System.out.println(obj.checkInclusion("ab", "eidbaooo"));
        System.out.println(obj.checkInclusion1("ab", "eidbaooo"));

    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public boolean checkInclusion1(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ((int) 'a' + i);
            map.put(ch, 0);
        }
        for (int i = 0; i < len1; i++) {
            map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
        }
        for (int i = 0; i < len1; i++) {
            map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
        }

        if (allZero(map)) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            char ch = s2.charAt(i);
            map.put(ch, map.get(ch) - 1);
            ch = s2.charAt(i - len1);
            map.put(ch, map.get(ch) + 1);
            if (allZero(map)) {
                return true;
            }
        }

        return false;
    }

    private boolean allZero(Map<Character, Integer> map) {
        for (Character ch : map.keySet()) {
            if (map.get(ch) != 0) {
                return false;
            }
        }
        return true;
    }

}
