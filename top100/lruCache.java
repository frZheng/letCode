package top100;


//web https://leetcode.cn/problems/lru-cache


import list.ListNode;

import java.util.ArrayList;
import java.util.HashMap;


public class  lruCache {
    private static class LRUCache {

        int capacity;
        HashMap<Integer, Integer> cache;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
        }

        public int get(int key) {
            return cache.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            if (cache.containsKey(key))
                cache.put(key,value);

        }
    }



    public static void main(String Args[]) {
        // "LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"}
        // [[2],      [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        // [null,      null, null    , 1,  null,   -1,   null,  -1,  3,   4]
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);

    }

}
