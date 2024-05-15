package com.example.leetcode;

/**
 * 2180. 统计各位数字之和为偶数的整数个数
 * 给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
 * <p>
 * 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。
 */
public class LeetCode2180 {
    public int countEven(int num) {
        int count = 0;
        for(int i = 1; i <= num; i++){
            int sum = 0;
            int temp = i;
            while(temp > 0){
                sum += temp % 10;
                temp /= 10;
            }
            if(sum % 2 == 0){
                count++;
            }
        }
        return count;
    }

}
