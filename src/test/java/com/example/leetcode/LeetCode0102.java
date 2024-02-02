package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LeetCode0102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        int count = 1;
        while (queue.size() != 0) {
            List<Integer> level = new ArrayList<>();
            int temp = count;
            count = 0;
            for (int i = 0; i < temp; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    count++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    count++;
                }
                level.add(node.val);
            }
            result.add(level);
        }

        return result;
    }
}
