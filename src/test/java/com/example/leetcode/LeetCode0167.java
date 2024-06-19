package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 167. 两数之和 II - 输入有序数组
 * <p>
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2]
 */
public class LeetCode0167 {

    @Test
    public void test() {
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int length = numbers.length;
        int num = 0;
        for (int i = 0; i < length; i++) {
            num = target - numbers[i];
            for (int j = i + 1; j < length; j++) {
                if (numbers[j] == num) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return result;
    }
}
