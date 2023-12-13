package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class LeetCode0283 {

    @Test
    public void test() {
        int[] nums = new int[]{0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j++];
            } else {
                j++;
            }
        }
        for (int k = i; k < j; k++) {
            nums[k] = 0;
        }
    }
}
