package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ：
 * <p>
 * m 大于 1 。
 * s1 = s0 + 1 。
 * 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
 * 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。
 * <p>
 * 子数组是一个数组中一段连续 非空 的元素序列。
 */
public class LeetCode2765 {

    @Test
    public void test() {
        System.out.println(alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
        System.out.println(alternatingSubarray(new int[]{4, 5, 6}));
    }

    public int alternatingSubarray(int[] nums) {
        int result = -1, count = 1, flag = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[j + 1] - nums[j] == flag) {
                    flag = -flag;
                    count++;
                    result = Math.max(result, count);
                } else {
                    flag = 1;
                    count = 1;
                    break;
                }
                if (j == nums.length - 2) {
                    flag = 1;
                    count = 1;
                    break;
                }
            }
        }
        return result == 1 ? -1 : result;
    }
}
