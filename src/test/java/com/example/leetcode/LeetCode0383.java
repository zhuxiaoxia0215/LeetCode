package com.example.leetcode;

/**
 * 383. 赎金信
 * <p>
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */
public class LeetCode0383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuffer buffer = new StringBuffer(magazine);
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = buffer.indexOf(String.valueOf(ransomNote.charAt(i)));
            if (index > -1) {
                buffer.deleteCharAt(index);
            }else{
                return false;
            }
        }
        return true;
    }
}
