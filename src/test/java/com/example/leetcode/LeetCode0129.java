package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 129. 求根节点到叶节点数字之和
 * <p>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 */
public class LeetCode0129 {
    public int sumNumbers(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                sum += node.val;
                continue;
            }
            if (node.left != null) {
                node.left.val = node.val * 10 + node.left.val;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val * 10 + node.right.val;
                queue.offer(node.right);
            }
        }
        return sum;
    }
}
