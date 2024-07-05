package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 */
public class LeetCode0117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new ArrayDeque<>();
            int count = 1;
            queue.offer(root);
            while (!queue.isEmpty()) {
                int temp = count;
                count = 0;
                for (int i = 0; i < temp; i++) {
                    Node node = queue.poll();
                    if (i == temp - 1) {
                        node.next = null;
                    } else {
                        node.next = queue.peek();
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                        count++;
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                        count++;
                    }
                }
            }
            return root;
        }
    }
}
