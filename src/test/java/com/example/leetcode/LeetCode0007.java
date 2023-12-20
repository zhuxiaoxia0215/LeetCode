package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class LeetCode0007 {

    @Test
    public void test(){
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
    }


    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if( result > 214748364 || result < -214748364){
                return 0;
            }
            result = result * 10 + x % 10;
            x = x/10;
        }
        return result;
    }
}
