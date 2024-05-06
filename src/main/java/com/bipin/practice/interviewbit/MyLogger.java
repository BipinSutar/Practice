package com.bipin.practice.interviewbit;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MyLogger implements Logger {
    private class Node {
        String pid;
        Long start;
        Long end;

        public Node(String pid, Long start, Long end) {
            this.pid = pid;
            this.start = start;
            this.end = end;
        }
    }

    private Map<String, Node> startMap = new HashMap<>();
    private PriorityQueue<Node> minHeap2 = new PriorityQueue<>((n1, n2) -> Long.compare(n1.start, n2.start));
    private PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> Long.compare(n1.end, n2.end));

    /**
     * When a process starts, it calls 'start' with processId and startTime.
     */
    @Override
    public void start(String processId, long startTime) {
        startMap.put(processId, new Node(processId, startTime, null));
    }

    /**
     * When the same process ends, it calls 'end' with processId and endTime.
     */
    @Override
    public void end(String processId, long endTime) {
        if (!startMap.containsKey(processId)) {
            throw new IllegalArgumentException("cannot end a process which has not been started, process not found");
        }

        Node process = startMap.get(processId);
        process.end = endTime;

        // clean up hashmap
        startMap.remove(processId);

        minHeap.offer(process);

    }

    /**
     * Prints the logs of this system sorted by the start time of processes in the
     * below format
     * {processId} started at {startTime} and ended at {endTime}
     */
    @Override
    public void Log(String processId, long startTime, long endTime) {
        // In actual interview no code here, call the Log method but do not implement it
        while (!minHeap.isEmpty()) {
            Node n1 = minHeap.poll();

            System.out.println(n1.pid + " started at " + n1.start + " and ended at " + n1.end);
        }

    }

    public static void main(String[] args) {
        /*
         * Output:
         * 1 started at 100 and ended at 104
         * 2 started at 101 and ended at 102
         * 3 started at 103 and ended at 105
         */

        Logger log = new MyLogger();
        log.start("1", 100);
        log.start("2", 101);
        log.end("2", 102);
        log.start("3", 103);
        log.end("1", 104);
        log.end("3", 105);
        log.Log("3", 100, 200);

    }
}
