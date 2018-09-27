package com.practice.companies.uber;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vyast3 on 5/8/16.
 */
public class LRUCache<K, V>  {
    MyMap<K, V> map;

    public LRUCache(int capacity) {
        this.map = new MyMap(capacity);
    }

    public void set(K key, V val) {
        map.put(key, val);
    }

    public V get(K key) {
        V val = map.get(key);

        return (val == null) ? null : val;
    }

    class MyMap<K, V> extends LinkedHashMap<K, V> {
        int capacity;

        public MyMap(int initialCapacity) {
            super(initialCapacity, 0.75f, true);
            this.capacity = initialCapacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(5);
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
