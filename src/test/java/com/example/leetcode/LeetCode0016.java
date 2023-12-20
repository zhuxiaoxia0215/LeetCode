package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 */
public class LeetCode0016 {

    @Test
    public void test() {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int[] res = new int[3];
        int l = nums.length, dif = Integer.MAX_VALUE;
        if (l == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        for (int i = 0; i < l - 2; i++) {
            int j = i + 1, k = l - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    return nums[i] + nums[j] + nums[k];
                }
                if (Math.abs(target - (nums[i] + nums[j] + nums[k])) < dif) {
                    res = new int[]{nums[i], nums[j], nums[k]};
                    dif = Math.abs(target - (nums[i] + nums[j] + nums[k]));
                }
                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                }
                if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                }
            }
        }
        return res[0] + res[1] + res[2];
    }
}
