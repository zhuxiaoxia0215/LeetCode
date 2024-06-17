package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 2965. 找出缺失和重复的数字
 * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n2] 范围内。除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
 * <p>
 * 任务是找出重复的数字a 和缺失的数字 b 。
 * <p>
 * 返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b
 */
public class LeetCode2965 {

    @Test
    public void test() {
        System.out.println(findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}}));
        System.out.println(findMissingAndRepeatedValues(new int[][]{{9, 1, 7}, {8, 9, 2}, {3, 4, 6}}));
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        int l = grid.length, r = grid[0].length;
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                if (f.containsKey(grid[i][j])) {
                    f.put(grid[i][j], f.get(grid[i][j]) + 1);
                } else {
                    f.put(grid[i][j], 1);
                }
            }
        }
        for (int i = 1; i < l * r + 1; i++) {
            if (f.get(i) == null) {
                result[1] = i;
                continue;
            }
            if (f.get(i) == 2) {
                result[0] = i;
            }
        }
        return result;
    }
}
