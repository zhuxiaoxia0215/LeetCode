package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * <p>
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
public class LeetCode0228 {

    @Test
    public void test() {
        System.out.println(String.join(",", summaryRanges(new int[]{0, 1, 2, 4, 5, 7})));
        System.out.println(String.join(",", summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9})));
    }

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            result.add(nums[0] + "");
            return result;
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    result.add(nums[i - 1] + "");
                } else {
                    result.add(nums[i - 1] - count + "->" + nums[i - 1]);
                    count = 0;
                }
            }
        }
        if (count == 0) {
            result.add(nums[n - 1] + "");
        } else {
            result.add((nums[n - 1] - count) + "->" + nums[n - 1]);
        }
        return result;
    }
}
