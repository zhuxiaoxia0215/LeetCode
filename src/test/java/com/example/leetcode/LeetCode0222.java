package com.example.leetcode;

/**
 * 222. 完全二叉树的节点个数
 * <p>
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class LeetCode0222 {

    int count = 1;

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return count;
        }
        return count + countNodes(root.left) + countNodes(root.right);
    }
}
