package com.practice.multiThreading.delayQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by vyast3 on 3/1/16.
 */
public class DelayQueueConsumer {

    private String name;

    private BlockingQueue<DelayObject> queue;

    public DelayQueueConsumer(String name, BlockingQueue queue) {
        super();
        this.name = name;
        this.queue = queue;
    }

    private Thread consumerThread =  new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    // Take elements out from the DelayQueue object.
                    DelayObject object = queue.take();
                    System.out.printf("[%s] - Take object = %s%n",
                            Thread.currentThread().getName(), object);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    public void start(){
        this.consumerThread.setName(name);
        this.consumerThread.start();
    }

}