package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * <p>
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class LeetCode0994 {


    @Test
    public void test() {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    public int orangesRotting(int[][] grid) {
        int result = 0;
        int m = grid.length, n = grid[0].length, count = 0;
        Queue queue = new ArrayDeque();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        while (count > 0 && queue.size() > 0) {
            result++;
            int temp = queue.size();
            for (int i = 0; i < temp; i++) {
                int[] index = (int[]) queue.poll();
                int x = index[0], y = index[1];
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    queue.offer(new int[]{x + 1, y});
                    grid[x + 1][y] = 2;
                    count--;
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    queue.offer(new int[]{x - 1, y});
                    grid[x - 1][y] = 2;
                    count--;
                }

                if (y + 1 < n && grid[x][y + 1] == 1) {
                    queue.offer(new int[]{x, y + 1});
                    grid[x][y + 1] = 2;
                    count--;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    queue.offer(new int[]{x, y - 1});
                    grid[x][y - 1] = 2;
                    count--;
                }
            }
        }
        if (count > 0) {
            return -1;
        }
        return result;
    }
}
