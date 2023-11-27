package com.example.odTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class ODTest01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        ArrayList<Integer> inList = new ArrayList<>();
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            inList.add(in.nextInt());
        }
        TreeNode root = helper(inList, 0);
        System.out.println(meaasgeSendTime(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static TreeNode helper(ArrayList<Integer> inList, int index) {
        if (index >= inList.size() || inList.get(index) == -1) {
            return null;
        }
        TreeNode root = new TreeNode(inList.get(index));
        root.left = helper(inList, 2 * index + 1);
        root.right = helper(inList, 2 * index + 2);
        return root;
    }

    public static int meaasgeSendTime(TreeNode root) {
        return dfs(root, new TreeNode(0), 0);
    }

    public static int dfs(TreeNode node, TreeNode parent, int time) {
        if (node == null) {
            return time;
        }
        time += node.val;
        return Math.max(dfs(node.left, node, time), dfs(node.right, node, time));
    }
}
