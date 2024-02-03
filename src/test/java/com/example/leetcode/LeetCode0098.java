package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class LeetCode0098 {

    @Test
    public void test() {
        System.out.println(isValidBST(new TreeNode(2, new TreeNode(2), new TreeNode(2))));
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        preOrder(root.left, list);
        list.add(root.val);
        preOrder(root.right, list);
    }
}
