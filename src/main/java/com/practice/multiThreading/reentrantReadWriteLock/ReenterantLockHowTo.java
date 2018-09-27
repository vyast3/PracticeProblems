package com.practice.multiThreading.reentrantReadWriteLock;

import com.practice.multiThreading.MyRunnable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vyast3 on 1/7/15.
 */
public class ReenterantLockHowTo {
    private final ReentrantLock lock = new ReentrantLock();

    private int count = 0;

    public int getCount() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread() + " gets count " + count);
            return count++;
        } finally {
            lock.unlock();
        }
    }


    private static final int NTHREDS = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < 500; i++) {
            Runnable worker = new MyRunnable(10000000L + i);

            executor.execute(worker);
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        System.out.println("Finished all threads");
    }
}

