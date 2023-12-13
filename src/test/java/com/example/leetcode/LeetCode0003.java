package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeetCode0003 {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int result = 0;
        int i = 0, j = 1;
        while (j < s.length()) {
            char ch = s.charAt(j);
            int index = s.substring(i, j).indexOf(ch);
            if (index > -1) {
                result = Math.max(result, j - i);
                i = i + index + 1;
            }
            j++;
        }
        result = Math.max(result, j - i);
        return result;
    }
}
