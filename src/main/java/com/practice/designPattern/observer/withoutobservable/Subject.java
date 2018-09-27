package com.practice.designPattern.observer.withoutobservable;


/**
 * Created by vyast3 on 8/2/15.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void deleteObserver(Observer o);
    public void notifyObservers();
}
