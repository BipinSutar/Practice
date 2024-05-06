package com.bipin.practice.codestudio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Merge2SortedArray {
    public static void main(String args[]) {
        Merge2SortedArray o = new Merge2SortedArray();
        System.out.println(o.sortedArray(new int[] { 3, 4 }, new int[] { 1, 2, 3, 3 }));
    }

    public static List<Integer> sortedArray(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;
        Set<Integer> sortedSet = new LinkedHashSet<>(n + m);
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (a[i] == b[j]) {
                sortedSet.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                sortedSet.add(a[i]);
                i++;
            } else {
                sortedSet.add(b[j]);
                j++;
            }
        }
        while (i < n) {

            sortedSet.add(a[i]);
            i++;
        }
        while (j < m) {

            sortedSet.add(b[j]);
            j++;
        }
        return new ArrayList<>(sortedSet);
    }
}
