package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class LeetCode0070 {

    @Test
    public void test() {
        System.out.println(climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int climbStairs1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int dp1 = 1, dp2 = 2, tmp;
        for (int i = 2; i < n; i++) {
            tmp = dp2;
            dp2 = dp1 + dp2;
            dp1 = tmp;
        }
        return dp2;
    }
}
