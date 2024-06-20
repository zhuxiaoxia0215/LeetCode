package com.example.leetcode;

import java.util.HashMap;

/**
 * 205. 同构字符串
 * <p>
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 示例 1:
 * <p>
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s = "paper", t = "title"
 * 输出：true
 */
public class LeetCode0205 {
    public boolean isIsomorphic(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) {
            return false;
        }
        HashMap<Character, Character> s2tMap = new HashMap<>();
        HashMap<Character, Character> t2sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s2tMap.containsKey(s.charAt(i))) {
                if (t.charAt(i) != s2tMap.get(s.charAt(i))) {
                    return false;
                }
            } else {
                if (t2sMap.containsKey(t.charAt(i))) {
                    return false;
                }
                s2tMap.put(s.charAt(i), t.charAt(i));
                t2sMap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

}
