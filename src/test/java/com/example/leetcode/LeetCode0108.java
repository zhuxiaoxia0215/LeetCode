package com.example.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class LeetCode0108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int start = nums.length / 2;
        return new TreeNode(nums[start], sortedArrayToBST(Arrays.copyOfRange(nums, 0, start)), sortedArrayToBST(Arrays.copyOfRange(nums, start + 1, nums.length)));
    }
}
