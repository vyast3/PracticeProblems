package com.practice.miscellaneous;

import java.util.HashMap;

public class LRUCacheLinkedList {
    private class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = null;
    private Node end = null;

    public LRUCacheLinkedList(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    private void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }

    }

    private void setHead(Node n) {
        n.next = head;
        n.pre = null;

        if (head != null)
            head.pre = n;

        head = n;

        if (end == null)
            end = head;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
            return;
        }
        Node created = new Node(key, value);
        if (map.size() >= capacity) {
            map.remove(end.key);
            remove(end);
            setHead(created);

        } else {
            setHead(created);
        }

        map.put(key, created);

    }

    public static void main(String[] args) {
        LRUCacheLinkedList cache = new LRUCacheLinkedList(5);
        cache.set(1, 10);
        cache.set(2, 20);
        cache.set(3, 30);
        cache.set(4, 40);
        cache.set(5, 50);
        System.out.println(cache.get(1));
        cache.set(6, 60);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }
}
