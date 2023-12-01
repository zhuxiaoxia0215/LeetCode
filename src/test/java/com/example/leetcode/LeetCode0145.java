package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class LeetCode0145 {

    @Test
    public void Test() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2, new TreeNode(3), null);
        postorderTraversal(root).stream().forEach(val -> System.out.println(val));
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> preList = new ArrayList<>();
        if (root == null) {
            return preList;
        }
        preList.addAll(postorderTraversal(root.left));
        preList.addAll(postorderTraversal(root.right));
        preList.add(root.val);
        return preList;
    }
}
