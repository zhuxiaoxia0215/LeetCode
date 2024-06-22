package com.example.leetcode;

/**
 * 36. 有效的数独
 * <p>
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 */
public class LeetCode0036 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1';
                    if (row[i][index] != 0 || col[index][j] != 0 || subboxes[i / 3][j / 3][index] != 0) {
                        return false;
                    }
                    row[i][index] = 1;
                    col[index][j] = 1;
                    subboxes[i / 3][j / 3][index] = 1;
                }
            }
        }
        return true;
    }
}
