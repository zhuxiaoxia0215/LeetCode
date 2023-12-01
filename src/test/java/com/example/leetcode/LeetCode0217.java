package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
public class LeetCode0217 {

    @Test
    public void Test() {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i])) {
                return true;
            } else {
                numSet.add(nums[i]);
            }
        }
        return false;
    }
}
