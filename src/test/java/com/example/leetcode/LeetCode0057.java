package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * <p>
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 返回插入之后的 intervals。
 * <p>
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class LeetCode0057 {

    @Test
    public void test() {
        insert(new int[][]{{1, 5}}, new int[]{2, 7});
        insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int left = newInterval[0], right = newInterval[1];
        boolean place = false;
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!place) {
                    result.add(new int[]{left, right});
                    place = true;
                }
                result.add(interval);
            } else if (interval[1] < left) {
                result.add(interval);
            } else {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }
        if (!place) {
            result.add(new int[]{left, right});
        }
        return result.toArray(new int[0][]);
    }
}
