package com.example.leetcode;

import java.util.HashMap;

/**
 * 290. 单词规律
 * <p>
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 */
public class LeetCode0290 {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        HashMap<Character, String> p2sMap = new HashMap<>();
        HashMap<String, Character> s2pMap = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (p2sMap.containsKey(pattern.charAt(i))) {
                if (!split[i].equals(p2sMap.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                if (s2pMap.containsKey(split[i])) {
                    return false;
                }
                p2sMap.put(pattern.charAt(i), split[i]);
                s2pMap.put(split[i], pattern.charAt(i));
            }
        }
        return true;
    }
}
