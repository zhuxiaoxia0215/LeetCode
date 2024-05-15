package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 55. 跳跃游戏
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class LeetCode0055 {

    @Test
    public void test() {
        canJump(new int[]{2, 3, 1, 1, 4});
    }


    public boolean canJump(int[] nums) {
        boolean result = false;
        int length = nums.length;
        if (length == 1) {
            return nums[0] > 0;
        }

        for (int i = length - 2; i >= 0; i--) {
            if (i == 0) {
                return nums[i] + i + 1 >= length;
            }

            if (nums[i] + i + 1 >= length) {
                int[] newArray = new int[length - 1];
                System.arraycopy(nums, 0, newArray, 0, length - 1);
                return canJump(newArray);
            } else {
                continue;
            }
        }
        return result;
    }
}
