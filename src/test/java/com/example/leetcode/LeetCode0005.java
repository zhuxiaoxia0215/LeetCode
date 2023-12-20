package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class LeetCode0005 {

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("abcdefghijklmno"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        int begin = 0, end = 0, length = 1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i + 1 < len) {
                dp[i][i + 1] = chars[i] == chars[i + 1];
                if (dp[i][i + 1] == true && length < 2) {
                    length = 2;
                    begin = i;
                    end = i + 1;
                }
            }
            if (i + 2 < len) {
                dp[i][i + 2] = chars[i] == chars[i + 2];
                if (dp[i][i + 2] == true && length < 3) {
                    length = 3;
                    begin = i;
                    end = i + 2;
                }
            }

        }
        for (int L = 3; L < len; L++) {
            for (int i = 0; i < len; i++) {
                int j = i + L;
                if (j < len) {
                    dp[i][j] = dp[i + 1][j - 1] && chars[i] == chars[j];
                    if (dp[i][j] == true && j - i + 1 > length) {
                        length = j - i + 1;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin, end+1);
    }
}
