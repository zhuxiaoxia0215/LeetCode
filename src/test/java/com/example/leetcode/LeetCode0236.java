package com.example.leetcode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 */
public class LeetCode0236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean pInLeft = hasChildren(root.left, p), qInLeft = hasChildren(root.left, q),
                pInRigth = hasChildren(root.right, p), qInRigth = hasChildren(root.right, q);
        // 如果两个节点分别在两侧
        if ((pInLeft && qInRigth) || pInRigth && qInLeft) {
            return root;
        }
        if (pInLeft && qInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (pInRigth && qInRigth) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public boolean hasChildren(TreeNode root, TreeNode p) {
        if(root == null){
            return false;
        }
        if (root == p) {
            return true;
        }
        return hasChildren(root.left, p) || hasChildren(root.right, p);
    }
}
