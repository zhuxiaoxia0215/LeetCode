package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 */
public class LeetCode0121 {

    @Test
    public void Test() {
        System.out.println(maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit1(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit1 = 0, minPrices = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrices) {
                minPrices = prices[i];
            } else if (prices[i] - minPrices > maxProfit1) {
                maxProfit1 = prices[i] - minPrices;
            }
        }
        return maxProfit1;
    }
}
