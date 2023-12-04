package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 *
 * 提醒一下， 二叉搜索树 满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 *
 * 提醒一下， 二叉搜索树 满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class LeetCode1038 {


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

    // 中序遍历
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        middleTraversal(root, tree);
        int[] sums = new int[tree.size()];
        int sum = 0;
        for(int i = tree.size()-1; i >= 0; i++){
            sum += tree.get(i);
            sums[i] =  sum;
        }
        setGstVal(root, tree, sums);
        return root;
    }

    int sum = 0;
    public TreeNode bstToGst1(TreeNode root) {
        bstToGst(root.right);
        sum = sum +root.val;
        root.val =sum;
        bstToGst(root.left);
        return root;
    }

    public void middleTraversal (TreeNode root, List tree){
        if(root == null){
            return;
        }
        middleTraversal(root.left, tree);
        tree.add(root.val);
        middleTraversal(root.right, tree);
    }

    public void setGstVal(TreeNode root, List tree, int[] sums){
        root.val = sums[tree.indexOf(root.val)];
        setGstVal(root.left, tree, sums);
        setGstVal(root.right, tree,sums);
    }

}
