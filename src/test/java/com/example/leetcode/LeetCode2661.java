package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;


/**
 * 给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。
 * <p>
 * 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
 * <p>
 * 请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。
 */
public class LeetCode2661 {

    @Test
    public void test() {
        System.out.println(firstCompleteIndex1(new int[]{1, 3, 4, 2}, new int[][]{{1, 4}, {2, 3}}));
        System.out.println(firstCompleteIndex1(new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9}, new int[][]{{3, 2, 5}, {1, 4, 6}, {8, 7, 9}}));
    }

    // 超时了
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int minIndex = arr.length - 1, line = mat.length, row = mat[0].length;
        for (int i = 0; i < line; i++) {
            int maxIndex = 0;
            for (int j = 0; j < row; j++) {
                maxIndex = Math.max(findIndex(arr, mat[i][j]), maxIndex);
            }
            minIndex = Math.min(minIndex, maxIndex);
        }
        for (int j = 0; j < row; j++) {
            int maxIndex = 0;
            for (int i = 0; i < line; i++) {
                maxIndex = Math.max(findIndex(arr, mat[i][j]), maxIndex);
            }
            minIndex = Math.min(minIndex, maxIndex);
        }
        return minIndex;
    }

    public int findIndex(int[] arr, int key) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int firstCompleteIndex1(int[] arr, int[][] mat) {
        int minIndex = 0, col = mat.length, row = mat[0].length;
        HashMap<Integer, Object> matMap = new HashMap();
        int[] colCnt = new int[col], rowCnt = new int[row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                matMap.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int k = 0; k < arr.length; k++) {
            int[] matIndex = (int[]) matMap.get(arr[k]);
            colCnt[matIndex[0]]++;
            rowCnt[matIndex[1]]++;
            if (colCnt[matIndex[0]] == row || rowCnt[matIndex[1]] == col) {
                minIndex = k;
                break;
            }
        }
        return minIndex;
    }

}
