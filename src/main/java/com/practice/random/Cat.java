package com.practice.random;

/**
 * Created by vyast3 on 11/1/15.
 */
public class Cat implements Animal {

    @Override
    public void run() {
        System.out.println("Cat is running");
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    public static void myName() {
        System.out.println("my name");
    }


    static {
        System.out.println("I am cat");
    }


}

