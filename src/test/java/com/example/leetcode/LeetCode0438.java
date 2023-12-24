package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */
public class LeetCode0438 {

    @Test
    public void test() {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        char[] array = p.toCharArray();
        Arrays.sort(array);
        String key = new String(array);
        List<Integer> result = new ArrayList<>();
        int len = p.length();
        for (int i = 0; i < s.length() - len + 1; i++) {
            char[] tmp = s.substring(i, i + len).toCharArray();
            Arrays.sort(tmp);
            if (key.equals(new String(tmp))) {
                result.add(i);
            }
        }
        return result;
    }
}
