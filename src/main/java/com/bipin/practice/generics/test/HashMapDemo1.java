package com.bipin.practice.generics.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo1 {

    public static void main(String[] args) {
        Map<String, Character> map = new HashMap<>();
        for (long i = 0; i < 1000_000_000_0L; i++) {
            map.put(i + "", 'a');
        }
        Math.abs(-3);
    }

}
