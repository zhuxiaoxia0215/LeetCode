package com.example.leetcode;

import java.util.*;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LeetCode0146 {
    class LRUCache {

        private int capacity;
        private HashMap<Integer, Integer> cache;
        private Queue<Integer> queue;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            queue =new ArrayDeque(capacity);
            cache = new HashMap<>();
        }

        public int get(int key) {
            if(cache.containsKey(key)){
                queue.poll();
                queue.offer(key);
                return cache.get(key);
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                cache.put(key, value);
                queue.poll();
                queue.offer(key);
            }else{
                if(queue.size() < capacity){
                    cache.put(key, value);
                    queue.offer(key);
                }else{
                    cache.put(key, value);
                    int oldKey = queue.poll();
                    cache.remove(oldKey);
                    queue.offer(key);
                }
            }
        }
    }

    class LRUCache1 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache1(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        // 这个可不写
        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
