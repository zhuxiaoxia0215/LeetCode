package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
 */
public class LeetCode2085 {

    @Test
    public void test(){
        System.out.println(countWords(new String[]{"leetcode","is","amazing","as","is"}, new String[]{"amazing","leetcode","is"}));
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> words1Occurrences = new HashMap<>();
        Map<String, Integer> words2Occurrences = new HashMap<>();

        // 统计words1中每个字符串的出现次数
        for (String word : words1) {
            words1Occurrences.put(word, words1Occurrences.getOrDefault(word, 0) + 1);
        }

        // 统计words2中每个字符串的出现次数
        for (String word : words2) {
            words2Occurrences.put(word, words2Occurrences.getOrDefault(word, 0) + 1);
        }

        // 找到在两个数组中都出现的字符串
        Set<String> commonOccurrences = new HashSet<>(words1Occurrences.keySet());
        commonOccurrences.retainAll(words2Occurrences.keySet());

        int count = 0;
        // 统计在两个数组中都恰好出现一次的字符串的数目
        for (String word : commonOccurrences) {
            if (words1Occurrences.get(word) == 1 && words2Occurrences.get(word) == 1) {
                count++;
            }
        }

        return count;
    }
}
