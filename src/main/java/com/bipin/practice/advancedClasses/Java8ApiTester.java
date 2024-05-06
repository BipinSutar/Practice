package com.bipin.practice.advancedClasses;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class Java8ApiTester {
    public static void main(String args[]) {

    }

    public void testCollectorsJoining() {
        Optional<String> o = ofNullable(null);
        // o.map(Collectors.joining(","));
    }
}
