package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
public class LeetCode0061 {
    @Test
    public void test() {
        rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode pre = head;
        int n = 1;
        while (pre.next != null) {
            pre = pre.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        pre.next = head;
        while (add-- > 0) {
            pre = pre.next;
        }
        ListNode ret = pre.next;
        pre.next = null;
        return ret;
    }
}
