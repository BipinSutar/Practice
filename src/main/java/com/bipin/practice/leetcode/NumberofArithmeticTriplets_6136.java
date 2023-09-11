package com.bipin.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberofArithmeticTriplets_6136 {
    public static void main(String[] args) {
        System.out.println(new NumberofArithmeticTriplets_6136().arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
    }

    public int arithmeticTriplets(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target + nums[i];
            map.put(diff, nums[i]);
        }
        Set<List<Integer>> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i];
            if (map.containsKey(diff)) {
                List<Integer> temp_list = new ArrayList<>();
                temp_list.add(diff);
                temp_list.add(map.get(diff));
                Collections.sort(temp_list);

                s.add(temp_list);

            }

        }

        int count = 0;
        for(List<Integer> iList:s){
            int k = iList.get(1);
            for(List<Integer> jList:s){
                if(jList.get(0) == k){
                    count++;
                }
            }
        }
        return count;

    }
}
