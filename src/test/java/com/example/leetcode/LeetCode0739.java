package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替
 */
public class LeetCode0739 {

    @Test
    public void test() {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        result[length - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(length - 1);
        for (int i = length - 2; i >= 0; i--) {
            int j = 0;
            while (!stack.isEmpty()) {
                j++;
                Integer pop = stack.pop();
                int prev = temperatures[pop];
                if (prev > temperatures[i]) {
                    result[i] = j;
                    stack.push(pop);
                    stack.push(i);
                    break;
                } else {
                    j += result[pop] - 1;
                }
            }
            if (result[i] == 0) {
                stack.push(temperatures[i]);
            }
        }
        return result;
    }
}
