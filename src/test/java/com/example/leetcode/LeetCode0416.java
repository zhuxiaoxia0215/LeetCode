package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
 */
public class LeetCode0416 {

    @Test
    public void test() {
        System.out.println(canPartition(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
            if (nums[i] > target) {
                return false;
            }
            dp[i][nums[i]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[nums.length - 1][target];
    }
}
