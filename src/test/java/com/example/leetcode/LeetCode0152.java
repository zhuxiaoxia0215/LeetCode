package com.example.leetcode;

import java.util.Arrays;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class LeetCode0152 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

}
