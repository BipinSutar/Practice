package com.bipin.practice.interviewbit;

import java.util.TreeMap;

public class FindFirstMissingPositive_JobTracker_High_Water_Mark {

    /**
     * This was asked in Google 2024, R1 on 12 April 2024.
     * Link to the question -
     * https://cs.stackexchange.com/questions/140884/algorithm-to-compute-high-water-mark
     */
    private final TreeMap<Integer, Integer> jobs;
    private int startJobNumber = 0;
    private final Integer DUMMY = -1;

    public FindFirstMissingPositive_JobTracker_High_Water_Mark() {
        this.jobs = new TreeMap<>();
    }

    public void start(int startJobNumber) {
        this.startJobNumber = startJobNumber;
    }

    public void ack(int jobNumber) {
        this.jobs.put(jobNumber, DUMMY);
    }

    public int getHWM() {
        if (jobs.isEmpty()) {
            return -1;
        }
        int prev = this.jobs.firstKey();
        for (int job : jobs.keySet()) {
            if (job == startJobNumber) {
                continue;
            }
            int diff = job - prev;
            if (diff > 1) {
                return prev;
            }
            prev = job;
        }
        return prev;
    }

    public static void main(String args[]) {
        t1();
        t2();
    }

    public static void t1() {
        FindFirstMissingPositive_JobTracker_High_Water_Mark o = new FindFirstMissingPositive_JobTracker_High_Water_Mark();
        o.start(1);
        System.out.println("HWM At [] " + o.getHWM());
        o.ack(1);
        o.ack(2);
        o.ack(3);
        System.out.println("HWM At [1,2,3] " + o.getHWM());
        o.ack(6);
        System.out.println("HWM At [1,2,3,6] " + o.getHWM());
        o.ack(4);
        System.out.println("HWM At [1,2,3,4,6] " + o.getHWM());
        o.ack(5);
        System.out.println("HWM At [1,2,3,4,5,6] " + o.getHWM());
    }

    public static void t2() {
        FindFirstMissingPositive_JobTracker_High_Water_Mark o = new FindFirstMissingPositive_JobTracker_High_Water_Mark();
        o.start(10);
        o.ack(100);
        o.ack(600);
        o.ack(200);
        System.out.println("HWM At [100,200,600] " + o.getHWM());
    }
}
