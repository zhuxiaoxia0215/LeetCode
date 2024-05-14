package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class LeetCode0394 {

    @Test
    public void test() {
        System.out.println(decodeString("abc3[cd]xyz"));
    }

    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c > 47 && c < 59) {
                stack.push(c);
            } else if (c == '[') {
                stack.push(c);
            } else if (c == ']') {
                stack.
            }
        }
        StringBuilder tmp = new StringBuilder();
        int num = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '[') {
                int i = 0, nums = 0;
                while (!stack.isEmpty() && stack.peek() > 47 && stack.peek() < 59) {
                    i = i + (stack.pop() - 48) * (int) Math.pow(10, nums);
                    nums++;
                }
                String str1 = tmp.toString();
                while (i > 1) {
                    tmp.insert(0, str1);
                    i--;
                }

                num--;
                if (num == 0) {
                    str.insert(0, tmp);
                    tmp = new StringBuilder();
                }
            } else if (c == ']') {
                num++;
                str.append(tmp);
                tmp = new StringBuilder();
            } else if (c > 96 && c < 123) {
                tmp = tmp.insert(0, c);
            }
        }
        str.insert(0, tmp);
        return str.toString();
    }
}
