package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class LeetCode0073 {

    @Test
    public void test() {
        setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    }

    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int[] ints : list) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[ints[0]][i] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][ints[1]] = 0;
            }
        }
    }
}
