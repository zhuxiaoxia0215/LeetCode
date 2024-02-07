package com.example.leetcode;

import java.util.*;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class LeetCode0078 {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque();
        dfs(nums, deque, 0);
        return result;
    }

    public void dfs(int[] nums, Deque deque, int start) {
        result.add(new ArrayList<>(deque));
        for (int i = start; i < nums.length; i++) {
            deque.addLast(nums[i]);
            dfs(nums, deque, i + 1);
            deque.removeLast();
        }
    }

}
