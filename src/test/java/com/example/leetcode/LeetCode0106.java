package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 */
public class LeetCode0106 {

    @Test
    public void test() {
        buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if (n == 0) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[n - 1]);
        int index = findIndex(inorder, postorder[n - 1]);
        int[] leftInorder = new int[index];
        int[] leftPostorder = new int[index];
        for (int i = 0; i < index; i++) {
            leftInorder[i] = inorder[i];
            leftPostorder[i] = postorder[i];
        }
        int[] rightInorder = new int[n - index - 1];
        int[] rightPostorder = new int[n - index - 1];
        for (int i = 0; i < n - index - 1; i++) {
            rightInorder[i] = inorder[index + 1 + i];
            rightPostorder[i] = postorder[index + i];
        }
        node.left = buildTree(leftInorder, leftPostorder);
        node.right = buildTree(rightInorder, rightPostorder);
        return node;
    }

    public int findIndex(int[] inorder, int num) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == num) {
                return i;
            }
        }
        return 0;
    }
}
