package com.practice.designPattern.strategy;

/**
 * Created by vyast3 on 8/2/15.
 */
public class King extends Character {

    public King() {
        weapon = new AxeBehaviour();
    }

    @Override
    public void display() {
        System.out.println("I am a king");
    }
}
