package com.example.leetcode;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class LeetCode0287 {
    public int findDuplicate(int[] nums) {
        int[] map = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            map[nums[i]] +=1;
        }
        for(int i = 1; i< map.length; i++){
            if(map[i] > 1){
                return i;
            }
        }
        return 0;
    }
}
