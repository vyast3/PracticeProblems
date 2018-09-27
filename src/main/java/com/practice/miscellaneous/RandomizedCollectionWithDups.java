package com.practice.miscellaneous;

import java.util.*;

public class RandomizedCollectionWithDups {
    ArrayList<Integer> numsList;
    HashMap<Integer, Set<Integer>> locsMap;
    java.util.Random rand = new java.util.Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollectionWithDups() {
        numsList = new ArrayList<>();
        locsMap = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean contain = locsMap.containsKey(val);
        if (!contain) locsMap.put(val, new LinkedHashSet<>());
        locsMap.get(val).add(numsList.size());
        numsList.add(val);
        return !contain;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        boolean contain = locsMap.containsKey(val);
        if (!contain) return false;
        int loc = locsMap.get(val).iterator().next();
        locsMap.get(val).remove(loc);
        if (loc < numsList.size() - 1) {
            int lastone = numsList.get(numsList.size() - 1);
            numsList.set(loc, lastone);
            locsMap.get(lastone).remove(numsList.size() - 1);
            locsMap.get(lastone).add(loc);
        }
        numsList.remove(numsList.size() - 1);

        if (locsMap.get(val).isEmpty()) locsMap.remove(val);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return numsList.get(rand.nextInt(numsList.size()));
    }

    public static void main(String[] args) {
        RandomizedCollectionWithDups rc = new RandomizedCollectionWithDups();
        rc.insert(2);
        rc.insert(3);
        rc.insert(4);
        rc.insert(3);
        rc.insert(3);
        rc.insert(1);
        rc.insert(2);
        rc.insert(3);
        rc.remove(2);
        rc.remove(3);

    }
}
