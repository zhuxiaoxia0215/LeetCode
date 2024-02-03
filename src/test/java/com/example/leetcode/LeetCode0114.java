package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class LeetCode0114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        preOrder(root, queue);
        queue.poll();
        TreeNode temp = queue.poll();
        root.right = temp;
        root.left = null;
        while (queue.size() != 0) {
            temp.right = queue.poll();
            temp.left = null;
            temp = temp.right;
        }
    }

    void preOrder(TreeNode root, Queue queue) {
        if (root == null) {
            return;
        }
        queue.offer(root);
        preOrder(root.left, queue);
        preOrder(root.right, queue);
    }
}
