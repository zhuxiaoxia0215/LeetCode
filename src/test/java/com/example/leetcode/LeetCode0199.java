package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class LeetCode0199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        int count = 1;
        while (queue.size() != 0) {
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
                if (i == temp - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }

}
