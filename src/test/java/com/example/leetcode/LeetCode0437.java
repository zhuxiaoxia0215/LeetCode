package com.example.leetcode;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class LeetCode0437 {
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        return rootSum(root, targetSum) + pathSum(root.left, targetSum)+ pathSum(root.right , targetSum);
    }

    public int rootSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val == targetSum) {
            res = 1;
        }
        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);
        return res;
    }
}
