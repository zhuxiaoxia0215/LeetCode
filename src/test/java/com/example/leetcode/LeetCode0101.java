package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class LeetCode0101 {

    class TreeNode {
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

    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(isSymmetric(root));
    }


    List<Integer> left = new ArrayList<>();
    List<Integer> rigth = new ArrayList<>();

    public boolean isSymmetric(TreeNode root) {
        traverLeft(root.left);
        traverRight(root.right);
        return left.equals(rigth);
    }

    public void traverLeft(TreeNode leftNode) {
        if (leftNode == null) {
            left.add(null);
            return;
        }
        left.add(leftNode.val);
        traverLeft(leftNode.left);
        traverLeft(leftNode.right);
    }

    public void traverRight(TreeNode rightNode) {
        if (rightNode == null) {
            rigth.add(null);
            return;
        }
        rigth.add(rightNode.val);
        traverRight(rightNode.right);
        traverRight(rightNode.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

}
