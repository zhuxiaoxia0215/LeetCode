package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LeetCode0014 {

    @Test
    public void test() {
        System.out.println(longestCommonPrefix1(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix1(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix1(new String[]{"a", "b"}));
        System.out.println(longestCommonPrefix1(new String[]{"abc", "ab", "abc"}));
    }

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (str1, str2) -> str1.length() - str2.length());
        String prefix = "";
        int i;
        for (i = 0; i <= strs[0].length(); i++) {
            prefix = strs[0].substring(0, i);
            boolean isPre = false;
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    isPre = true;
                    break;
                }
            }
            if (isPre) {
                return strs[0].substring(0, i - 1);
            }
        }
        return strs[0];
    }
    
    
    public String longestCommonPrefix1(String[] strs){
        String prefix = strs[0];
        for(int i = 1 ; i< strs.length; i++){
            prefix = commonPrefix(strs[i], prefix);
        }
        return prefix;
    }

    private String commonPrefix(String str, String prefix) {
        int length = Math.min(str.length(), prefix.length()), i;
        for( i = 0; i<length;i++){
            if(str.charAt(i) != prefix.charAt(i)){
                break;
            }
        }
        return str.substring(0,i);
    }

}
