package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class LeetCode0238 {

    @Test
    public void Test() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] R = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                R[i] = 1;
            } else {
                R[i] = R[i + 1] * nums[i + 1];
            }
        }
        for (int j = 0; j < length; j++) {
            if (j == 0) {
                result[j] = 1;
            } else {
                result[j] = result[j - 1] * nums[j - 1];
            }
        }
        for (int k = 0; k < length; k++) {
            result[k] = result[k] * R[k];
        }
        return result;
    }

}
