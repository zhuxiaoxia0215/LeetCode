package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class LeetCode0209 {

    @Test
    public void Test() {
        System.out.println(minSubArrayLen1(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen1(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen1(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i], j = i + 1;
            while (sum < target && j < nums.length) {
                sum += nums[j];
                j++;
            }
            if (sum >= target) {
                min = Math.min(min, j - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while(right < nums.length){
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(right - left +1, min);
                sum = sum - nums[left];
                left++;
            }
            right ++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
