package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class LeetCode0103 {

    @Test
    public void test(){
        zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean isReverse = false;
        int count = 1;
        while (!deque.isEmpty()) {
            int temp = count;
            count = 0;
            List<Integer> list = new ArrayList<>();
            if (!isReverse) {
                for (int i = 0; i < temp; i++) {
                    TreeNode node = deque.pop();
                    list.add(node.val);
                    if (node.left != null) {
                        deque.offer(node.left);
                        count++;
                    }
                    if (node.right != null) {
                        deque.offer(node.right);
                        count++;
                    }
                }
            } else {
                for (int i = 0; i < temp; i++) {
                    TreeNode node = deque.removeLast();
                    list.add(node.val);
                    if (node.right != null) {
                        deque.push(node.right);
                        count++;
                    }
                    if (node.left != null) {
                        deque.push(node.left);
                        count++;
                    }
                }
            }
            isReverse = !isReverse;
            result.add(list);
        }
        return result;
    }
}
