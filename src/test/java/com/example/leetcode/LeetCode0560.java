package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 */
public class LeetCode0560 {

    @Test
    public void test() {
        System.out.println(subarraySum1(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum1(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public int subarraySum1(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int result = 0, pre = 0;
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                result += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return result;
    }

}
