package com.example.leetcode;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 202. 快乐数
 * <p>
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 */
public class LeetCode0202 {

    @Test
    public void test() {
        System.out.println(isHappy(2));
    }

    List<Integer> result = new ArrayList<>();

    public boolean isHappy(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n / 10 > 0) {
            nums.add(n % 10);
            n = n / 10;
        }
        nums.add(n);
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i) * nums.get(i);
        }
        if (sum == 1) {
            return true;
        } else if (result.contains(sum)) {
            return false;
        } else {
            result.add(sum);
            return isHappy(sum);
        }
    }
}
