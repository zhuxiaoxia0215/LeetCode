package com.example.leetcode;

/**
 * 530. 二叉搜索树的最小绝对差
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class LeetCode0530 {

    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return result;
        }
        return Math.min(Math.min(getMinimumFromRoot(root, root.val), getMinimumDifference(root.left)), getMinimumDifference(root.right)) ;
    }

    int getMinimumFromRoot(TreeNode node, int root) {
        if (node == null) {
            return result;
        }
        if (node.left != null) {
            result = Math.min(result, Math.abs(root - node.left.val)) ;
        }
        if(node.right != null){
            result = Math.min(result, Math.abs(root - node.right.val));
        }
        return Math.min(Math.min(result, getMinimumFromRoot(node.left, root)), getMinimumFromRoot(node.right, root));
    }
}
