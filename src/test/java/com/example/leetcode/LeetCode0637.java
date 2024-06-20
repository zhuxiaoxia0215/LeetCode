package com.example.leetcode;

import java.util.*;

/**
 * 637. 二叉树的层平均值
 * <p>
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 */
public class LeetCode0637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 1;
        double sum = 0;
        while (!queue.isEmpty()) {
            int temp = count;
            count = 0;
            for (int i = 0; i < temp; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                    count++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    count++;
                }
            }
            result.add(sum / temp);
            sum = 0;
        }
        return result;
    }
}
