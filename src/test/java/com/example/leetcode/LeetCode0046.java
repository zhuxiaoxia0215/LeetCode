package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class LeetCode0046 {
    List<Integer> nums;
    List<List<Integer>> res;

    void swap(int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }

    void dfs(int x) {
        if (x == nums.size() - 1) {
            res.add(new ArrayList<>(nums));  // 添加排列方案
            return;
        }
        for (int i = x; i < nums.size(); i++) {
            swap(i, x);              // 交换，将 nums[i] 固定在第 x 位
            dfs(x + 1);              // 开启固定第 x + 1 位元素
            swap(i, x);              // 恢复交换
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = new ArrayList<>();
        for (int num : nums) {
            this.nums.add(num);
        }
        dfs(0);
        return res;
    }
}
