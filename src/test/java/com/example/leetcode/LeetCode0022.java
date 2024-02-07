package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class LeetCode0022 {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        dfs(str, 0, 0, n);
        return result;
    }

    public void dfs(StringBuilder str, int open, int end, int n) {
        if (str.length() == n * 2) {
            result.add(str.toString());
        }
        if (open < n) {
            str.append('(');
            dfs(str, open + 1, end, n);
            str.deleteCharAt(str.length() - 1);
        }
        if (end < open) {
            str.append(")");
            dfs(str, open, end + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
