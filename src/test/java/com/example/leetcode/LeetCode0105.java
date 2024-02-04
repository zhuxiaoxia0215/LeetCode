package com.example.leetcode;

import java.util.Arrays;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class LeetCode0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = findIndex(inorder, preorder[0]);
        if (preorder.length > 0) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + index), Arrays.copyOfRange(inorder, 0, index));
        }
        if (inorder.length > 0) {
            root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        }
        return root;
    }

    int findIndex(int[] order, int target) {
        for (int i = 0; i < order.length; i++) {
            if (target == order[i]) {
                return i;
            }
        }
        return -1;
    }

}
