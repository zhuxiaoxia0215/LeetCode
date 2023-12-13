package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 给你一个由 小写英文字母 组成的字符串 s ，你可以对其执行一些操作。在一步操作中，你可以用其他小写英文字母 替换  s 中的一个字符。
 * <p>
 * 请你执行 尽可能少的操作 ，使 s 变成一个 回文串 。如果执行 最少 操作次数的方案不止一种，则只需选取 字典序最小 的方案。
 * <p>
 * 对于两个长度相同的字符串 a 和 b ，在 a 和 b 出现不同的第一个位置，如果该位置上 a 中对应字母比 b 中对应字母在字母表中出现顺序更早，则认为 a 的字典序比 b 的字典序要小。
 * <p>
 * 返回最终的回文字符串。
 */
public class LeetCode2697 {

    @Test
    public void Test() {
        System.out.println(makeSmallestPalindrome1("egcfe"));
        System.out.println(makeSmallestPalindrome1("abcd"));
        System.out.println(makeSmallestPalindrome1("seven"));
    }

    public String makeSmallestPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left), r = s.charAt(right);
            if (l != r) {
                if (l > r) {
                    s = replaceChar(s, left, r);
                } else {
                    s = replaceChar(s, right, l);
                }
            }
            left++;
            right--;
        }
        return s;
    }

    public String makeSmallestPalindrome1(String s) {
        char[] chars = s.toCharArray();
        int left = 0, rigth = chars.length - 1;
        while (left < rigth) {
            if (chars[left] != chars[rigth]) {
                chars[left] = chars[rigth] = (char) Math.min(chars[left], chars[rigth]);
            }
            left++;
            rigth--;
        }
        return new String(chars);
    }

    public String replaceChar(String s, int index, char ch) {
        char[] chars = s.toCharArray();
        chars[index] = ch;
        String newStr = String.valueOf(chars);
        return newStr;
    }
}
