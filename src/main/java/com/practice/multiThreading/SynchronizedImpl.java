package com.practice.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchronizedImpl {
    private int count;

    synchronized void incrementSync() {
        count = count + 1;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);


    }
}
