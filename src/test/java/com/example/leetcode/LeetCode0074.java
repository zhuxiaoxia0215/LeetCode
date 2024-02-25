package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * <p>
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class LeetCode0074 {

    @Test
    public void test() {
        searchMatrix(new int[][]{{1}}, 1);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1, n = matrix[0].length - 1;
        int left = 0, right = m, middle;
        while (left < right) {
            middle = (left + right) / 2;
            if (matrix[middle][n] == target) {
                return true;
            } else if (matrix[middle][n] < target) {
                left = middle + 1;
            } else if (matrix[middle][n] > target) {
                right = middle;
            }
        }
        int[] nums = matrix[right];
        left = 0;
        right = n;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                return true;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        return false;
    }
}
