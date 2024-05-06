package com.bipin.practice.generics.test;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LsitInsideSetDemo {
    public static void main(String args[]) {
        Set<List<Integer>> setList = new HashSet<>();
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        setList.add(nums1);
        setList.add(nums2);
        System.out.println("Expected size of 1 for Integer Set but actual is  " + setList.size());

        Set<List<String>> setListOfString = new HashSet<>();
        List<String> strs1 = new ArrayList<>(Arrays.asList(new String("Potato"), new String("Qwerty"), "Hello", "Another String"));
        List<String> strs2 = new ArrayList<>(Arrays.asList(new String("Potato"), new String("Qwerty"), "Hello", "Another String"));
        setListOfString.add(strs1);
        setListOfString.add(strs2);
        System.out.println("Expected size of 1 for String Set but actual is  " + setListOfString.size());
    }

}
