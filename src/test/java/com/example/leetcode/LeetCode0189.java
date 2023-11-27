package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class LeetCode0189 {

    @Test
    public void Test() {
        int[] nums = new int[]{-1};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k > length) {
            k = k % length;
        }
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[length - k + i];
        }
        for (int j = length - 1; j >= k; j--) {
            nums[j] = nums[j - k];
        }
        for (int l = 0; l < k; l++) {
            nums[l] = temp[l];
        }
    }
}
