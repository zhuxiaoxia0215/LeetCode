package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class LeetCode0018 {

    @Test
    public void test() {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0).toString());
        System.out.println(fourSum(new int[]{2, 2, 3, 3, 3}, 10).toString());
        System.out.println(fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0).toString());
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    long sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        m++;
                        n--;
                    }
                    if (sum < target) {
                        m++;
                    }
                    if (sum > target) {
                        n--;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
