package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class LeetCode0118 {

    @Test
    public void test() {
        System.out.println(generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        int[][] nums = new int[numRows][numRows];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            nums[i][0] = 1;
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    nums[i][j] = 1;
                    row.add(1);
                } else {
                    nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
                    row.add(nums[i][j]);
                }
            }
            result.add(row);
        }
        return result;
    }
}
