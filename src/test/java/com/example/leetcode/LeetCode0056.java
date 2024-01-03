package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class LeetCode0056 {

    @Test
    public void test() {
        System.out.println(merge(new int[][]{{1, 4}, {0, 4}}));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] < intervals[i + 1][1]) {
                intervals[i + 1] = intervals[i];
            } else if (intervals[i][1] < intervals[i + 1][0]) {
                list.add(intervals[i]);
            } else {
                intervals[i + 1][0] = intervals[i][0];
            }
        }
        list.add(intervals[intervals.length - 1]);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
