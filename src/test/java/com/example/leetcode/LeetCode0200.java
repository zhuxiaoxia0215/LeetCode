package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class LeetCode0200 {

    public int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                if (grid[i][j] == '1') {
                    result++;
                    isVisited[i][j] = true;
                }
                dfs(grid, i, j, isVisited);
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] isVisited) {
        int m = grid.length, n = grid[0].length;
        if (i >= m || j >= n) {
            return;
        }
        isVisited[i][j] = true;
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !isVisited[i - 1][j]) {
            dfs(grid, i - 1, j, isVisited);
            isVisited[i - 1][j] = true;
        }
        if (i + 1 < m && grid[i + 1][j] == '1' && !isVisited[i + 1][j]) {
            dfs(grid, i + 1, j, isVisited);
            isVisited[i + 1][j] = true;
        }

        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !isVisited[i][j - 1]) {
            dfs(grid, i, j - 1, isVisited);
            isVisited[i][j - 1] = true;
        }

        if (j + 1 < n && grid[i][j + 1] == '1' && !isVisited[i][j + 1]) {
            dfs(grid, i, j + 1, isVisited);
            isVisited[i][j + 1] = true;
        }
    }
}
