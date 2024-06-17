package com.example.leetcode;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案wftg
 */
public class LeetCode0347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> keyMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (keyMap.containsKey(nums[i])) {
                keyMap.put(nums[i], keyMap.get(nums[i]) + 1);
            } else {
                keyMap.put(nums[i], 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return keyMap.get(a) - keyMap.get(b);
            }
        });
        for (Integer key : keyMap.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (keyMap.get(key) > keyMap.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}
