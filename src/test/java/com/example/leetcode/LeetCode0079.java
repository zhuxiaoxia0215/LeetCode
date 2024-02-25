package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class LeetCode0079 {

    boolean exist;

    @Test
    public void test() {
        System.out.println(exist(new char[][]{{'A', 'B'}}, "BA"));
    }

    public boolean exist(char[][] board, String word) {
        StringBuilder str = new StringBuilder();

        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                str.append(board[i][j]);
                dfs(str, board, i, j, word, isVisited);
                str.deleteCharAt(str.length() - 1);
                if (exist) {
                    return exist;
                }
                isVisited = new boolean[board.length][board[0].length];
            }
        }
        return exist;
    }

    public void dfs(StringBuilder str, char[][] board, int x, int y, String word, boolean[][] isVisited) {
        isVisited[x][y] = true;
        if (str.length() == word.length() && !str.toString().equals(word)) {
            return;
        }
        if (str.toString().equals(word)) {
            exist = true;
            return;
        }
        if (x - 1 >= 0 && !isVisited[x - 1][y]) {
            str.append(board[x - 1][y]);
            dfs(str, board, x - 1, y, word, isVisited);
            if (exist) {
                return;
            }
            isVisited[x - 1][y] = false;
            str.deleteCharAt(str.length() - 1);
        }

        if (y - 1 >= 0 && !isVisited[x][y - 1]) {
            str.append(board[x][y - 1]);
            dfs(str, board, x, y - 1, word, isVisited);
            if (exist) {
                return;
            }
            isVisited[x][y - 1] = false;
            str.deleteCharAt(str.length() - 1);
        }

        if (x + 1 < board.length && !isVisited[x + 1][y]) {
            str.append(board[x + 1][y]);
            dfs(str, board, x + 1, y, word, isVisited);
            if (exist) {
                return;
            }
            isVisited[x + 1][y] = false;
            str.deleteCharAt(str.length() - 1);
        }

        if (y + 1 < board[0].length && !isVisited[x][y + 1]) {
            str.append(board[x][y + 1]);
            dfs(str, board, x, y + 1, word, isVisited);
            if (exist) {
                return;
            }
            isVisited[x][y + 1] = false;
            str.deleteCharAt(str.length() - 1);
        }
    }
}
