package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class LeetCode0136 {

    @Test
    public void test() {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(singleNumber(new int[]{1}));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap();
        for (int num : nums) {
            if (numMap.containsKey(num)) {
                numMap.put(num, 2);
            } else {
                numMap.put(num, 1);
            }
        }
        for (Object key : numMap.keySet()) {
            if (numMap.get(key) == 1) {
                return (int) key;
            }
        }
        return 0;
    }
}
