package com.example.leetcode;

/**
 * 125.验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false
 */
public class LeetCode0125 {
    public boolean isPalindrome(String s) {
        boolean result = true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (a < 48 || (a > 57 && a < 65) || (a > 90 && a < 97) || a > 122) {
                i++;
                continue;
            }
            if (b < 48 || (b > 57 && b < 65) || (b > 90 && b < 97) || b > 122) {
                j--;
                continue;
            }
            if (a > 96) {
                a = (char) (a - 32);
            }
            if (b > 96) {
                b = (char) (b - 32);
            }
            if (a != b) {
                return false;
            }
            i++;
            j--;
        }
        return result;
    }
}
