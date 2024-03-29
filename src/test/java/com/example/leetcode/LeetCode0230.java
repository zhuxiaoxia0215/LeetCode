package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class LeetCode0230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list.get(k - 1);
    }

    void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        preOrder(root.left, list);
        list.add(root.val);
        preOrder(root.right, list);
    }
}
