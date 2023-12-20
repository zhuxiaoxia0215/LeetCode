package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LeetCode0017 {

    @Test
    public void test() {
        for (String letterCombination : letterCombinations("")) {
            System.out.println(letterCombination);
        }
    }


    public List<String> letterCombinations(String digits) {
        Map<Character, String> numMap = new HashMap() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> result = new ArrayList<>();
        StringBuffer combination = new StringBuffer();
        if (digits.length() == 0) {
            return result;
        }
        backtrack(digits, numMap, result, 0, combination);
        return result;
    }

    public void backtrack(String digits, Map<Character, String> numMap, List<String> result, int index, StringBuffer combination) {
        if (index == digits.length()) {
            result.add(combination.toString());
        } else {
            char ch = digits.charAt(index);
            String letters = numMap.get(ch);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backtrack(digits, numMap, result, index + 1, combination);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }
}
