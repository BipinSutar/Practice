package com.bipin.practice.interviewbit;


public interface Logger {
    /**
     * This was asked in Google 2024, R2 on 15 April 2024.
     */
    /**
     * When a process starts, it calls 'start' with processId and startTime.
     */
    void start(String processId, long startTime);

    /**
     * When the same process ends, it calls 'end' with processId and endTime.
     */
    void end(String processId, long endEime);

    /**
     * Prints the logs of this system sorted by the start time of processes in the
     * below format
     * {processId} started at {startTime} and ended at {endTime}
     */
    void Log(String processId, long startTime, long endEime);
}
