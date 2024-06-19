package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 */
public class LeetCode0122 {

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int[] profitSum = new int[prices.length];
        Arrays.fill(profitSum, -1);
        return profit(prices, profitSum);
    }

    int profit(int[] prices, int[] profitSum) {
        int length = prices.length;
        int profit = 0;
        for (int i = 0; i < length - 1; i++) {
            int sum = 0;
            for (int j = i + 1; j < length; j++) {
                if (prices[j] > prices[i]) {
                    sum += prices[j] - prices[i];
                    if (profitSum[profitSum.length - (length - j)] == -1) {
                        int[] subArray = new int[length - j];
                        System.arraycopy(prices, j, subArray, 0, length - j);
                        profitSum[profitSum.length - (length - j)] = profit(subArray, profitSum);
                    }
                    sum += profitSum[profitSum.length - (length - j)];
                    profit = Math.max(sum, profit);
                    sum = 0;
                }
            }
        }
        return profit;
    }

}
