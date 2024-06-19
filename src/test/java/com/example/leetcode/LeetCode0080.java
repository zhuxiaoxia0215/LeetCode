package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 80. 删除有序数组中的重复项 II
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 */
public class LeetCode0080 {

    @Test
    public void test() {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3}));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int s = 2, f = 2;
        while (f < n) {
            if (nums[s - 2] != nums[f]) {
                nums[s] = nums[f];
                s++;
            }
            f++;
        }
        return s;
    }
}
