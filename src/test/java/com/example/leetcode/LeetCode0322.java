package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class LeetCode0322 {

    @Test
    public void test() {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    }

    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        f[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (f[i - coins[j]] != -1) {
                        min = Math.min(min, f[i - coins[j]]);
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                f[i] = -1;
            } else {
                f[i] = min + 1;
            }
        }
        return f[amount];
    }
}
