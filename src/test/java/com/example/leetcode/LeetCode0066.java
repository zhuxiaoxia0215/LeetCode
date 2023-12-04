package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeetCode0066 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
