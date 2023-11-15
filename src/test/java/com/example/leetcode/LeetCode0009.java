package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 */
public class LeetCode0009 {

    @Test
    public void test() {
        System.out.println(isPalindrome1(121));
        System.out.println(isPalindrome1(-121));
        System.out.println(isPalindrome1(123));
        System.out.println(isPalindrome1(0));
        System.out.println(isPalindrome1(9));
        System.out.println(isPalindrome1(11));
    }

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        List<Integer> nums = new ArrayList<>();
        while (x > 0) {
            nums.add(x % 10);
            x = x / 10;
        }
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            if (nums.get(left) != nums.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 反转一半的数字
     */
    public boolean isPalindrome1(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int reverse = 0;
        while (reverse < x) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return x == reverse || x == reverse / 10;
    }
}
