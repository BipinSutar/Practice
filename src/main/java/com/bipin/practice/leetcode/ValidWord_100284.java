package com.bipin.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidWord_100284 {
    public static void main(String[] args) {
        ValidWord_100284 o = new ValidWord_100284();
        System.out.println(o.isValid("234Adas"));
        System.out.println(o.isValid("AhI"));
        System.out.println(o.isValid("jdf79"));
    }

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        Map<String, String> vowels = new HashMap<>();
        vowels.put("a", "a");
        vowels.put("e", "e");
        vowels.put("i", "i");
        vowels.put("o", "o");
        vowels.put("u", "u");

        Map<String, String> digits = new HashMap<>();
        digits.put("0", "0");
        digits.put("1", "1");
        digits.put("2", "2");
        digits.put("3", "3");
        digits.put("4", "4");
        digits.put("5", "5");
        digits.put("6", "6");
        digits.put("7", "7");
        digits.put("8", "8");
        digits.put("9", "9");

        Map<String, String> consonants = new HashMap<>();
        for (int i = 97; i < 97 + 26; i++) {
            String ch = ((char) i) + "";
            if (!vowels.containsKey(ch)) {
                consonants.put(ch, ch);
            }
        }
        // System.out.println(consonants);
        Map<String, String> specialChars = new HashMap<>();
        specialChars.put("@", "@");
        specialChars.put("#", "#");
        specialChars.put("$", "$");

        boolean containsDigit = false;
        boolean containsUpperCase = false;
        boolean containsLowerCase = false;
        boolean containsVowel = false;
        boolean containsConsonant = false;
        for (int i = 0; i < word.length(); i++) {
            String ch = word.charAt(i) + "";
            if (specialChars.containsKey(ch)) {
                return false;
            }

            if (digits.containsKey(ch)) {
                containsDigit = true;
                continue;
            }
            String lowerCh = ch.toLowerCase();
            if (vowels.containsKey(lowerCh)) {
                containsVowel = true;
            }
            if (consonants.containsKey(lowerCh)) {
                containsConsonant = true;
            }
            if (ch.equals(lowerCh)) {
                containsLowerCase = true;
            }
            String upperCh = ch.toUpperCase();
            if (ch.equals(upperCh)) {
                containsUpperCase = true;
            }

        }
        return (containsDigit |
                containsUpperCase |
                containsLowerCase) &&
                containsVowel &&
                containsConsonant;

    }

}
