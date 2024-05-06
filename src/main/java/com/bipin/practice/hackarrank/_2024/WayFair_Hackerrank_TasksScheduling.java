package com.bipin.practice.hackarrank._2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WayFair_Hackerrank_TasksScheduling {
    // Online Java Compiler
    // Use this editor to write, compile and run your Java code online
    private static int getMinTime(int[] taskMemory, int[] taskType, int maxMemory) {
        int n = taskMemory.length;
        Map<Integer, List<Integer>> tasksByType = new HashMap<>(); // group tasks by their type
        for (int index = 0; index < n; index++) {
            tasksByType.putIfAbsent(taskType[index], new ArrayList<>());
            tasksByType.get(taskType[index]).add(taskMemory[index]);
        }

        // since we can only run parallely for same tasks. figure out the max time for
        // each type of tasks
        int minTime = 0;
        for (int type : tasksByType.keySet()) {
            List<Integer> memories = tasksByType.get(type);
            Collections.sort(memories);

            int left = 0, right = memories.size() - 1;
            while (left < right) {
                if (memories.get(left) + memories.get(right) <= maxMemory) { // pair the larger task with the shorter
                                                                             // task under memory limit
                    left++;
                }

                minTime++;
                right--;
            }

            if (left == right)
                minTime++;
        }

        return minTime;
    }

    public static void main(String[] args) {
        int[] taskMemory = { 1, 3, 2, 4, 2 };
        int[] taskType = { 1, 1, 1, 1, 1 };
        int maxMemory = 10;

        int result = getMinTime(taskMemory, taskType, maxMemory);
        System.out.println("Minimum time to process tasks: " + result);
    }
}
