package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 */
public class LeetCode0645 {

    @Test
    public void test() {
        System.out.println(findErrorNums(new int[]{2, 3, 2}));
    }

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] array = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]] += 1;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] > 1) {
                result[0] = i;
            }
            if (array[i] == 0) {
                result[1] = i;
            }
        }
        return result;
    }
}
