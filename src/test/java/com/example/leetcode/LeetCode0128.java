package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LeetCode0128 {

    @Test
    public void test() {
        System.out.println(longestConsecutive1(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive1(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive1(new int[]{1, 2, 0, 1}));
    }


    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 1, len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                len++;
            } else if (nums[i] != nums[i - 1]) {
                result = Math.max(result, len);
                len = 1;
            }
        }
        result = Math.max(result, len);
        return result;
    }

    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int i = 1;
                while (set.contains(num + i)) {
                    i++;
                }
                result = Math.max(result, i);
            }
        }
        return result;
    }
}
