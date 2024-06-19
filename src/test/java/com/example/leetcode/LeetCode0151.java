package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 151. 反转字符串中的单词
 * <p>
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class LeetCode0151 {

    @Test
    public void test(){
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }


    public String reverseWords(String s) {
        List<String> result = new ArrayList<>();
        String[] split = s.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i] != "" && split[i] != " ") {
                result.add(split[i]);
            }
        }
        return String.join(" ", result);
    }
}
