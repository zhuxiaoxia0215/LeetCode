package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class LeetCode0039 {

    @Test
    public void test() {
        combinationSum(new int[]{2, 3, 6,7}, 7);
    }

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque();
        dfs(candidates, deque, target, 0);
        return result;
    }

    public void dfs(int[] candidates, Deque deque, int target, int start) {
        if (target < 1) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            deque.addLast(candidates[i]);
            if (candidates[i] == target) {
                result.add(new ArrayList<>(deque));
            } else {
                dfs(candidates, deque, target - candidates[i], i);
            }
            deque.removeLast();
        }
    }
}
