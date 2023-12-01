package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class LeetCode0144 {

    @Test
    public void Test() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2, new TreeNode(3), null);
        preorderTraversal(root).stream().forEach(val -> System.out.println(val));
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preList = new ArrayList<>();
        if (root == null) {
            return preList;
        }
        preList.add(root.val);
        preList.addAll(preorderTraversal(root.left));
        preList.addAll(preorderTraversal(root.right));
        return preList;
    }
}
